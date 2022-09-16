package DAO;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import VO.CountryVO;
import VO.CityVO;
import VO.StateVO;

public class CityDAO 
{
	public void insert(CityVO v)
	{
		
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				
				Session session = sessionFactory.openSession();
				
				Transaction transaction=session.beginTransaction();
				
				session.save(v);
				
				transaction.commit();
				
				session.close();
	}
	
	public List search()
	{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Query q=session.createQuery("from CityVO");
			
			List ls=q.list();
	
		return ls;
	}


	public void delete(CityVO v)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		session.delete(v);
		
		transaction.commit();
		
		session.close();
	}
	
	public List edit(CityVO v)
	{		
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Query q=session.createQuery("from CityVO where id="+v.getId());
			
			List ls=q.list();

		return ls;
	}



	public void update(CityVO v)
	{
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				
				Session session = sessionFactory.openSession();
				
				Transaction transaction=session.beginTransaction();
				
				session.update(v);
				
				transaction.commit();
				
				session.close();
	}



}
