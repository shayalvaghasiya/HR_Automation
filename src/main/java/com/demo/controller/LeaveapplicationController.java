package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.DepartmentVO;
import com.demo.model.EmployeeVO;
import com.demo.model.LeaveVO;
import com.demo.model.LeaveapplicationVO;
import com.demo.service.EmployeeService;
import com.demo.service.LeaveService;
import com.demo.service.LeaveapplicationService;

@Controller
public class LeaveapplicationController {

	@Autowired
	LeaveService leaveService;
	
	@Autowired
	LeaveapplicationService leaveapplicationService;
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="employee/addLeaveapplication",method=RequestMethod.GET)
	public ModelAndView loadLeaveapplication(){
		List leaveList = this.leaveService.search();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!IN LEAVE CONTROLLER!!!!!!!!!!!!!!!!!!!!!");
		return new ModelAndView("employee/addLeaveapplication","LeaveapplicationVO",new LeaveapplicationVO()).addObject("leaveList", leaveList);	
	} 
	 
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="employee/insertLeaveApplication",method=RequestMethod.POST)
	public ModelAndView insertLeaveApplication(@ModelAttribute LeaveapplicationVO leaveapplicationVO,HttpSession session){
		leaveapplicationVO.setLeaveStatus("pending");
		List employeeList = this.employeeService.search();
		List leaveList = this.leaveService.edit(leaveapplicationVO.getLeaveVO());
		for(int i=0; i< employeeList.size();i++){
			if(((Integer)session.getAttribute("loginId")).equals(((EmployeeVO)employeeList.get(i)).getLoginVO().getId())){
				leaveapplicationVO.setEmployeeVO(((EmployeeVO)employeeList.get(i)));
				break;
			}
		}
		leaveapplicationVO.setLeaveVO((LeaveVO) leaveList.get(0));
		leaveapplicationVO.setStatus(true);
//		System.out.println(leaveList.get(0).getClass());
//		System.out.println("!!!!!!!!!!@@INSERT LEAVE VO START@@!!!!!!!!!!!");
//		System.out.println("Leave Type:-"+((LeaveVO) leaveList.get(0)).getLeaveType()); 
//		System.out.println("To Date"+leaveapplicationVO.getToDate());
//		System.out.println("From Date"+leaveapplicationVO.getFromDate());
//		System.out.println("Leave Discription"+leaveapplicationVO.getLeavedescription());
//		System.out.println("Leave Status"+leaveapplicationVO.getLeaveStatus());
//		System.out.println("Employee ID"+session.getAttribute("loginId"));
//		System.out.println("!!!!!!!!!!@@INSERT LEAVE VO END@@!!!!!!!!!!!");
		this.leaveapplicationService.insert(leaveapplicationVO);
		return new ModelAndView ("redirect:/employee/index.html");
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="employee/viewLeaveapplication",method=RequestMethod.GET)
	public ModelAndView viewLeaveapplication(HttpSession session){
		List leaveapplicationList = this.leaveapplicationService.search((Integer)session.getAttribute("loginId"));
		
		System.out.println(leaveapplicationList.size());
		return new ModelAndView("employee/viewLeaveapplication","leaveapplicationList",leaveapplicationList);	
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="employee/deleteLeaveapplication",method=RequestMethod.GET)
	public ModelAndView deleteLeaveapplication(@RequestParam String leaveapplicationId,@ModelAttribute LeaveapplicationVO leaveapplicationVO){

		leaveapplicationVO.setId(Integer.parseInt(leaveapplicationId));
		List leaveapplicationList = leaveapplicationService.findById(leaveapplicationVO);

		LeaveapplicationVO leaveapplicationVO2 = (LeaveapplicationVO) leaveapplicationList.get(0);
		leaveapplicationVO2.setStatus(false);
		
		leaveapplicationService.insert(leaveapplicationVO2);
		
		return new ModelAndView("redirect:/employee/viewLeaveapplication");	
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="employee/editLeaveapplication",method=RequestMethod.GET)
	public ModelAndView editLeaveapplication(@RequestParam String leaveapplicationId,@ModelAttribute LeaveapplicationVO leaveapplicationVO){

		leaveapplicationVO.setId(Integer.parseInt(leaveapplicationId));
		List leaveapplicationList = leaveapplicationService.findById(leaveapplicationVO);
		List leaveList = this.leaveService.search();
		LeaveapplicationVO leaveapplicationVO2 = (LeaveapplicationVO) leaveapplicationList.get(0);
		
		return new ModelAndView("employee/editLeaveapplication","LeaveapplicationVO",leaveapplicationVO2).addObject("leaveList", leaveList);	
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/viewLeaveRequest",method=RequestMethod.GET)
	public ModelAndView viewAdminLeaveapplication(HttpSession session){
		List leaveapplicationList = this.leaveapplicationService.searchAll();
		
		System.out.println(leaveapplicationList.size());
		return new ModelAndView("admin/viewLeaveRequest","leaveapplicationList",leaveapplicationList);	
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/replyLeaveRequest",method=RequestMethod.GET)
	public ModelAndView replyAdminLeaveRequest(HttpSession session){
		List leaveapplicationList = this.leaveapplicationService.searchPendingLeave();
		
		System.out.println(leaveapplicationList.size());
		return new ModelAndView("admin/replyLeaveRequest","leaveapplicationList",leaveapplicationList);	
	} 
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/sendReplyLeaveapplication",method=RequestMethod.GET)
	public ModelAndView sendReplyLeaveapplication(@RequestParam String leaveapplicationId,@RequestParam String leaveStatus, HttpSession session){
		LeaveapplicationVO leaveapplicationVO = new LeaveapplicationVO();
		leaveapplicationVO.setId(Integer.parseInt(leaveapplicationId));
		List leaveapplicationList = leaveapplicationService.findById(leaveapplicationVO);
		List leaveList = this.leaveService.search();
		LeaveapplicationVO leaveapplicationVO2 = (LeaveapplicationVO) leaveapplicationList.get(0);
		leaveapplicationVO2.setLeaveStatus(leaveStatus);
		leaveapplicationService.insert(leaveapplicationVO2); 
		return new ModelAndView("redirect:/admin/replyLeaveRequest");		
	}
} 
