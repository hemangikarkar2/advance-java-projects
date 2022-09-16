package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.CountryVO;
import com.VO.StateVO;

@Repository
public class CountryDAO {

	@Autowired SessionFactory sessionFactory;
	
	
	public void insertCountry(CountryVO countryVO)
	{
		
		Session session = sessionFactory.openSession();
		Transaction transction = session.beginTransaction();
		session.saveOrUpdate(countryVO);
		transction.commit();
		session.close();
	}
	
	public List searchCountry()
	{
		
		Session session = sessionFactory.openSession();
		
		Query q=session.createQuery("from CountryVO where status=true");
		
		List ls=q.list();
		
		session.close();

		return ls;

	}
	
	
	public void deleteCountry(CountryVO countryVO)
	{
		
		Session session = sessionFactory.openSession();
		Transaction transction = session.beginTransaction();
		session.delete(countryVO);
		transction.commit();
		session.close();
	}
	
	public List editCountry(CountryVO countryVO)
	{
		
		Session session = sessionFactory.openSession();
		
		Query q=session.createQuery("from CountryVO where countryId="+countryVO.getCountryId());
		
		List ls=q.list();
		
		session.close();

		return ls;

	}
	
	public List SearchAllState(CountryVO CountryVO)
	{
		
		Session session = sessionFactory.openSession();
		
		Query q=session.createQuery("from StateVO where countryVO_CountryId="+CountryVO.getCountryId());
		
		List ls=q.list();
		
		session.close();

		return ls;

	}


}


