package DAO;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.CountryVO;
import VO.StateVO;

public class CountryDAO 
{
	public void insert(CountryVO v1)
	{
		
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				
				Session session = sessionFactory.openSession();
				
				Transaction transaction=session.beginTransaction();
				
				session.save(v1);
				
				transaction.commit();
				
				session.close();
	}

	

	public List search()
	{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Query q=session.createQuery("from CountryVO");
			
			List ls=q.list();
	
		return ls;
	}


			public void delete(CountryVO v1)
			{
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				
				Session session = sessionFactory.openSession();
				
				Transaction transaction=session.beginTransaction();
				
				session.delete(v1);
				
				transaction.commit();
				
				session.close();
			}
	
			
			public List edit(CountryVO v1)
			{		
					SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
					
					Session session = sessionFactory.openSession();
					
					Query q=session.createQuery("from CountryVO where id="+v1.getId());
					
					List ls=q.list();

				return ls;
			}



			public void update(CountryVO v1)
			{
						SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
						
						Session session = sessionFactory.openSession();
						
						Transaction transaction=session.beginTransaction();
						
						session.update(v1);
						
						transaction.commit();
						
						session.close();
			}

}

