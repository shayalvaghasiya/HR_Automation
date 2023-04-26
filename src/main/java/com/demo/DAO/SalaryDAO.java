package com.demo.DAO;

import java.util.List;

import com.demo.model.SalaryVO;

public interface SalaryDAO {

public void insert(SalaryVO salaryVO);

@SuppressWarnings("rawtypes")
public List search();

@SuppressWarnings("rawtypes")
public List delete(SalaryVO salaryVO);

public void update(SalaryVO salaryVO);

@SuppressWarnings("rawtypes")
public List edit(SalaryVO salaryVO);

@SuppressWarnings("rawtypes")
public List searchAjaxSalary(SalaryVO salaryVO);

@SuppressWarnings("rawtypes")
public List searchBydesignationid(int designationId);

@SuppressWarnings("rawtypes")
public List searchForGraph();

}
