package com.demo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.LeaveVO;

@Repository
public class LeaveDAOImpl implements LeaveDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insert(LeaveVO leaveVO) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.save(leaveVO);	
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
			Query q = session.createQuery("from LeaveVO where status = true");
			ls = q.list();		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public List delete(LeaveVO leaveVO){
		List ls = new ArrayList<>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from LeaveVO where id = '"+leaveVO.getId()+"'");
			ls = q.list();		
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	
	
	@Override
	public void update(LeaveVO leaveVO) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(leaveVO);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	@SuppressWarnings("rawtypes")
	@Override
	public List edit(LeaveVO leaveVO){
		List ls = new ArrayList();
		
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from LeaveVO where id = '"+leaveVO.getId()+"'");
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
	public List searchById(LeaveVO leaveVO) {
		List ls = new ArrayList<>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from LeaveVO where id ='"+leaveVO.getId()+"'");
			ls = q.list();		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	
}
