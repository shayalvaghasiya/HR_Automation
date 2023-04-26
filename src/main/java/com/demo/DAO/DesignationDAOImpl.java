package com.demo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.DesignationVO;


@Repository
public class DesignationDAOImpl implements DesignationDAO{



	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insert(DesignationVO designationVO) {
		try{
		
		Session session = this.sessionFactory.getCurrentSession();
		session.save(designationVO);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}

	@SuppressWarnings("rawtypes")
	@Override
	public List search(){
		List ls = new ArrayList<>();
		try{
			
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from DesignationVO where status = true");
			ls = q.list();		
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return ls;
		
		
		
	}

	
	@SuppressWarnings("rawtypes")
	@Override
	public List delete(DesignationVO designationVO){
		List ls = new ArrayList<>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from DesignationVO where id = '"+designationVO.getId()+"'");
			ls = q.list();		
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	
	@Override
	public void update(DesignationVO designationVO) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(designationVO);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	
	@SuppressWarnings("rawtypes")
	@Override
	public List edit(DesignationVO designationVO){
		List ls = new ArrayList();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from DesignationVO where id = '"+designationVO.getId()+"'");
			ls = q.list();		
			System.out.println(ls.size());
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}


}



