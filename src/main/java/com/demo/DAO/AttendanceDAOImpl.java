package com.demo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.AttendanceVO;

@Repository
public class AttendanceDAOImpl implements AttendanceDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insert(AttendanceVO attendanceVO) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.save(attendanceVO);	
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
			Query q = session.createQuery("from AttendanceVO where status = true");
			ls = q.list();		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	

	
	@SuppressWarnings("rawtypes")
	@Override
	public List delete(AttendanceVO attendanceVO){
		List ls = new ArrayList<>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from AttendanceVO where id = '"+attendanceVO.getId()+"'");
			ls = q.list();		
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public void update(AttendanceVO attendanceVO) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(attendanceVO);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@SuppressWarnings("rawtypes")
	@Override
	public List searchByEmpId(String employeeIdNumber){
		List ls = new ArrayList<>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			System.out.println("\n\n\n\n\nfrom AttendanceVO where employeeIDno = '"+employeeIdNumber+"'");
			Query q = session.createQuery("from AttendanceVO where employeeIDno = '"+employeeIdNumber+"'");
			ls = q.list();		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	

	
}
