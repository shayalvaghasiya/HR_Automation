package com.demo.DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.demo.model.FeedbackVO;

@Repository
public class FeedbackDAOImpl implements FeedbackDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void insert(FeedbackVO feedbackVO) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.save(feedbackVO);	
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
			Query q = session.createQuery("from FeedbackVO where status = true");
			ls = q.list();		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	
	
}
