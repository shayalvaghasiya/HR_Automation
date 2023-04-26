package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.DAO.EmployeeDAO;
import com.demo.DAO.SalarySlipDAO;
import com.demo.model.EmployeeVO;
import com.demo.model.LoginVO;
import com.demo.model.SalarySlipVO;

@Service
public class SalarySlipService {
	@Autowired
	SalarySlipDAO salarySlipDAO;
	
	@Autowired
	EmployeeDAO employeeDAO;

	@Transactional
	public void insert(SalarySlipVO salarySlipVO) {
		this.salarySlipDAO.insert(salarySlipVO);
		
	}
	@Transactional
	public List search() {
		return this.salarySlipDAO.search();
	}
	@Transactional
	public List searchEmployeeByLoginId(Integer loginId){
		EmployeeVO employeeVO = new EmployeeVO();
		LoginVO loginVO = new LoginVO();
		loginVO.setId(loginId);
		employeeVO.setLoginVO(loginVO);
		List <EmployeeVO>employeeList =  this.employeeDAO.searchByLoginId(employeeVO);
		System.out.println(employeeList); 
		List <SalarySlipVO>SalarySlipList = this.salarySlipDAO.search();
		List <SalarySlipVO>SalarySlip = new ArrayList<SalarySlipVO>();
		for(int i=0; i<SalarySlipList.size();i++){
			if((employeeList.get(0).getId()) == (SalarySlipList.get(i)).getEmployeeVO().getId()){
				SalarySlip.add(SalarySlipList.get(i));
			}
		}
		return SalarySlip;
	}
}
