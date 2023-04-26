package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.DAO.SalaryDAO;
import com.demo.model.SalaryVO;

@Service
public class SalaryService {
	
	@Autowired
	SalaryDAO salaryDAO;

	@Transactional
	public void insert(SalaryVO salaryVO) {
		this.salaryDAO.insert(salaryVO);
		
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List search() {
		List salaryList = this.salaryDAO.search();
		return salaryList;
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List delete(SalaryVO salaryVO) {
		List salaryList = this.salaryDAO.delete(salaryVO);
		return salaryList;
	}

	@Transactional
	public void update(SalaryVO salaryVO) {
		this.salaryDAO.update(salaryVO);
		
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List edit(SalaryVO salaryVO) {
		List salaryList = this.salaryDAO.edit(salaryVO);
		return salaryList;
	} 
	
	@SuppressWarnings("rawtypes")
	@Transactional
	public List searchAjaxSalary(SalaryVO SalaryVO) {
		List allowanceList = this.salaryDAO.searchAjaxSalary(SalaryVO);
		return allowanceList;
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List searchBydesignationid(int designationId) {
		List salaryList = this.salaryDAO.searchBydesignationid(designationId);
		return salaryList;
	}

	
	@SuppressWarnings("rawtypes")
	@Transactional
	public List searchForGraph() {
		List salaryList = this.salaryDAO.searchForGraph();
		return salaryList;
	}

}
