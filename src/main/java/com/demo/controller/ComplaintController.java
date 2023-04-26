package com.demo.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.demo.model.ComplaintVO;
import com.demo.model.LoginVO;
import com.demo.service.ComplaintService;
import com.demo.service.LoginService;
import com.demo.utils.BaseMethods;

@Controller
public class ComplaintController {
	
	@Autowired
	ComplaintService complaintService;

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="employee/loadComplaint",method=RequestMethod.GET)
	public ModelAndView loadComplaint(){
		return new ModelAndView("employee/addComplaint","ComplaintVO",new ComplaintVO());	
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="employee/insertComplaint",method=RequestMethod.POST)
	public ModelAndView insertComplaint(@ModelAttribute ComplaintVO complaintVO,
			HttpServletRequest request, 
			@RequestParam("complaintFileToUpload") MultipartFile complaintFileName){
		
			String path = request.getSession().getServletContext().getRealPath("/");
			String complaintFileNameToInsert = complaintFileName.getOriginalFilename();
			String complaintFilePath = path + "documents\\complaints\\"; 
			
			try {
				byte barr[]=complaintFileName.getBytes();  
				
		        BufferedOutputStream bout=new BufferedOutputStream(  
		                 new FileOutputStream(complaintFilePath+"/"+complaintFileNameToInsert));  
		        
		        bout.write(barr);  
		        bout.flush();  
		        bout.close();
		        
		        
		        Date date = new Date();
		        DateFormat d = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		        
		        
		        String userName = BaseMethods.getCurrentUser();
		        
		        List userList = loginService.searchByUserName(userName);
		        
		        LoginVO loginVO = (LoginVO) userList.get(0);
		        
		        complaintVO.setLoginVO(loginVO);
		        complaintVO.setComplaintDate(d.format(date));
		        complaintVO.setComplaintFileName(complaintFileNameToInsert);
		        complaintVO.setComplaintFilePath(complaintFilePath);
		        
		        complaintVO.setStatus(true);
		        
		        this.complaintService.insert(complaintVO);
		        
		        
			} catch (Exception e) {
				e.printStackTrace();
			}

		return new ModelAndView ("redirect:/employee/loadComplaint");
	}

	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/viewComplaint",method=RequestMethod.GET)
	public ModelAndView viewComplaint(){
		List complaintList = this.complaintService.search();
		
		return new ModelAndView ("admin/viewComplaint","complaintList",complaintList);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="employee/viewEmployeeComplaint",method=RequestMethod.GET)
	public ModelAndView viewEmployeeComplaint(@ModelAttribute ComplaintVO complaintVO){
		
		String userName = BaseMethods.getCurrentUser();
		
        List userList = loginService.searchByUserName(userName);
        
        LoginVO loginVO = (LoginVO) userList.get(0);
        
        complaintVO.setLoginVO(loginVO);

		List complaintList = this.complaintService.search(complaintVO);
		
		return new ModelAndView ("employee/viewEmployeeComplaint","complaintList",complaintList);
	}

	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/replyComplaint",method=RequestMethod.GET)
	public ModelAndView replyComplaint(@RequestParam String complaintId,@ModelAttribute ComplaintVO complaintVO){
		
		complaintVO.setId(Integer.parseInt(complaintId));
		List complaintList = complaintService.reply(complaintVO);
		return new ModelAndView("admin/replyComplaint","complaintVO",(ComplaintVO)complaintList.get(0));
	}

	@RequestMapping(value="admin/updateComplaint",method=RequestMethod.POST)
	public ModelAndView updateComplaint(@ModelAttribute ComplaintVO complaintVO){
		 Date date = new Date();
	     DateFormat d = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	       
	    complaintVO.setReplyDate(d.format(date));
		complaintVO.setComplaintSatus("Resolved");
		complaintVO.setStatus(true);
		complaintService.update(complaintVO);
		return new ModelAndView("redirect:/admin/viewComplaint");
	}
	
}



