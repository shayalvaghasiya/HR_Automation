package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.SalaryVO;
import com.demo.service.DesignationService;
import com.demo.service.SalaryService;

@Controller
public class SalaryController {
	
	@Autowired
	DesignationService designationService;
	
	@Autowired
	SalaryService salaryService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/loadSalary",method=RequestMethod.GET)
	public ModelAndView loadSalary(){
	
		List designationList = this.designationService.search();
		return new ModelAndView("admin/addSalary","SalaryVO",new SalaryVO()).addObject("designationList",designationList);	
	}

	
	@RequestMapping(value="admin/insertSalary",method=RequestMethod.GET)
	public ModelAndView insertSalary(@ModelAttribute SalaryVO salaryVO){
		salaryVO.setStatus(true);
		this.salaryService.insert(salaryVO);
		return new ModelAndView("redirect:/admin/loadSalary");	
	}
	

 
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/viewSalary",method=RequestMethod.GET)
	public ModelAndView viewSalary(){
		List salaryList = this.salaryService.search();
		return new ModelAndView("admin/viewSalary","salaryList",salaryList);	
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/deleteSalary",method=RequestMethod.GET)
	public ModelAndView deleteSalary(@RequestParam String salaryId,@ModelAttribute SalaryVO salaryVO){

		salaryVO.setId(Integer.parseInt(salaryId));
		List salaryList = salaryService.delete(salaryVO);

		SalaryVO salaryVO2 = (SalaryVO) salaryList.get(0);
		salaryVO2.setStatus(false);
		
		salaryService.update(salaryVO2);
		
		return new ModelAndView("redirect:/admin/viewSalary");	
	}
	

	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/editSalary",method=RequestMethod.GET)
	public ModelAndView editSalary(@RequestParam String salaryId,@ModelAttribute SalaryVO salaryVO){
		
		System.out.println("INn CONtroller ID>>>>>>"+salaryId);
		salaryVO.setId(Integer.parseInt(salaryId));
		List salaryList = salaryService.edit(salaryVO);
		List designationList = this.designationService.search();
		return new ModelAndView("admin/editSalary","SalaryVO",(SalaryVO)salaryList.get(0)).
				addObject("designationList",designationList);
	}
	
	
	@RequestMapping(value="admin/updateSalary",method=RequestMethod.POST)
	public ModelAndView updateSalary(@ModelAttribute SalaryVO salaryVO){
		
		salaryVO.setStatus(true);
		salaryService.update(salaryVO);
		return new ModelAndView("redirect:/viewSalary");
	}
	


	
}
