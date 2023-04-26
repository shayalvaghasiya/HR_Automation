package com.demo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.EmployeeVO;

@Repository
public class EmployeeDAOImpl implements  EmployeeDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void insert(EmployeeVO employeeVO) {
		try {

			System.out.println("*************** DAO ***************");
			System.out.println(employeeVO.getLoginVO().getId());
			
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(employeeVO);	
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
			Query q = session.createQuery("from EmployeeVO where status = true");
			ls = q.list();		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	

		
	@SuppressWarnings("rawtypes")
	@Override
	public List delete(EmployeeVO employeeVO){
		List ls = new ArrayList<>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from EmployeeVO where id = '"+employeeVO.getId()+"'");
			ls = q.list();		
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	
	@Override
	public void update(EmployeeVO employeeVO) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(employeeVO);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List edit(EmployeeVO employeeVO){
		List ls = new ArrayList();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from EmployeeVO where id = '"+employeeVO.getId()+"'");
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
	public List searchByLoginId(EmployeeVO employeeVO){
		List ls = new ArrayList();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			
			System.out.println("from EmployeeVO where loginVO.id = '"+employeeVO.getLoginVO().getId()+"'");
			
			Query q = session.createQuery("from EmployeeVO where loginVO.id = '"+employeeVO.getLoginVO().getId()+"'");
			
			ls = q.list();		
			
			System.out.println(ls.size());
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	@SuppressWarnings("rawtypes")
	public List searchForGraph(){
		List ls = new ArrayList();
		
		Session session = this.sessionFactory.getCurrentSession();
		
		Query q = session.createQuery("from EmployeeVO ");
		
		ls = q.list();
		
		return ls;
	}
	
//	@SuppressWarnings("rawtypes")
//	@Override
//	public List SearchByEmpId(String id){
//		List ls = new ArrayList();
//		try {
//			Session session = this.sessionFactory.getCurrentSession();
//			Query q = session.createQuery("from EmployeeVO where id = '"+employeeVO.getId()+"'");
//			ls = q.list();		
//			System.out.println(ls.size());
//			} 
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		return ls;
//	}
}
