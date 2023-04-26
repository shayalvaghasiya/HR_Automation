package com.demo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.AllowanceVO;

@Repository
public class AllowanceDAOImpl implements AllowanceDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insert(AllowanceVO allowanceVO) {
		try{
		
		Session session = this.sessionFactory.getCurrentSession();
		session.save(allowanceVO);
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
			Query q = session.createQuery("from AllowanceVO where status = true");
			ls = q.list();		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public List delete(AllowanceVO allowanceVO){
		List ls = new ArrayList<>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from AllowanceVO where id = '"+allowanceVO.getId()+"'");
			ls = q.list();		
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public void update(AllowanceVO allowanceVO) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(allowanceVO);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List edit(AllowanceVO allowanceVO){
		List ls = new ArrayList();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from AllowanceVO where id = '"+allowanceVO.getId()+"'");
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
	public List searchAjaxSalary(AllowanceVO allowanceVO){
		List ls = new ArrayList();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from AllowanceVO where  designationVO.id= '"+allowanceVO.getDesignationVO().getId()+"'");
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
	public List searchBydesignationid(int designationId){
		List ls = new ArrayList();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery(" from AllowanceVO where designationVO.id='"+designationId+"'");
			ls = q.list();		
			System.out.println(ls.size());
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return ls;
	}	


	

}
