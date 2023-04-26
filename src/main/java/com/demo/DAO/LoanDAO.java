package com.demo.DAO;

import java.util.List;

import com.demo.model.DesignationVO;
import com.demo.model.LoanVO;

public interface LoanDAO {

public	void insert(LoanVO loanVO);

@SuppressWarnings("rawtypes")
public List search();

@SuppressWarnings("rawtypes")
public List delete(LoanVO loanVO);

public void update(LoanVO loanVO);

@SuppressWarnings("rawtypes")
public List edit(LoanVO loanVO);

@SuppressWarnings("rawtypes")
public List searchByDesId(DesignationVO designationId);

}
