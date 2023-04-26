package com.demo.DAO;

import java.util.List;

import com.demo.model.AttendanceVO;

public interface AttendanceDAO {

public void insert(AttendanceVO attendanceVO);

@SuppressWarnings("rawtypes")
public List search();

@SuppressWarnings("rawtypes")
public List delete(AttendanceVO attendanceVO);

public void update(AttendanceVO attendanceVO);

@SuppressWarnings("rawtypes")
public List searchByEmpId(String employeeIdNumber);





}
