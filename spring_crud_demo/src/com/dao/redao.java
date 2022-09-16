package com.dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.vo.regvo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;
@Repository
public class redao {

	@Autowired
	private SessionFactory sessionFacotry;
	
	public void insert(regvo regvo)
	{
		try{
			Session session = sessionFacotry.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.saveOrUpdate(regvo);
			transaction.commit();
			
		}catch(Exception e){ e.printStackTrace();}
	}
	public List search(){
		Session  session =sessionFacotry.openSession();
		
		Query q = session.createQuery("from regvo");
		
		List ls=q.list();
		
		return ls;
	}
	public void delete(regvo regvo)
	{
		try{
			Session session = sessionFacotry.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.delete(regvo);
			transaction.commit();
			
		}catch(Exception e){ e.printStackTrace();}
	}
	
	public List edit(regvo regvo){
		Session  session =sessionFacotry.openSession();
		
		Query q = session.createQuery("from regvo where Id="+regvo.getId());
		
		List ls=q.list();
		
		session.close();
		
		return ls;
	}
}
