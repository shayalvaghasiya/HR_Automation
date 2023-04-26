package com.demo.DAO;

import java.util.List;

import com.demo.model.LoginVO;

public interface LoginDAO {

public	void insert(LoginVO loginVO);

public void update(LoginVO loginVO);

@SuppressWarnings("rawtypes")
public List searchstep1(LoginVO loginVO);

public void updatePassword(LoginVO loginVO);

@SuppressWarnings("rawtypes")
public List searchByUserName(String userName);

}
