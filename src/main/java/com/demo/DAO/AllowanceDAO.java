package com.demo.DAO;

import java.util.List;

import com.demo.model.AllowanceVO;

public interface AllowanceDAO {

public	void insert(AllowanceVO allowanceVO);

@SuppressWarnings("rawtypes")
public List search();

@SuppressWarnings("rawtypes")
public List delete(AllowanceVO allowanceVO);

public void update(AllowanceVO allowanceVO);

@SuppressWarnings("rawtypes")
public List edit(AllowanceVO allowanceVO);

@SuppressWarnings("rawtypes")
public List searchAjaxSalary(AllowanceVO allowanceVO);

@SuppressWarnings("rawtypes")
public List searchBydesignationid(int designationId);

}
