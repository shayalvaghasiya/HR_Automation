package com.demo.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
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

import com.demo.model.LetterTypeVO;
import com.demo.service.LetterTypeService;

@Controller
public class LetterTypeController {

	@Autowired
	LetterTypeService lettertypeService;
	
	@RequestMapping(value="admin/loadLetterType",method=RequestMethod.GET)
	public ModelAndView loadLetterType(){
		return new ModelAndView("admin/addLetterType","LetterTypeVO",new LetterTypeVO());
	}
		
	@RequestMapping(value="admin/insertLetterType",method=RequestMethod.POST)
	public ModelAndView insertLetterType(@ModelAttribute LetterTypeVO lettertypeVO,
			HttpServletRequest request, 
			@RequestParam("letterTypeFileToUpload") MultipartFile letterTypeFileName){
		
			String path = request.getSession().getServletContext().getRealPath("/");
			String letterTypeFileNameToInsert = letterTypeFileName.getOriginalFilename();
			String letterTypeFilePath = path + "documents\\letters\\"; 
			
			try {
				byte barr[]=letterTypeFileName.getBytes();  
				
		        BufferedOutputStream bout=new BufferedOutputStream(  
		                 new FileOutputStream(letterTypeFilePath+"/"+letterTypeFileNameToInsert));  
		        
		        bout.write(barr);  
		        bout.flush();  
		        bout.close();
		        
		        lettertypeVO.setLetterTypeFileName(letterTypeFileNameToInsert);
		        lettertypeVO.setLetterTypeFilePath(letterTypeFilePath);
		        
		        lettertypeVO.setStatus(true);
		        
		        this.lettertypeService.insert(lettertypeVO);
		        
		        
			} catch (Exception e) {
				e.printStackTrace();
			}

		return new ModelAndView ("redirect:/admin/loadLetterType");
	}
	
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/viewLetterType",method=RequestMethod.GET)
	public ModelAndView viewLetterType(){
		List letterTypeList = this.lettertypeService.search();
		
		return new ModelAndView ("admin/viewLetterType","letterTypeList",letterTypeList);
		
		
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="employee/viewEmployeeLetterType",method=RequestMethod.GET)
	public ModelAndView viewEmployeeLetterType(){
		List letterTypeList = this.lettertypeService.search();
		
		return new ModelAndView ("employee/viewEmployeeLetterType","letterTypeList",letterTypeList);
		
		
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/deleteLetterType",method=RequestMethod.GET)
	public ModelAndView deleteLetterType(@RequestParam String letterTypeId,@ModelAttribute LetterTypeVO lettertypeVO){

		lettertypeVO.setId(Integer.parseInt(letterTypeId));
		List letterTypeList = lettertypeService.delete(lettertypeVO);

		LetterTypeVO lettertypeVO2 = (LetterTypeVO) letterTypeList.get(0);
		lettertypeVO2.setStatus(false);
		
		lettertypeService.update(lettertypeVO2);
		
		return new ModelAndView("redirect:/admin/viewLetterType");	
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/editLetterType",method=RequestMethod.GET)
	public ModelAndView editLetterType(@RequestParam String letterTypeId,@ModelAttribute LetterTypeVO lettertypeVO){
		
		System.out.println("INn CONtroller ID>>>>>>"+letterTypeId);
		lettertypeVO.setId(Integer.parseInt(letterTypeId));
		List letterTypeList = lettertypeService.edit(lettertypeVO);
		return new ModelAndView("admin/editLetterType","LetterTypeVO",(LetterTypeVO)letterTypeList.get(0));
	}
	
	@RequestMapping(value="updateLetterType",method=RequestMethod.POST)
	public ModelAndView updateLetterType(@ModelAttribute LetterTypeVO lettertypeVO,HttpServletRequest request, 
			@RequestParam("letterTypeFileToUpload") MultipartFile letterTypeFileName){

		String path = request.getSession().getServletContext().getRealPath("/");
		String letterTypeFileNameToInsert = letterTypeFileName.getOriginalFilename();
		String letterTypeFilePath = path + "documents\\letters\\"; 
		
		try {
			byte barr[]=letterTypeFileName.getBytes();  
			
	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream(letterTypeFilePath+"/"+letterTypeFileNameToInsert));  
	        
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();
	        
	        lettertypeVO.setLetterTypeFileName(letterTypeFileNameToInsert);
	        lettertypeVO.setLetterTypeFilePath(letterTypeFilePath);
	        
	        lettertypeVO.setStatus(true);
	        
	        this.lettertypeService.update(lettertypeVO);
	        
	        
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/admin/viewLetterType");
	}

	
}
