package com.demo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.DesignationVO;
import com.demo.model.LoanVO;

@Repository
public class LoanDAOImpl implements LoanDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	
	
	
	@Override
	public void insert(LoanVO loanVO) {
		try{
		
		Session session = this.sessionFactory.getCurrentSession();
		session.save(loanVO);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}
	
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public List search(){
		List ls = new ArrayList<>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from LoanVO where status = true");
			ls = q.list();		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	

	
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public List delete(LoanVO loanVO){
		List ls = new ArrayList<>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from LoanVO where id = '"+loanVO.getId()+"'");
			ls = q.list();		
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public void update(LoanVO loanVO) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(loanVO);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List edit(LoanVO loanVO){
		List ls = new ArrayList();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from LoanVO where id = '"+loanVO.getId()+"'");
			ls = q.list();		
			System.out.println(ls.size());
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List searchByDesId(DesignationVO designationVO){
		List ls = new ArrayList<>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from LoanVO where designationVO.id = '"+designationVO.getId()+"'");
			ls = q.list();		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	

	
	
}
