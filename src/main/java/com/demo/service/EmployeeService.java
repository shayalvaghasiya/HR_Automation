package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.DAO.EmployeeDAO;
import com.demo.model.EmployeeVO;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDAO employeeDAO;

	@Transactional
	public void insert(EmployeeVO employeeVO) {
		this.employeeDAO.insert(employeeVO);
		
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List search() {
		List employeeList = this.employeeDAO.search();
		return employeeList;

			}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List delete(EmployeeVO employeeVO) {
		List employeeList = this.employeeDAO.delete(employeeVO);
		return employeeList;	
		
	}

	@Transactional
	public void update(EmployeeVO employeeVO) {
	this.employeeDAO.update(employeeVO);
}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List edit(EmployeeVO employeeVO) {
		List employeeList = this.employeeDAO.edit(employeeVO);
		return employeeList;
	}
	
	@SuppressWarnings("rawtypes")
	@Transactional
	public List searchByLoginId(EmployeeVO employeeVO) {
		List employeeList = this.employeeDAO.searchByLoginId(employeeVO);
		return employeeList;
	}

	
	@SuppressWarnings("rawtypes")
	@Transactional
	public List searchForGraph() {
		List employeeList = this.employeeDAO.searchForGraph();
				return employeeList;
	}


	
}
