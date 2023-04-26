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
import com.demo.model.EmployeeVO;
import com.demo.model.LoanVO;
import com.demo.model.LoginVO;
import com.demo.service.DesignationService;
import com.demo.service.EmployeeService;
import com.demo.service.LoanService;
import com.demo.service.LoginService;
import com.demo.utils.BaseMethods;

@Controller
public class LoanController {
	
	@Autowired
	DesignationService designationService;
	
	@Autowired
	LoanService loanService;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	EmployeeService employeeService;
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/loadLoan",method=RequestMethod.GET)
	public ModelAndView loadLoan(){
	
		List designationList = this.designationService.search();
		return new ModelAndView("admin/addLoan","LoanVO",new LoanVO()).addObject("designationList",designationList);	
	}

	
	
	@RequestMapping(value="admin/insertLoan",method=RequestMethod.GET)
	public ModelAndView insertLoan(@ModelAttribute LoanVO loanVO){
		loanVO.setStatus(true);
		this.loanService.insert(loanVO);
		return new ModelAndView("redirect:/admin/loadLoan");	
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/viewLoan",method=RequestMethod.GET)
	public ModelAndView viewLoan(){
		List loanList = this.loanService.search();
		return new ModelAndView("admin/viewLoan","loanList",loanList);	
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="employee/viewEmployeeLoan",method=RequestMethod.GET)
	public ModelAndView viewEmployeeLoan(@ModelAttribute EmployeeVO  employeeVO){
		
		String userName = BaseMethods.getCurrentUser();  
		List loginList = this.loginService.searchByUserName(userName);

		LoginVO loginVO = (LoginVO)loginList.get(0);
		
		employeeVO.setLoginVO(loginVO);
		List employeeList = this.employeeService.searchByLoginId(employeeVO);
		
		EmployeeVO employeeVO2 = (EmployeeVO)employeeList.get(0);
		
		DesignationVO designationId = employeeVO2.getDesignationVO();
		
		List loanList = this.loanService.searchByDesId(designationId);
		
		return new ModelAndView("employee/viewEmployeeLoan","loanList",loanList);	
	}
	
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/deleteLoan",method=RequestMethod.GET)
	public ModelAndView deleteLoan(@RequestParam String loanId,@ModelAttribute LoanVO loanVO){

		loanVO.setId(Integer.parseInt(loanId));
		List loanList = loanService.delete(loanVO);

		LoanVO loanVO2 = (LoanVO) loanList.get(0);
		loanVO2.setStatus(false);
		
		loanService.update(loanVO2);
		
		return new ModelAndView("redirect:/admin/viewLoan");	
	}
	

	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/editLoan",method=RequestMethod.GET)
	public ModelAndView editLoan(@RequestParam String loanId,@ModelAttribute LoanVO loanVO){
		
		System.out.println("INn CONtroller ID>>>>>>"+loanId);
		loanVO.setId(Integer.parseInt(loanId));
		List loanList = loanService.edit(loanVO);
		List designationList = this.designationService.search();
		return new ModelAndView("admin/editLoan","LoanVO",(LoanVO)loanList.get(0)).
				addObject("designationList",designationList);
	}
	
	
	@RequestMapping(value="admin/updateLoan",method=RequestMethod.POST)
	public ModelAndView updateLoan(@ModelAttribute LoanVO loanVO){
		
		loanVO.setStatus(true);
		loanService.update(loanVO);
		return new ModelAndView("redirect:/admin/viewLoan");
	}
	


}
