package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ComplaintVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String complaintSubject;
	
	@Column
	private String complaintDescription;
	
	@Column
	private String complaintFileName;
	
	@Column
	private String complaintFilePath;
	
	@Column
	private String complaintDate;
	
	@Column
	private String reply;
	
	@Column
	private String replyDate;
	
	@Column
	private String complaintSatus="pending";

	@Column
	private Boolean status=true;

	@ManyToOne
	private LoginVO loginVO;
	
	
	
	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComplaintSubject() {
		return complaintSubject;
	}

	public void setComplaintSubject(String complaintSubject) {
		this.complaintSubject = complaintSubject;
	}

	public String getComplaintDescription() {
		return complaintDescription;
	}

	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
	}

	public String getComplaintFileName() {
		return complaintFileName;
	}

	public void setComplaintFileName(String complaintFileName) {
		this.complaintFileName = complaintFileName;
	}

	public String getComplaintFilePath() {
		return complaintFilePath;
	}

	public void setComplaintFilePath(String complaintFilePath) {
		this.complaintFilePath = complaintFilePath;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(String complaintDate) {
		this.complaintDate = complaintDate;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public String getComplaintSatus() {
		return complaintSatus;
	}

	public void setComplaintSatus(String complaintSatus) {
		this.complaintSatus = complaintSatus;
	} 
 

}
