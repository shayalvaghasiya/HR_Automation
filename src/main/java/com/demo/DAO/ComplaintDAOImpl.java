package com.demo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.demo.model.ComplaintVO;

@Repository
public class ComplaintDAOImpl implements ComplaintDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insert(ComplaintVO complaintVO) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.save(complaintVO);	
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
			Query q = session.createQuery("from ComplaintVO where status = true");
			ls = q.list();		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List search(ComplaintVO complaintVO){
		List ls = new ArrayList<>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from ComplaintVO where status = true and loginVO.id = " + complaintVO.getLoginVO().getId());
			ls = q.list();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	@Override
	public void update(ComplaintVO complaintVO) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(complaintVO);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List reply(ComplaintVO complaintVO){
		List ls = new ArrayList();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from ComplaintVO where id = '"+complaintVO.getId()+"'");
			ls = q.list();		
			System.out.println(ls.size());
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}


}
