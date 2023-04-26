package com.demo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.SalarySlipVO;

@Repository
public class SalarySlipDAOImpl implements SalarySlipDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	public void insert(SalarySlipVO salarySlipVO) {
		try{
			Session session = this.sessionFactory.getCurrentSession();
			session.save(salarySlipVO);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@SuppressWarnings("rawtypes")
	@Override
	public List search(){
		List ls = new ArrayList<>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from SalarySlipVO");
			ls = q.list();		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
}
