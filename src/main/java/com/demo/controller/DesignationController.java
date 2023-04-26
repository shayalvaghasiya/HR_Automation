package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.DesignationVO;
import com.demo.service.DesignationService;


@Controller
public class DesignationController {

	@Autowired
	DesignationService designationService;
	
	@RequestMapping(value="admin/loadDesignation", method=RequestMethod.GET)
	public ModelAndView loadDesignation(){
		
		return new ModelAndView("admin/addDesignation","DesignationVO",new DesignationVO());	
	}
	
	@RequestMapping(value="admin/insertDesignation",method=RequestMethod.GET)
	public ModelAndView insertDesignation(@ModelAttribute DesignationVO designationVO){
		designationVO.setStatus(true);
		this.designationService.insert(designationVO);
		return new ModelAndView("redirect:/admin/loadDesignation");	
	
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/viewDesignation",method=RequestMethod.GET)
	public ModelAndView viewDesignation(){
		
		List designationList = this.designationService.search();
		return new ModelAndView ("admin/viewDesignation","designationList",designationList);
		
		
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/editDesignation",method=RequestMethod.GET)
	public ModelAndView editDesignation(@RequestParam String designationId,@ModelAttribute DesignationVO designationVO){
		
		System.out.println("INn CONtroller ID>>>>>>"+designationId);
		designationVO.setId(Integer.parseInt(designationId));
		List designationList = designationService.edit(designationVO);
		return new ModelAndView("admin/editDesignation","designationVO",(DesignationVO)designationList.get(0));
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/deleteDesignation",method=RequestMethod.GET)
	public ModelAndView deleteDesignation(@RequestParam String designationId,@ModelAttribute DesignationVO designationVO){
		designationVO.setId(Integer.parseInt(designationId));
		List designationList = designationService.delete(designationVO);
		
		DesignationVO designationVO2 = (DesignationVO) designationList.get(0);
		designationVO2.setStatus(false);
		
		designationService.update(designationVO2);
		
		return new ModelAndView("redirect:/admin/viewDesignation");
		
	
	
	
	}
	
	@RequestMapping(value="admin/updateDesignation",method=RequestMethod.POST)
	public ModelAndView updateDesignation(@ModelAttribute DesignationVO designationVO){
		
		designationVO.setStatus(true);
		designationService.update(designationVO);
		return new ModelAndView("redirect:/admin/viewDesignation");
	}
	

	
}
