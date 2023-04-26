package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.AllowanceVO;
import com.demo.model.DesignationVO;
import com.demo.model.SalaryVO;
import com.demo.service.AllowanceService;
import com.demo.service.DesignationService;
import com.demo.service.SalaryService;

@Controller
public class AllowanceController {

	@Autowired
	DesignationService designationService;
	
	@Autowired
	AllowanceService allowanceService;
	
	@Autowired
	SalaryService salaryService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/loadAllowance",method=RequestMethod.GET)
	public ModelAndView loadAllowance(){
	
		List designationList = this.designationService.search();
		return new ModelAndView("admin/addAllowances","AllowanceVO",new AllowanceVO()).addObject("designationList",designationList);	
	}
	
	@RequestMapping(value="admin/insertAllowance",method=RequestMethod.POST)
	public ModelAndView insertAllowance(@ModelAttribute AllowanceVO allowanceVO){
		allowanceVO.setStatus(true);
		this.allowanceService.insert(allowanceVO);
		return new ModelAndView("redirect:/admin/loadAllowance");	
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/viewAllowances",method=RequestMethod.GET)
	public ModelAndView viewAllowances(){
		List allowanceList = this.allowanceService.search();
		return new ModelAndView("admin/viewAllowances","allowanceList",allowanceList);	
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/deleteAllowance",method=RequestMethod.GET)
	public ModelAndView deleteAllowance(@RequestParam String allowanceId,@ModelAttribute AllowanceVO allowanceVO){

		allowanceVO.setId(Integer.parseInt(allowanceId));
		List allowanceList = allowanceService.delete(allowanceVO);

		AllowanceVO allowanceVO2 = (AllowanceVO)allowanceList.get(0);
		allowanceVO2.setStatus(false);
		
		allowanceService.update(allowanceVO2);
		
		return new ModelAndView("redirect:/admin/viewAllowances");	
	}
	

	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/editAllowance",method=RequestMethod.POST)
	public ModelAndView editAllowance(@RequestParam String allowanceId,@ModelAttribute AllowanceVO allowanceVO){
		
		System.out.println("INn CONtroller ID>>>>>>"+allowanceId);
		allowanceVO.setId(Integer.parseInt(allowanceId));
		List allowanceList = allowanceService.edit(allowanceVO);
		List designationList = this.designationService.search();
		return new ModelAndView("admin/editAllowance","AllowanceVO",(AllowanceVO)allowanceList.get(0)).
				addObject("designationList",designationList);
	}
	
	
	@RequestMapping(value="admin/updateAllowance",method=RequestMethod.POST)
	public ModelAndView updateLoan(@ModelAttribute AllowanceVO allowanceVO){
		
		allowanceVO.setStatus(true);
		allowanceService.update(allowanceVO);
		return new ModelAndView("redirect:/admin/viewAllowances");
	}
	

	@SuppressWarnings("unchecked")
	@RequestMapping(value="admin/getAjaxSalary",method=RequestMethod.GET)
	public ModelAndView getAjaxSalary(@ModelAttribute SalaryVO salaryVO,@ModelAttribute DesignationVO designationVO ,@RequestParam String designationId){

		System.out.println("designationId ::: " + designationId);
		
		designationVO.setId(Integer.parseInt(designationId));
		
		salaryVO.setDesignationVO(designationVO);
		
		List<SalaryVO> jsonSalaryList = this.salaryService.searchAjaxSalary(salaryVO);
		
		
		System.out.println("====================="+jsonSalaryList.size());
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@"+jsonSalaryList.get(0).getSalaryBasicSalary());
		
		return new ModelAndView("admin/JsonSalary","jsonSalaryList",(SalaryVO)jsonSalaryList.get(0)) ;
		
	}

	
	
	
}
