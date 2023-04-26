package com.demo.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.AllowanceVO;
import com.demo.model.AttendanceVO;
import com.demo.model.EmployeeVO;
import com.demo.model.LoginVO;
import com.demo.model.SalarySlipVO;
import com.demo.model.SalaryVO;
import com.demo.service.AllowanceService;
import com.demo.service.AttendanceService;
import com.demo.service.EmployeeService;
import com.demo.service.SalaryService;
import com.demo.service.SalarySlipService;
import com.demo.utils.BaseMethods;

@Controller
public class PaySlipGeneratorController {

	@Autowired
	AttendanceService attendanceService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	SalaryService salaryService;
	
	@Autowired
	AllowanceService allowanceService;
	
	@Autowired
	SalarySlipService salarySlipService;

	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/viewPaySlip",method=RequestMethod.GET)
	public ModelAndView viewPaySlip(@ModelAttribute EmployeeVO employeeVO){
		List attendanceList = this.attendanceService.search();
		List employeeList = this.employeeService.search();
		List salarySlipList = this.salarySlipService.search();
		System.out.println(attendanceList.size());
		return new ModelAndView("admin/viewPaySlip","attendanceList",attendanceList).
				addObject("employeeList",employeeList).addObject("salarySlipList",salarySlipList);	
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="employee/viewEmployeePaySlip",method=RequestMethod.GET)
	public ModelAndView viewEmployeePaySlip(HttpSession session){
		Integer loginId =(Integer)session.getAttribute("loginId");
		EmployeeVO employeeVO = new EmployeeVO();
		LoginVO loginVO = new LoginVO();
		loginVO.setId(loginId);
		employeeVO.setLoginVO(loginVO);
		List employeeList = this.employeeService.searchByLoginId(employeeVO);
		List SalarySlipList = this.salarySlipService.searchEmployeeByLoginId(loginId);
		return new ModelAndView("employee/viewEmployeePaySlip","employeeList",employeeList).
				addObject("SalarySlipList",SalarySlipList);
	} 

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="admin/generatePaySlip",method=RequestMethod.GET)
	public ModelAndView generatePaySlip(@ModelAttribute EmployeeVO employeeVO,@RequestParam String employeeId,HttpSession httpSession){
		
		String path = httpSession.getServletContext().getRealPath("/")+"documents//salaryslip";
		
		employeeVO.setId(Integer.parseInt(employeeId));
		
		
		/*********************** EMPLOYEE LIST ***********************/
		List employeeList = employeeService.edit(employeeVO);
		
		EmployeeVO employeeVO2 = (EmployeeVO)employeeList.get(0);
		
		/*********************** ATTENDANCE LIST ***********************/
		List attendanceList = this.attendanceService.searchByEmpId(employeeVO2.getEmployeeIDno());
		
		AttendanceVO attendanceVO = (AttendanceVO) attendanceList.get(0); 
		
		
		int designationId = employeeVO2.getDesignationVO().getId();
		
		/*********************** SALARY LIST ***********************/
		List salaryList = salaryService.searchBydesignationid(designationId);
		
		
		SalaryVO salaryVO= (SalaryVO)salaryList.get(0);
		
		String basicSalary = salaryVO.getSalaryBasicSalary();
		
		List allowanceVOList = allowanceService.searchBydesignationid(designationId);
		List allowanceList = new ArrayList<>();
		List deductionList = new ArrayList<>();

		for(int i = 0 ; i  < allowanceVOList.size() ; i++){
		
			AllowanceVO	 allowanceVO = (AllowanceVO) allowanceVOList.get(i);
		
			String deductionType = 	allowanceVO.getAllowORded();
		
			if (deductionType.equals("allowance")) {
				allowanceList.add(allowanceVO);
			}
			if (deductionType.equals("deduction")) {
				deductionList.add(allowanceVO);				
			}
			
			System.out.println(deductionType);
		}
	
		System.out.println("  DEDUCTION "+ deductionList.size());
		System.out.println(" ALLOWANCE " + allowanceList.size());
		
		File f = new File(path+"//"+employeeVO2.getEmployeeIDno());
		
		f.mkdirs();
		
		String fileName = BaseMethods.generatePaySlip(employeeVO2,attendanceVO,path+"//"+employeeVO2.getEmployeeIDno(),basicSalary,allowanceList,deductionList);
		
		String link = BaseMethods.uploadIntoS3(new File(fileName),employeeVO2.getEmployeeIDno());
		
		
		employeeVO2.setPaySlipStatus("Generated");
		
		SalarySlipVO salarySlipVO = new SalarySlipVO();
		
		salarySlipVO.setSalarySlipLink(link);
		salarySlipVO.setEmployeeVO(employeeVO2);
		
		
		this.salarySlipService.insert(salarySlipVO);
		
		this.employeeService.insert(employeeVO2);
		
		return new ModelAndView("redirect:/admin/viewPaySlip");	
  	}
	

}
