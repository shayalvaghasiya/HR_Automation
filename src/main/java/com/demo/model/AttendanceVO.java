package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AttendanceVO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column
	private String attendanceFileMonth;

	@Column
	private String employeeIDno;
	
	@Column
	private Double numberOfWorkingDays;
	
	@Column
	private Double presentDays;
	
	@Column
	private Boolean status; 
	
	@ManyToOne
	private LeaveVO leaveVO;
	
	@Column
	private Double noOfLeavesTaken;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAttendanceFileMonth() {
		return attendanceFileMonth;
	}

	public void setAttendanceFileMonth(String attendanceFileMonth) {
		this.attendanceFileMonth = attendanceFileMonth;
	}

	public String getEmployeeIDno() {
		return employeeIDno;
	}

	public void setEmployeeIDno(String employeeIDno) {
		this.employeeIDno = employeeIDno;
	}

	public Double getNumberOfWorkingDays() {
		return numberOfWorkingDays;
	}

	public void setNumberOfWorkingDays(Double numberOfWorkingDays) {
		this.numberOfWorkingDays = numberOfWorkingDays;
	}

	public Double getPresentDays() {
		return presentDays;
	}

	public void setPresentDays(Double presentDays) {
		this.presentDays = presentDays;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public LeaveVO getLeaveVO() {
		return leaveVO;
	}

	public void setLeaveVO(LeaveVO leaveVO) {
		this.leaveVO = leaveVO;
	}

	public Double getNoOfLeavesTaken() {
		return noOfLeavesTaken;
	}

	public void setNoOfLeavesTaken(Double noOfLeavesTaken) {
		this.noOfLeavesTaken = noOfLeavesTaken;
	}
	

}
