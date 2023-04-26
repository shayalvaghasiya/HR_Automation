package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.demo.DAO.LeaveDAO;
import com.demo.model.LeaveVO;

@Service
public class LeaveService {

	@Autowired
	LeaveDAO leaveDAO;

	@Transactional
	public void insert(LeaveVO leaveVO) {
		this.leaveDAO.insert(leaveVO);
		
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List search() {
		List leaveList = this.leaveDAO.search();
		return leaveList;
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List delete(LeaveVO leaveVO) {
		List leaveList = this.leaveDAO.delete(leaveVO);
		return leaveList;
	}

	@Transactional
	public void update(LeaveVO leaveVO) {
		this.leaveDAO.update(leaveVO);
		
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List edit(LeaveVO leaveVO) {
		List leaveList = this.leaveDAO.edit(leaveVO);
		return leaveList;
	}

	public List searchById(LeaveVO leaveVO) {
		List leaveList = this.leaveDAO.searchById(leaveVO);
		return leaveList;
	}
}
