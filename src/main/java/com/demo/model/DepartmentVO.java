package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DepartmentVO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String departmentName;
	
	@Column
	private String departmentDescription;

	@Column
	private Boolean status;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentDescription() {
		return departmentDescription;
	}

	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
	
}
