package com.demo.DAO;

import java.util.List;

import com.demo.model.LeaveapplicationVO;

public interface LeaveapplicationDAO {

	void insert(LeaveapplicationVO leaveapplicationVO);

	List search();

	List findById(LeaveapplicationVO leaveapplicationVO);

}
