package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.demo.DAO.FeedbackDAO;
import com.demo.model.FeedbackVO;

@Service
public class FeedbackService {

	@Autowired
	FeedbackDAO feedbackDAO;

	@Transactional
	public void insert(FeedbackVO feedbackVO) {
		this.feedbackDAO.insert(feedbackVO);
		
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List search() {
		List feedbackList = this.feedbackDAO.search();
		return feedbackList;
	}
}
