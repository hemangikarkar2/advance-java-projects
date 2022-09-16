package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.RegVO;
import VO.UserVO;


public class RegDAO 
{

	public void insertRegister(RegVO v1)
		{
			try
				{
					SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
					
					Session session = sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					session.save(v1);
					
					transaction.commit();
					
					session.close();
				}
			catch(Exception ex)
				{
					ex.printStackTrace();
				}
		}

	
	public void insertUSer(UserVO v2)
	{
		try
			{
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				
				Session session = sessionFactory.openSession();
				
				Transaction transaction=session.beginTransaction();
				
				session.save(v2);
				
				transaction.commit();
				
				session.close();
			}
		catch(Exception ex)
			{
				ex.printStackTrace();
			}
	}

}
