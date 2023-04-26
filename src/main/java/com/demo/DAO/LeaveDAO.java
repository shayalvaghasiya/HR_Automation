package com.demo.DAO;

import java.util.List;

import com.demo.model.LeaveVO;

public interface LeaveDAO {

public	void insert(LeaveVO leaveVO);

@SuppressWarnings("rawtypes")
public List search();

@SuppressWarnings("rawtypes")
public List delete(LeaveVO leaveVO);

public void update(LeaveVO leaveVO);

@SuppressWarnings("rawtypes")
public List edit(LeaveVO leaveVO);

public List searchById(LeaveVO leaveVO);


}
