package com.demo.DAO;

import java.util.List;

import com.demo.model.DesignationVO;

public interface DesignationDAO {
	
	void insert (DesignationVO designationVO);

	@SuppressWarnings("rawtypes")
	public List search();

	@SuppressWarnings("rawtypes")
	public List delete(DesignationVO designationVO);

	public void update(DesignationVO designationVO);

	@SuppressWarnings("rawtypes")
	public List edit(DesignationVO designationVO);


	

}
