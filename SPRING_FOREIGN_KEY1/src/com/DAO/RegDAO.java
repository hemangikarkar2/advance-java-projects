package com.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.LoginVO;
import com.VO.RegisterVO;

@Repository
public class RegDAO {

	@Autowired
	SessionFactory sessionFacory;

	public void insertLogin(LoginVO loginVO) {
		Session session = sessionFacory.openSession();
		Transaction transction = session.beginTransaction();
		session.saveOrUpdate(loginVO);
		transction.commit();
		session.close();

	}

	public void insertRegister(RegisterVO registerVO) {
		Session session = sessionFacory.openSession();
		Transaction transction = session.beginTransaction();
		session.saveOrUpdate(registerVO);
		transction.commit();
		session.close();

	}

	public List searchRegister() {
		List searchList = new ArrayList();
		Session session = sessionFacory.openSession();
		Transaction transction = session.beginTransaction();
		Query q = session.createQuery("from RegisterVO");
		searchList = q.list();
		transction.commit();
		session.close();
		return searchList;

	}

	public void deleteLogin(LoginVO loginVO) {
		Session session = sessionFacory.openSession();
		Transaction transction = session.beginTransaction();
		session.delete(loginVO);
		transction.commit();
		session.close();

	}

	public void deleteRegister(RegisterVO registerVO) {
		Session session = sessionFacory.openSession();
		Transaction transction = session.beginTransaction();
		session.delete(registerVO);
		transction.commit();
		session.close();

	}

	public List editLogin(LoginVO loginVO) {
		List editList1 = new ArrayList();
		Session session = sessionFacory.openSession();
		Transaction transction = session.beginTransaction();
		Query q = session.createQuery("from LoginVO");
		editList1 = q.list();
		transction.commit();
		session.close();
		return editList1;

	}

	public List editRegister(RegisterVO registerVO) {
		List editList = new ArrayList();
		Session session = sessionFacory.openSession();
		Transaction transction = session.beginTransaction();
		Query q = session.createQuery("from RegisterVO where id=" + registerVO.getId());
		editList = q.list();
		transction.commit();
		session.close();
		return editList;

	}

}
