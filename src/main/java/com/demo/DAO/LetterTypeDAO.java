package com.demo.DAO;

import java.util.List;

import com.demo.model.LetterTypeVO;

public interface LetterTypeDAO {

	public void insert(LetterTypeVO lettertypeVO);

	@SuppressWarnings("rawtypes")
	public List search();

	@SuppressWarnings("rawtypes")
	public List delete(LetterTypeVO lettertypeVO);

	public void update(LetterTypeVO lettertypeVO);

	@SuppressWarnings("rawtypes")
	public List edit(LetterTypeVO lettertypeVO);


}
