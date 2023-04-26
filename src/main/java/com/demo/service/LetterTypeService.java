package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.DAO.LetterTypeDAO;
import com.demo.model.LetterTypeVO;

@Service
public class LetterTypeService {

	
		
		@Autowired
		LetterTypeDAO lettertypeDAO;
		
		@Transactional
		public void insert(LetterTypeVO lettertypeVO) {
			this.lettertypeDAO.insert(lettertypeVO);
		
		return;
	}
        @SuppressWarnings("rawtypes")
		@Transactional
		public List search() {
			List letterTypeList = this.lettertypeDAO.search();
			return letterTypeList;
		}
        
        @SuppressWarnings("rawtypes")
		@Transactional
		public List delete(LetterTypeVO lettertypeVO) {
			List letterTypeList = this.lettertypeDAO.delete(lettertypeVO);
			return letterTypeList;
			
		}
        
        @Transactional
		public void update(LetterTypeVO lettertypeVO) {
			this.lettertypeDAO.update(lettertypeVO);
			
		}
        
        @SuppressWarnings("rawtypes")
		@Transactional
		public List edit(LetterTypeVO lettertypeVO) {
        	List letterTypeList = this.lettertypeDAO.edit(lettertypeVO);
			return letterTypeList;
		}
		}
