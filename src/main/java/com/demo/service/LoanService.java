package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.DAO.LoanDAO;
import com.demo.model.DesignationVO;
import com.demo.model.LoanVO;

@Service
public class LoanService {

	@Autowired
	LoanDAO loanDAO;

	
	@Transactional
	public void insert(LoanVO loanVO) {
		this.loanDAO.insert(loanVO);
		
	}


	@SuppressWarnings("rawtypes")
	@Transactional
	public List search() {
		List loanList = this.loanDAO.search();
		return loanList;
	}


	@SuppressWarnings("rawtypes")
	@Transactional
	public List delete(LoanVO loanVO) {
		List loanList = this.loanDAO.delete(loanVO);
		return loanList;
	}

	@Transactional

	public void update(LoanVO loanVO) {
		this.loanDAO.update(loanVO);
		
	}


	@SuppressWarnings("rawtypes")
	@Transactional
	public List edit(LoanVO loanVO) {
		List loanList = this.loanDAO.edit(loanVO);
		return loanList;
	}
	
	
	@SuppressWarnings("rawtypes")
	@Transactional
	public List searchByDesId(DesignationVO designationId) {
		List loanList = this.loanDAO.searchByDesId(designationId);
		return loanList;
	}

	
}
