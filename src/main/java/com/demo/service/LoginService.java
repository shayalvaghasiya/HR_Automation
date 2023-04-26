package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.DAO.LoginDAO;
import com.demo.model.LoginVO;

@Service
public class LoginService {

	@Autowired
	LoginDAO loginDAO;
	
	@Transactional
	public void insert(LoginVO loginVO) {
		this.loginDAO.insert(loginVO);
		
	}

	@Transactional
	public void update(LoginVO loginVO) {
		this.loginDAO.update(loginVO);
	}
	
	@SuppressWarnings("rawtypes")
	@Transactional
	public List searchstep1(LoginVO loginVO)
	{
		
		List ls = this.loginDAO.searchstep1(loginVO);
		return ls;
	}
	
	@Transactional
	public void updatePassword(LoginVO loginVO)
	{
		this.loginDAO.updatePassword(loginVO);
	}
	
	@SuppressWarnings("rawtypes")
	@Transactional
	public List searchByUserName(String userName) {
		List userList = this.loginDAO.searchByUserName(userName);
		System.out.println("LoginService : " + userList.get(0));
		return userList;
	}

}
