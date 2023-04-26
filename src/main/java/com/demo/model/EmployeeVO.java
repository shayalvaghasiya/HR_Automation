package com.demo.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EmployeeVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String employeeFirstName;
	
	@Column
	private String employeeLastName;
	
	@Column
	private String employeeIDno;

	@Column
	private String employeeContact;
	
	@Column
	private String employeeAddress;
	
	@Column
	private String employeeDateofBirth;
	
	@Column
	private String employeeBloodGroup;
	
	@Column
	private String employeeMaritalStatus;
	
	@ManyToOne
	private DesignationVO designationVO;
	
	@ManyToOne
	private DepartmentVO departmentVO;
	
	@Column
	private Boolean status = true;
	
	@Column
	private String paySlipStatus = "pending";

		
    @ManyToOne
	private LoginVO loginVO;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public String getEmployeeIDno() {
		return employeeIDno;
	}

	public void setEmployeeIDno(String employeeIDno) {
		this.employeeIDno = employeeIDno;
	}

	public String getEmployeeContact() {
		return employeeContact;
	}

	public void setEmployeeContact(String employeeContact) {
		this.employeeContact = employeeContact;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeDateofBirth() {
		return employeeDateofBirth;
	}

	public void setEmployeeDateofBirth(String employeeDateofBirth) {
		this.employeeDateofBirth = employeeDateofBirth;
	}

	public String getEmployeeBloodGroup() {
		return employeeBloodGroup;
	}

	public void setEmployeeBloodGroup(String employeeBloodGroup) {
		this.employeeBloodGroup = employeeBloodGroup;
	}

	public String getEmployeeMaritalStatus() {
		return employeeMaritalStatus;
	}

	public void setEmployeeMaritalStatus(String employeeMaritalStatus) {
		this.employeeMaritalStatus = employeeMaritalStatus;
	}

	public DesignationVO getDesignationVO() {
		return designationVO;
	}

	public void setDesignationVO(DesignationVO designationVO) {
		this.designationVO = designationVO;
	}

	public DepartmentVO getDepartmentVO() {
		return departmentVO;
	}

	public void setDepartmentVO(DepartmentVO departmentVO) {
		this.departmentVO = departmentVO;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public String getPaySlipStatus() {
		return paySlipStatus;
	}

	public void setPaySlipStatus(String paySlipStatus) {
		this.paySlipStatus = paySlipStatus;
	}
	


}
