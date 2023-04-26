package com.demo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.LetterTypeVO;

@Repository
public class LetterTypeDAOImpl implements LetterTypeDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insert(LetterTypeVO lettertypeVO) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.save(lettertypeVO);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("rawtypes")
	@Override
	public List search(){
		List ls = new ArrayList<>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from LetterTypeVO where status = true");
			ls = q.list();		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public List delete(LetterTypeVO lettertypeVO){
		List ls = new ArrayList<>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from LetterTypeVO where id = '"+lettertypeVO.getId()+"'");
			ls = q.list();		
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public void update(LetterTypeVO lettertypeVO) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(lettertypeVO);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	
	@SuppressWarnings("rawtypes")
	@Override
	public List edit(LetterTypeVO lettertypeVO){
		List ls = new ArrayList();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from LetterTypeVO where id = '"+lettertypeVO.getId()+"'");
			ls = q.list();		
			System.out.println(ls.size());
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	
	
	
}
