package com.demo.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.RegisterVO;

@Repository
public class RegisterDAOImpl implements RegisterDAO{

	@Autowired SessionFactory sessionFactory;
	
	
	public void insert(RegisterVO registerVO)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(registerVO);
	}
	
	
	public List search()
	{
			Session session = sessionFactory.getCurrentSession();
			
			Query q=session.createQuery("from RegisterVO where status=true");
			
			List ls=q.list();
	
		return ls;
	}
	
	
	public List deleteEdit(RegisterVO registerVO)
	{
			Session session = sessionFactory.getCurrentSession();
			
			Query q=session.createQuery("from RegisterVO where status=true and id="+registerVO.getId());
			
			List ls=q.list();
	
		return ls;
	}
	
	
}
