package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AllowanceVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String allowance_dedType;
	
	@Column
	private String allowance_dedLimit;
	
	@Column
	private String allowance_dedDescription;
	
	@Column
	private String allowORded;
	
	@ManyToOne
	private DesignationVO designationVO;
	
	@Column
	private String salaryBasicSalary;
	
	public String getSalaryBasicSalary() {
		return salaryBasicSalary;
	}

	public void setSalaryBasicSalary(String salaryBasicSalary) {
		this.salaryBasicSalary = salaryBasicSalary;
	}

	@Column
	private Boolean status = true;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DesignationVO getDesignationVO() {
		return designationVO;
	}

	public void setDesignationVO(DesignationVO designationVO) {
		this.designationVO = designationVO;
	}
	
	

	public String getAllowance_dedType() {
		return allowance_dedType;
	}

	public void setAllowance_dedType(String allowance_dedType) {
		this.allowance_dedType = allowance_dedType;
	}

	public String getAllowance_dedLimit() {
		return allowance_dedLimit;
	}

	public void setAllowance_dedLimit(String allowance_dedLimit) {
		this.allowance_dedLimit = allowance_dedLimit;
	}

	public String getAllowance_dedDescription() {
		return allowance_dedDescription;
	}

	public void setAllowance_dedDescription(String allowance_dedDescription) {
		this.allowance_dedDescription = allowance_dedDescription;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getAllowORded() {
		return allowORded;
	}

	public void setAllowORded(String allowORded) {
		this.allowORded = allowORded;
	}
	


}
