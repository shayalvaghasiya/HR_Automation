package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LetterTypeVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String letterTypeName;
	
	@Column
	private String letterTypeDescription;
	
	@Column
	private String letterTypeFileName;
	
	@Column
	private String letterTypeFilePath;

	@Column
	private Boolean status; 
	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLetterTypeName() {
		return letterTypeName;
	}

	public void setLetterTypeName(String letterTypeName) {
		this.letterTypeName = letterTypeName;
	}

	public String getLetterTypeDescription() {
		return letterTypeDescription;
	}

	public void setLetterTypeDescription(String letterTypeDescription) {
		this.letterTypeDescription = letterTypeDescription;
	}

	public String getLetterTypeFileName() {
		return letterTypeFileName;
	}

	public void setLetterTypeFileName(String letterTypeFileName) {
		this.letterTypeFileName = letterTypeFileName;
	}

	public String getLetterTypeFilePath() {
		return letterTypeFilePath;
	}

	public void setLetterTypeFilePath(String letterTypeFilePath) {
		this.letterTypeFilePath = letterTypeFilePath;
	}
	
	
	

}
