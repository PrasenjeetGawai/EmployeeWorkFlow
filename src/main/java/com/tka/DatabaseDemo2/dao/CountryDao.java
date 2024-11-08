package com.tka.DatabaseDemo2.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.DatabaseDemo2.entity.Country;

@Repository
public class CountryDao {

	@Autowired
	SessionFactory factory;

	public String addRecord(Country country) {
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(country);
			tx.commit();
			msg = "Country Added Successfully...";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;

	}

	public String updataRecord(Country country, int c_id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();
			Country c1 = session.get(Country.class, c_id);
			c1.setC_name(country.getC_name());
			session.merge(c1);
			tx.commit();
			msg = "Country Updated Successfully...";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public String deleteRecord(int c_id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();
			Country c1 = session.get(Country.class, c_id);
			session.remove(c1);
			tx.commit();
			msg = "Country Deleted Successfully...";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public List<Country> getAllData() {
		Session session = null;
		Transaction tx = null;
		List<Country> list=null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from Country";
			
			Query<Country> query = session.createQuery(hqlQuery, Country.class);
			list = query.list();
			tx.commit();
			

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public Country getParticular(int c_id) {
		Session session = null;
		Transaction tx = null;
		Country country=null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();
			country= session.get(Country.class, c_id);
			tx.commit();
			

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return country;
	}

}
