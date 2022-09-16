package com.demo.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.LoginVO;
import com.demo.model.RegVO;

@Repository
public class RegDAOImpl implements RegDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	public void insert(RegVO regVO){
		
		Session session =this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(regVO);
	
	}
	public void insertLogin(LoginVO loginVO) {
		Session session =this.sessionFactory.getCurrentSession();;
		session.saveOrUpdate(loginVO);

	}

	public List searchRegister() {
		List searchList = new ArrayList();
		Session session =this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from RegVO");
		searchList = q.list()
		
		return searchList;

	}
}
