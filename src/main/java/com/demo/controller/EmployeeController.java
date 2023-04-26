package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.EmployeeVO;
import com.demo.model.LoginVO;
import com.demo.service.DepartmentService;
import com.demo.service.DesignationService;
import com.demo.service.EmployeeService;
import com.demo.service.LoginService;
import com.demo.utils.BaseMethods;

@Controller
public class EmployeeController {
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	DesignationService designationService;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	EmployeeService employeeService;
		
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/loadEmployee",method=RequestMethod.GET)
	public ModelAndView loadEmployee(){
		List departmentList = this.departmentService.search();
		List designationList = this.designationService.search();
		return new ModelAndView("admin/addEmployee","EmployeeVO",new EmployeeVO()).
				addObject("designationList",designationList).
				addObject("departmentList",departmentList);	
	}

	
	@RequestMapping(value="admin/insertEmployee",method=RequestMethod.POST)
	public ModelAndView insertEmployee(@ModelAttribute EmployeeVO employeeVO, @ModelAttribute LoginVO loginVO){
		
		
		String password = BaseMethods.generatepassword(); 
		
		loginVO.setUserName(employeeVO.getLoginVO().getUserName());
		loginVO.setPassword(password);
		loginVO.setUserRole("ROLE_EMPLOYEE");
		loginVO.setEnabled("1");
		
		BaseMethods.sendMail(employeeVO.getLoginVO().getUserName(), employeeVO.getEmployeeFirstName(), password);
		
		this.loginService.insert(loginVO);
		
		System.out.println("LOGIN ID ::: " + loginVO.getId());
		employeeVO.setLoginVO(loginVO);
		
		System.out.println("\n\n\n\n\n\n\n\n::::::::::::::::::::::::: ");
		System.out.println(employeeVO.getLoginVO().getId());
		
		this.employeeService.insert(employeeVO);
		return new ModelAndView ("redirect:/admin/loadEmployee");
		
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/viewEmployee",method=RequestMethod.GET)
	public ModelAndView viewLoan(){
		List employeeList = this.employeeService.search();
		
		System.out.println(employeeList.size());
		return new ModelAndView("admin/viewEmployee","employeeList",employeeList);	
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/deleteEmployee",method=RequestMethod.GET)
	public ModelAndView deleteEmployee(@RequestParam String employeeId,@ModelAttribute EmployeeVO employeeVO){

		employeeVO.setId(Integer.parseInt(employeeId));
		List employeeList = employeeService.delete(employeeVO);

		EmployeeVO employeeVO2 = (EmployeeVO) employeeList.get(0);
		employeeVO2.setStatus(false);
		
		employeeService.update(employeeVO2);
		
		return new ModelAndView("redirect:/admin/viewEmployee");	
	}

	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/editEmployee",method=RequestMethod.GET)
	public ModelAndView editEmployee(@RequestParam String employeeId,@ModelAttribute EmployeeVO employeeVO){
		
		System.out.println("INn CONtroller ID>>>>>>"+employeeId);
		employeeVO.setId(Integer.parseInt(employeeId));
		List employeeList = employeeService.edit(employeeVO);
		List departmentList = this.departmentService.search();
		List designationList = this.designationService.search();
		return new ModelAndView("admin/editEmployee","EmployeeVO",(EmployeeVO)employeeList.get(0)).
				addObject("departmentList",departmentList).
				addObject("designationList",designationList);
	}
	
	
	@RequestMapping(value="admin/updateEmployee",method=RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute EmployeeVO employeeVO,@ModelAttribute LoginVO loginVO){
		
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("emp ID" + employeeVO.getId());
		System.out.println("emp ID" + employeeVO.getLoginVO().getId());
		
		
		loginVO.setUserName(employeeVO.getLoginVO().getUserName());
		loginVO.setPassword(employeeVO.getLoginVO().getPassword());
		loginVO.setId(employeeVO.getLoginVO().getId());
		loginVO.setUserRole("EMPLOYEE");
		this.loginService.update(loginVO);
		
		employeeVO.setLoginVO(loginVO);
		this.employeeService.update(employeeVO);
		return new ModelAndView("redirect:/admin/viewEmployee");
	}
	
	}
