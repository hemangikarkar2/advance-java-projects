package com.Dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Vo.LoginVO;
import com.Vo.RegisterVO;

@Repository
public class RegDAO {

	@Autowired
	SessionFactory sessionFactory;
	public void insertLogin(LoginVO loginVO) {
		Session session =sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(loginVO);
		transaction.commit();
		session.close();
	}

	public void insertRegister(RegisterVO registerVO) {
		Session session =sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(registerVO);
		transaction.commit();
		session.close();
		
	}

	public List searchRegister() {
		List searchList = new ArrayList();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query query1=session.createQuery("from RegisterVO");
		searchList=query1.list();
		transaction.commit();
		session.close();
		return searchList;
	}

	public void deleteRegister(RegisterVO registerVO) {
		Session session =sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.delete(registerVO);
		transaction.commit();
		session.close();
		
	}

	public void deleteLogin(LoginVO loginVO) {
		Session session =sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.delete(loginVO);
		transaction.commit();
		session.close();
	}

	

	public  List editRegister(RegisterVO registerVO) {
		
		List editList1 = new ArrayList();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query query1=session.createQuery("from RegisterVO where id="+registerVO.getId());
		editList1=query1.list();
		transaction.commit();
		session.close();
		return editList1;
	
	}

	public List editLogin(LoginVO loginVO) {
	
		List editList1 = new ArrayList();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query query1=session.createQuery("from LoginVO");
		editList1=query1.list();
		transaction.commit();
		session.close();
		return editList1;
	}

}







