package com.demo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.SalaryVO;

@Repository
public class SalaryDAOImpl implements SalaryDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insert(SalaryVO salaryVO) {
		try{
		
		Session session = this.sessionFactory.getCurrentSession();
		session.save(salaryVO);
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
			Query q = session.createQuery("from SalaryVO where status = true");
			ls = q.list();		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	

	@SuppressWarnings("rawtypes")
	@Override
	public List delete(SalaryVO salaryVO){
		List ls = new ArrayList<>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from SalaryVO where id = '"+salaryVO.getId()+"'");
			ls = q.list();		
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public void update(SalaryVO salaryVO) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(salaryVO);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List edit(SalaryVO salaryVO){
		List ls = new ArrayList();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from SalaryVO where id = '"+salaryVO.getId()+"'");
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
	public List searchAjaxSalary(SalaryVO salaryVO){
		List ls = new ArrayList();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from SalaryVO where designationVO='"+salaryVO.getDesignationVO().getId()+"'");
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
			Query q = session.createQuery(" from SalaryVO where designationVO.id='"+designationId+"'");
			ls = q.list();		
			System.out.println(ls.size());
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("salaryBasicSalary : " + ls);
		return ls;
	}	

	@SuppressWarnings("rawtypes")
	public List searchForGraph(){
		List ls = new ArrayList();
		
		Session session = this.sessionFactory.getCurrentSession();
		
		Query q = session.createQuery("from SalaryVO ");
		
		ls = q.list();
		
		return ls;
	}

}
