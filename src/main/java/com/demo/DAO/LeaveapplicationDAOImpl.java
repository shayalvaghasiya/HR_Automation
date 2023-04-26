package com.demo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.LeaveapplicationVO;

@Repository
@EnableTransactionManagement
public class LeaveapplicationDAOImpl implements LeaveapplicationDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void insert(LeaveapplicationVO leaveapplicationVO) {
		try {

			
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(leaveapplicationVO);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	@Transactional
	public List search() {
		List ls = new ArrayList<LeaveapplicationVO>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from LeaveapplicationVO where status = true");
			ls = q.list();		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	@Transactional
	public List findById(LeaveapplicationVO leaveapplicationVO) {
		// TODO Auto-generated method stub
		List ls = new ArrayList<LeaveapplicationVO>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from LeaveapplicationVO where status = true and id = '"+leaveapplicationVO.getId()+"'");
			ls = q.list();		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

}
