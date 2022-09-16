package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Vo.stateVo;
@Repository
public class stateDao {
	@Autowired
	private SessionFactory sessionFactory;
	public  void deleteState(stateVo stateVo) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
			
		session.delete(stateVo);
			
		transaction.commit();
			
		session.close();	
	}

	public void insertState(stateVo stateVo) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		session.saveOrUpdate(stateVo);
		
		transaction.commit();
		
		session.close();

	}

	public List searchstate() {
		List ls=new ArrayList();
		
		Session session=sessionFactory.openSession();
		
		Query q=session.createQuery("from stateVo where status=true");
		
		ls=q.list();
		
		session.close();
		
		return ls;

	}

	public List editstate(stateVo stateVo) {
		
		 List l=new ArrayList();
		
		Session session=sessionFactory.openSession();
		
		Query q=session.createQuery("from stateVo where stateId="+stateVo.getStateId());
		
		l=q.list();
		
		session.close();
	
			return l;
	}

	

}
