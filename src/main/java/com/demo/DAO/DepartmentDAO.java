package com.demo.DAO;

import java.util.List;

import com.demo.model.DepartmentVO;

public interface DepartmentDAO {

	public void insert(DepartmentVO departmentVO);

	@SuppressWarnings("rawtypes")
	public List search();

	@SuppressWarnings("rawtypes")
	public List delete(DepartmentVO departmentVO);

	public void update(DepartmentVO departmentVO);
	
	@SuppressWarnings("rawtypes")
	public List edit(DepartmentVO departmentVO);
	
}
