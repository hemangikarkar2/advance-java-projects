package com.DAO;

import java.util.ArrayList;
import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.VO.RegVO;

public class RegDAO {
	
	public void insert(RegVO regVO) {

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(regVO); 
		
		transaction.commit();
		session.close();
	}
	
	public List search() {

		List searchList = new ArrayList<>();
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query q = session.createQuery("from RegVO");
		searchList = q.list();
		
		transaction.commit();
		session.close();
		
		return searchList;
	}
	
	public void delete(RegVO regVO) {

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.delete(regVO);
		
		transaction.commit();
		session.close();
	}

	public List edit(RegVO regVO) {

			List editList = new ArrayList<>();
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Query q = session.createQuery("from RegVO where id="+regVO.getId());
			 editList = q.list();
			
			return editList;
	}
	
	public void update(RegVO regVO) {

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.update(regVO);
		
		transaction.commit();
		session.close();
	}

}
