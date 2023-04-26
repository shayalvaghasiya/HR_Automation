package com.demo.DAO;

import java.util.List;

import com.demo.model.DesignationVO;
import com.demo.model.MedicalCoverVO;

public interface MedicalCoverDAO {

public	void insert(MedicalCoverVO medicalcoverVO);

@SuppressWarnings("rawtypes")
public List search();

@SuppressWarnings("rawtypes")
public List delete(MedicalCoverVO medicalcoverVO);

public void update(MedicalCoverVO medicalcoverVO);

@SuppressWarnings("rawtypes")
public List edit(MedicalCoverVO medicalcoverVO);

@SuppressWarnings("rawtypes")
public List searchByDesId(DesignationVO designationId);

}
