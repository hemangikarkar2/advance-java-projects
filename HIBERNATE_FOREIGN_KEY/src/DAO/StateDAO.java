package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.StateVO;

public class StateDAO 
{

	public void insert(StateVO v)
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
			
			Query q=session.createQuery("from StateVO");
			
			List ls=q.list();
	
		return ls;
	}

	
	public void delete(StateVO v)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		session.delete(v);
		
		transaction.commit();
		
		session.close();
	}

	
	
	public List edit(StateVO v)
	{		
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Query q=session.createQuery("from StateVO where id="+v.getId());
			
			List ls=q.list();

		return ls;
	}



	public void update(StateVO v)
	{
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				
				Session session = sessionFactory.openSession();
				
				Transaction transaction=session.beginTransaction();
				
				session.update(v);
				
				transaction.commit();
				
				session.close();
	}


}
