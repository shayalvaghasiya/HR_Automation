package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.DAO.LeaveapplicationDAO;
import com.demo.model.EmployeeVO;
import com.demo.model.LeaveapplicationVO;

@Service
public class LeaveapplicationService {

	@Autowired
	LeaveapplicationDAO leaveapplicationDAO;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void insert(LeaveapplicationVO leaveapplicationVO) {
		this.leaveapplicationDAO.insert(leaveapplicationVO);
	}

	public List search(Integer loginId) {
		List leaveaplicationList=this.leaveapplicationDAO.search();
		List LeaveapplicationListFinal = new ArrayList<LeaveapplicationVO>();
		for(int i=0; i< leaveaplicationList.size();i++){
			if(loginId.equals(((LeaveapplicationVO)leaveaplicationList.get(i)).getEmployeeVO().getLoginVO().getId())){
				LeaveapplicationListFinal.add((LeaveapplicationVO)leaveaplicationList.get(i));
			}
		}
		return LeaveapplicationListFinal;
	}


	public List findById(LeaveapplicationVO leaveapplicationVO) {
		
		List leaveapplicationList=this.leaveapplicationDAO.findById(leaveapplicationVO);
		return leaveapplicationList;
	}

	public List searchAll() {
		// TODO Auto-generated method stub
		List leaveaplicationList=this.leaveapplicationDAO.search();
		return leaveaplicationList;
	}

	public List searchPendingLeave() {
		String leaveStatus = "pending";
		List leaveaplicationList=this.leaveapplicationDAO.search();
		List LeaveapplicationListFinal = new ArrayList<LeaveapplicationVO>();
		for(int i=0; i< leaveaplicationList.size();i++){
			if(leaveStatus.equals(((LeaveapplicationVO)leaveaplicationList.get(i)).getLeaveStatus())){
				LeaveapplicationListFinal.add((LeaveapplicationVO)leaveaplicationList.get(i));
//				System.out.println("In for in service!!!!!!!!!!!!");
			}
		}
		return LeaveapplicationListFinal;
	}

}
