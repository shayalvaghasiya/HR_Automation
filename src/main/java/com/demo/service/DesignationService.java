package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.DAO.DesignationDAO;
import com.demo.model.DesignationVO;

@Service
public class DesignationService {
	
	
		
		@Autowired
		DesignationDAO designationDAO;
		
		@Transactional
		public void insert(DesignationVO designationVO) {
			this.designationDAO.insert(designationVO);	
		}

		@SuppressWarnings("rawtypes")
		@Transactional
		public List search() {
			List designationList =this.designationDAO.search();
			return designationList;
		}

		@SuppressWarnings("rawtypes")
		@Transactional
		public List delete(DesignationVO designationVO) {
			List designationList = this.designationDAO.delete(designationVO);
			return designationList;
			
			
		}

		@Transactional
		public void update(DesignationVO designationVO) {
			this.designationDAO.update(designationVO);
			
		
			
		}

		@SuppressWarnings("rawtypes")
		@Transactional
		public List edit(DesignationVO designationVO) {
			List designationList = this.designationDAO.edit(designationVO);
			return designationList;
		}

		
	}


	