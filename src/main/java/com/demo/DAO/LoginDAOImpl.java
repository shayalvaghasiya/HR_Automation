package com.demo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.LoginVO;

@Repository
public class LoginDAOImpl implements LoginDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void insert(LoginVO loginVO) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.save(loginVO);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	@Override
	public void update(LoginVO loginVO) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(loginVO);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List searchByUserName(String userName) {
		List ls = new ArrayList();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			
			System.out.println("\n\n\n\n\n\nfrom LoginVO where userName = '"+userName+"'");
			
			Query q = session.createQuery("from LoginVO where userName ='"+userName+"'");	
			ls = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\n\nLoginDAOImpl : " + ls.size());
		
		return ls;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List searchstep1(LoginVO loginVO) 
	{
		
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from LoginVO where username = '"+loginVO.getUserName()+"' ");
		List ls = q.list();
		return ls;
	}
	
	@Override
	public void updatePassword(LoginVO loginVO) {
		
		Session session=sessionFactory.openSession();
		Query q=session.createQuery("UPDATE LoginVO set password='"+loginVO.getPassword() +"'where username='"+loginVO.getUserName()+"'");
		q.executeUpdate();
	}
}
