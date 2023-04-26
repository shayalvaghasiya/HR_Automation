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
import com.demo.model.LoginVO;
import com.demo.model.MedicalCoverVO;
import com.demo.service.DesignationService;
import com.demo.service.EmployeeService;
import com.demo.service.LoginService;
import com.demo.service.MedicalCoverService;
import com.demo.utils.BaseMethods;

@Controller
public class MedicalCoverController {

	@Autowired
	DesignationService designationService;
	
	@Autowired
	MedicalCoverService medicalcoverservice;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	EmployeeService employeeService;
	
	
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="admin/loadMedicalCover",method=RequestMethod.GET)
		public ModelAndView loadMedCover(){
		
			List designationList = this.designationService.search();
			return new ModelAndView("admin/addMedicalCover","MedicalCoverVO",new MedicalCoverVO()).addObject("designationList",designationList);	
		}
		
		
		@RequestMapping(value="admin/insertMedicalCover",method=RequestMethod.GET)
		public ModelAndView insertMedicalCover(@ModelAttribute MedicalCoverVO medicalcoverVO){
			medicalcoverVO.setStatus(true);
			this.medicalcoverservice.insert(medicalcoverVO);
			return new ModelAndView("redirect:/admin/loadMedicalCover");	
		}
		
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="admin/viewMedicalCover",method=RequestMethod.GET)
		public ModelAndView viewMedicalCover(){
			List medicalcoverList = this.medicalcoverservice.search();
			return new ModelAndView("admin/viewMedicalCover","medicalcoverList",medicalcoverList);	
		}
		

		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="employee/viewEmployeeMedicalCover",method=RequestMethod.GET)
		public ModelAndView viewEmployeeMedicalCover(@ModelAttribute EmployeeVO  employeeVO){
			
			String userName = BaseMethods.getCurrentUser();  
			List loginList = this.loginService.searchByUserName(userName);

			LoginVO loginVO = (LoginVO)loginList.get(0);
			
			employeeVO.setLoginVO(loginVO);
			List employeeList = this.employeeService.searchByLoginId(employeeVO);
			
			EmployeeVO employeeVO2 = (EmployeeVO)employeeList.get(0);
			
			DesignationVO designationId = employeeVO2.getDesignationVO();
			
			List medicalcoverList = this.medicalcoverservice.searchByDesId(designationId);
			
			return new ModelAndView("employee/viewEmployeeMedicalCover","medicalcoverList",medicalcoverList);	
		}

		
		
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="admin/deleteMedicalCover",method=RequestMethod.GET)
		public ModelAndView deleteMedicalCover(@RequestParam String medicalcoverId,@ModelAttribute MedicalCoverVO medicalcoverVO){

			medicalcoverVO.setId(Integer.parseInt(medicalcoverId));
			List medicalcoverList = medicalcoverservice.delete(medicalcoverVO);

			MedicalCoverVO medicalcoverVO2 = (MedicalCoverVO) medicalcoverList.get(0);
			medicalcoverVO2.setStatus(false);
			
			medicalcoverservice.update(medicalcoverVO2);
			
			return new ModelAndView("redirect:/viewMedicalCover");	
		}
		
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="admin/editMedicalCover",method=RequestMethod.GET)
		public ModelAndView editMedicalCover(@RequestParam String medicalcoverId,@ModelAttribute MedicalCoverVO medicalcoverVO){
			
			System.out.println("INn CONtroller ID>>>>>>"+medicalcoverId);
			medicalcoverVO.setId(Integer.parseInt(medicalcoverId));
			List medicalcoverList = medicalcoverservice.edit(medicalcoverVO);
			List designationList = this.designationService.search();
			return new ModelAndView("admin/editMedicalCover","MedicalCoverVO",(MedicalCoverVO)medicalcoverList.get(0)).
					addObject("designationList",designationList);
		}
		
		
		@RequestMapping(value="admin/updateMedicalCover",method=RequestMethod.POST)
		public ModelAndView updateMedicalCover(@ModelAttribute MedicalCoverVO medicalcoverVO){
			
			medicalcoverVO.setStatus(true);
			medicalcoverservice.update(medicalcoverVO);
			return new ModelAndView("redirect:/viewMedicalCover");
		}
		

}


