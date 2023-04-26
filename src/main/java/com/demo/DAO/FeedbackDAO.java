package com.demo.DAO;

import java.util.List;

import com.demo.model.FeedbackVO;

public interface FeedbackDAO {

public	void insert(FeedbackVO feedbackVO);

@SuppressWarnings("rawtypes")
public List search();

}
