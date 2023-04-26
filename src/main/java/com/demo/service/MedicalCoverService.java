package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.DAO.MedicalCoverDAO;
import com.demo.model.DesignationVO;
import com.demo.model.MedicalCoverVO;


@Service
public class MedicalCoverService {
	
	
	@Autowired
	MedicalCoverDAO medicalcoverdao;
	
	@Transactional
	public void insert(MedicalCoverVO medicalcoverVO) {
		this.medicalcoverdao.insert(medicalcoverVO);
	
				
	}

	
	@SuppressWarnings("rawtypes")
	@Transactional
	public List search() {
		List medicalcoverList = this.medicalcoverdao.search();
		return medicalcoverList;
	}

 
	@SuppressWarnings("rawtypes")
	@Transactional
	public List delete(MedicalCoverVO medicalcoverVO) {
		List medicalcoverList = this.medicalcoverdao.delete(medicalcoverVO);
		return medicalcoverList;
	}


	@Transactional
	public void update(MedicalCoverVO medicalcoverVO) {
		this.medicalcoverdao.update(medicalcoverVO);
		
	}


	@SuppressWarnings("rawtypes")
	@Transactional
	public List edit(MedicalCoverVO medicalcoverVO) {
		List medicalcoverList = this.medicalcoverdao.edit(medicalcoverVO);
		return medicalcoverList;
	}


	@SuppressWarnings("rawtypes")
	@Transactional
	public List searchByDesId(DesignationVO designationId) {
		List medicalcoverList = this.medicalcoverdao.searchByDesId(designationId);
		return medicalcoverList;
	}

}
