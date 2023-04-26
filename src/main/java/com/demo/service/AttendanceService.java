package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.DAO.AttendanceDAO;
import com.demo.model.AttendanceVO;

@Service
public class AttendanceService {
	
	@Autowired
	AttendanceDAO attendanceDAO;

	@Transactional
	public void insert(AttendanceVO attendanceVO) {
		this.attendanceDAO.insert(attendanceVO);
		
		
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List search() {
		List attendanceList = this.attendanceDAO.search();
		return attendanceList;
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List delete(AttendanceVO attendanceVO) {
		List attendanceList = this.attendanceDAO.delete(attendanceVO);
		return attendanceList;
	}

	@Transactional
	public void update(AttendanceVO attendanceVO) {
		this.attendanceDAO.update(attendanceVO);
		
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List searchByEmpId(String employeeIdNumber) {
		List attendanceList = this.attendanceDAO.searchByEmpId(employeeIdNumber);
		return attendanceList;
	}
	
	

	
}
