package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Vo.countryVo;

@Repository
public class countryDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void insertCountry(countryVo countryVo) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(countryVo);
		transaction.commit();
		session.close();
	}



	public List searchCountry() {
		Session session = sessionFactory.openSession();

		Query q = session.createQuery("from countryVo where status=true");

		List ls = q.list();

		session.close();

		return ls;
	}

	/*public void deleteCountry(countryVo countryVo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(countryVo);
		transaction.commit();
		session.close();
	}*/

	public List editCountry(countryVo countryVo) {

		Session session = sessionFactory.openSession();

		Query q = session.createQuery("from countryVo where countryId=" +countryVo.getCountryId());

		List ls = q.list();

		session.close();

		return ls;
	}

}
