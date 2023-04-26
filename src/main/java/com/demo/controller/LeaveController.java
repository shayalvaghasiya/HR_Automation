package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.LeaveVO;
import com.demo.service.LeaveService;

@Controller
public class LeaveController {

	@Autowired
	LeaveService leaveService;
	

	@RequestMapping(value="admin/loadLeave",method=RequestMethod.GET)
	public ModelAndView loadLeave(){
		return new ModelAndView("admin/addLeave","LeaveVO",new LeaveVO());	
	}
	
	@RequestMapping(value="admin/insertLeave",method=RequestMethod.POST)
	public ModelAndView insertLeave(@ModelAttribute LeaveVO leaveVO){
		leaveVO.setStatus(true);
		this.leaveService.insert(leaveVO);
		return new ModelAndView("redirect:/admin/loadLeave");	
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/viewLeave",method=RequestMethod.GET)
	public ModelAndView viewLeave(){
		List leaveList = this.leaveService.search();
		return new ModelAndView("admin/viewLeave","leaveList",leaveList);	
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/deleteLeave",method=RequestMethod.GET)
	public ModelAndView deleteLeave(@RequestParam String leaveId,@ModelAttribute LeaveVO leaveVO){

		leaveVO.setId(Integer.parseInt(leaveId));
		List leaveList = leaveService.delete(leaveVO);

		LeaveVO leaveVO2 = (LeaveVO) leaveList.get(0);
		leaveVO2.setStatus(false);
		
		leaveService.update(leaveVO2);
		
		return new ModelAndView("redirect:/admin/viewLeave");	
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/editLeave",method=RequestMethod.GET)
	public ModelAndView editLeave(@RequestParam String leaveId,@ModelAttribute LeaveVO leaveVO){
		
		leaveVO.setId(Integer.parseInt(leaveId));
		List leaveList = leaveService.edit(leaveVO);
		return new ModelAndView("admin/editLeave","leaveVO",(LeaveVO)leaveList.get(0));
	}
	
	@RequestMapping(value="admin/updateLeave",method=RequestMethod.POST)
	public ModelAndView updateLeave(@ModelAttribute LeaveVO leaveVO){
		
		leaveVO.setStatus(true);
		leaveService.update(leaveVO);
		return new ModelAndView("redirect:/admin/viewLeave");
	}
}

	
