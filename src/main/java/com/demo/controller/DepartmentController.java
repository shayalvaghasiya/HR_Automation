package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.DepartmentVO;
import com.demo.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping(value="admin/loadDepartment",method=RequestMethod.GET)
	public ModelAndView loadDepartment(){
		return new ModelAndView("admin/addDepartment","DepartmentVO",new DepartmentVO());	
	}
	
	@RequestMapping(value="admin/insertDepartment",method=RequestMethod.GET)
	public ModelAndView insertDepartment(@ModelAttribute DepartmentVO departmentVO){
		departmentVO.setStatus(true);
		this.departmentService.insert(departmentVO);
		return new ModelAndView("redirect:/admin/loadDepartment");	
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/viewDepartment",method=RequestMethod.GET)
	public ModelAndView viewDepartment(){
		List departmentList = this.departmentService.search();
		return new ModelAndView("admin/viewDepartment","departmentList",departmentList);	
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/deleteDepartment",method=RequestMethod.GET)
	public ModelAndView deleteDepartment(@RequestParam String departmentId,@ModelAttribute DepartmentVO departmentVO){

		departmentVO.setId(Integer.parseInt(departmentId));
		List departmentList = departmentService.delete(departmentVO);

		DepartmentVO departmentVO2 = (DepartmentVO) departmentList.get(0);
		departmentVO2.setStatus(false);
		
		departmentService.update(departmentVO2);
		
		return new ModelAndView("redirect:/admin/viewDepartment");	
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/editDepartment",method=RequestMethod.GET)
	public ModelAndView editDepartment(@RequestParam String departmentId,@ModelAttribute DepartmentVO departmentVO){
		
		System.out.println("INn CONtroller ID>>>>>>"+departmentId);
		departmentVO.setId(Integer.parseInt(departmentId));
		List departmentList = departmentService.edit(departmentVO);
		return new ModelAndView("admin/editDepartment","departmentVO",(DepartmentVO)departmentList.get(0));
	}
	
	@RequestMapping(value="admin/updateDepartment",method=RequestMethod.POST)
	public ModelAndView updateDepartment(@ModelAttribute DepartmentVO departmentVO){
		
		departmentVO.setStatus(true);
		departmentService.update(departmentVO);
		return new ModelAndView("redirect:/admin/viewDepartment");
	}
}
