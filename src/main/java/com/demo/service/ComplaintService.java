package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.DAO.ComplaintDAO;
import com.demo.model.ComplaintVO;

@Service
public class ComplaintService {

	@Autowired
	ComplaintDAO complaintDAO;
	
	@Transactional
	public void insert(ComplaintVO complaintVO) {
		this.complaintDAO.insert(complaintVO);
		
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List search() {
		List complaintList = this.complaintDAO.search();
		return complaintList;
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List search(ComplaintVO complaintVO) {
		List complaintList = this.complaintDAO.search(complaintVO);
		return complaintList;
	}
	
	@SuppressWarnings("rawtypes")
	@Transactional
	public List reply(ComplaintVO complaintVO) {
		List complaintList = this.complaintDAO.reply(complaintVO);
		return complaintList;
	}
	
	@Transactional
	public void update(ComplaintVO complaintVO) {
		this.complaintDAO.update(complaintVO);
		
	}
}
