package com.demo.DAO;

import java.util.List;

import com.demo.model.EmployeeVO;

public interface EmployeeDAO {

public	void insert(EmployeeVO employeeVO);

@SuppressWarnings("rawtypes")
public List search();

@SuppressWarnings("rawtypes")
public List delete(EmployeeVO employeeVO);

public void update(EmployeeVO employeeVO);

@SuppressWarnings("rawtypes")
public List edit(EmployeeVO employeeVO);

@SuppressWarnings("rawtypes")
public List searchByLoginId(EmployeeVO employeeVO);

@SuppressWarnings("rawtypes")
public List searchForGraph();



}
