package dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.statevo;

public class statedao {

	public void insert(statevo v2) {
		// TODO Auto-generated method stub
	
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		session.save(v2);
		
		transaction.commit();
		
		session.close();
	}

	public List search() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Query q=session.createQuery("from statevo");
		
		List ls=q.list();

	return ls;
	}

	public void delete(statevo v2) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		session.delete(v2);
		
		transaction.commit();
		
		session.close();
	}

	public void update(statevo v2) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		session.update(v2);
		
		transaction.commit();
		
		session.close();
	}

	public List edit(statevo v2) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Query q=session.createQuery("from statevo where id="+v2.getId());
		
		List ls=q.list();

	return ls;	
	
	}
 }
	
	

