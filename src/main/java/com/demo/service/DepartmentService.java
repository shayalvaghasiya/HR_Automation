package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.DAO.DepartmentDAO;
import com.demo.model.DepartmentVO;

@Service
public class DepartmentService {

	@Autowired
	DepartmentDAO departmentDAO;
	
	@Transactional
	public void insert(DepartmentVO departmentVO) {
		this.departmentDAO.insert(departmentVO);
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List search() {
		List departmentList = this.departmentDAO.search();
		return departmentList;
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List delete(DepartmentVO departmentVO) {
		List departmentList = this.departmentDAO.delete(departmentVO);
		return departmentList;
	}

	@Transactional
	public void update(DepartmentVO departmentVO) {
		this.departmentDAO.update(departmentVO);
	}
	
	@SuppressWarnings("rawtypes")
	@Transactional
	public List edit(DepartmentVO departmentVO) {
		List departmentList = this.departmentDAO.edit(departmentVO);
		return departmentList;
	}

}

