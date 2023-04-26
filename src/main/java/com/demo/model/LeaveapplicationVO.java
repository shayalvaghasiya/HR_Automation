package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LeaveapplicationVO {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String fromDate;
	
	@Column
	private String toDate;
	
	@ManyToOne
	private LeaveVO leaveVO;
	
	@ManyToOne
	private EmployeeVO employeeVO;
	
	@Column
	private String leaveStatus;
	
	@Column
	private String leavedescription;
	
	@Column 
	private Boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public LeaveVO getLeaveVO() {
		return leaveVO;
	}

	public void setLeaveVO(LeaveVO leaveVO) {
		this.leaveVO = leaveVO;
	}

	public EmployeeVO getEmployeeVO() {
		return employeeVO;
	}

	public void setEmployeeVO(EmployeeVO employeeVO) {
		this.employeeVO = employeeVO;
	}

	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getLeavedescription() {
		return leavedescription;
	}

	public void setLeavedescription(String leavedescription) {
		this.leavedescription = leavedescription;
	}
	
	
	
}
