package com.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.VO.regVo;

public class regDao {

	public static void insert(regVo regVo) {

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(regVo);
		
		transaction.commit();
		session.close();
	}

	public List search() {
		// TODO Auto-generated method stub
		
		List searchList = new ArrayList<>();
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query q = session.createQuery("from regVo");
		searchList = q.list();
		
		transaction.commit();
		session.close();
		
		return searchList;
	}
	public List edit(regVo regVo) {

		List editList = new ArrayList<>();
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query q = session.createQuery("from regVo where id="+regVo.getId());
		 editList = q.list();
		
		return editList;
}




	public void delete(regVo regVo ) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.delete(regVo);
		
		transaction.commit();
		session.close();
	}

	public void update(regVo regVo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.update(regVo);
		
		transaction.commit();
		session.close();
		
	}



}
