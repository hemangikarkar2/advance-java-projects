package dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.countryvo;

public class countrydao {

		public void insert(countryvo cv1){

			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.save(cv1);
			
			transaction.commit();
			
			session.close();
		}

	public List search() {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Query q=session.createQuery("from countryvo");
		
		List ls=q.list();

	return ls;
		
	}

	public void delete(countryvo v) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		session.delete(v);
		
		transaction.commit();
		
		session.close();
		
	}

	public List edit(countryvo v) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Query q=session.createQuery("from countryvo where id="+v.getId());
		
		List ls=q.list();

	return ls;
		
	}

	public void update(countryvo v) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		session.update(v);
		
		transaction.commit();
		
		session.close();
	}

	
}