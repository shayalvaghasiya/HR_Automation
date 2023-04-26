package com.demo.DAO;

import java.util.List;

import com.demo.model.ComplaintVO;

public interface ComplaintDAO {

public	void insert(ComplaintVO complaintVO);

@SuppressWarnings("rawtypes")
public List search();

@SuppressWarnings("rawtypes")
public List search(ComplaintVO complaintVO);

@SuppressWarnings("rawtypes")
public List reply(ComplaintVO complaintVO);

public void update(ComplaintVO complaintVO);

}
