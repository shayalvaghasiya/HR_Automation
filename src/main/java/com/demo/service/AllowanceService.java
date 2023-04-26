package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.DAO.AllowanceDAO;
import com.demo.model.AllowanceVO;

@Service
public class AllowanceService {
	@Autowired
	AllowanceDAO allowanceDAO;

	@Transactional
	public void insert(AllowanceVO allowanceVO) {
		this.allowanceDAO.insert(allowanceVO);
		
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List search() {
		List allowanceList = this.allowanceDAO.search();
		return allowanceList;
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List delete(AllowanceVO allowanceVO) {
		List allowanceList = this.allowanceDAO.delete(allowanceVO);
		return allowanceList;
	}

	@Transactional
	public void update(AllowanceVO allowanceVO) {
		this.allowanceDAO.update(allowanceVO);
		
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List edit(AllowanceVO allowanceVO) {
		List allowanceList = this.allowanceDAO.edit(allowanceVO);
		return allowanceList;
	}

	@SuppressWarnings("rawtypes")
	@Transactional
		public List searchBydesignationid(int designationId) {
		List allowanceList = this.allowanceDAO.searchBydesignationid(designationId);
		return allowanceList;
	}

	

}
