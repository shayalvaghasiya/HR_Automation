package com.demo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.DesignationVO;
import com.demo.model.MedicalCoverVO;


@Repository
public class MedicalCoverDAOImpl implements MedicalCoverDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insert(MedicalCoverVO medicalcoverVO) {
		try{
		
		Session session = this.sessionFactory.getCurrentSession();
		session.save(medicalcoverVO);
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
			Query q = session.createQuery("from MedicalCoverVO where status = true");
			ls = q.list();		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public List delete(MedicalCoverVO medicalcoverVO){
		List ls = new ArrayList<>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from MedicalCoverVO where id = '"+medicalcoverVO.getId()+"'");
			ls = q.list();		
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public void update(MedicalCoverVO medicalcoverVO) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(medicalcoverVO);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public List edit(MedicalCoverVO medicalcoverVO){
		List ls = new ArrayList();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from MedicalCoverVO where id = '"+medicalcoverVO.getId()+"'");
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
	public List searchByDesId(DesignationVO designationVO){
		List ls = new ArrayList<>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from MedicalCoverVO where designationVO.id = '"+designationVO.getId()+"'");
			ls = q.list();		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	

	

}
