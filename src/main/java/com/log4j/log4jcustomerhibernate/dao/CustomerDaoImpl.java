package com.log4j.log4jcustomerhibernate.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.log4j.log4jcustomerhibernate.entity.Customers;
import com.log4j.log4jcustomerhibernate.exception.CustomException;
import com.log4j.log4jcustomerhibernate.interf.CustomerService;
import com.log4j.log4jcustomerhibernate.util.HibernateUtil;

public class CustomerDaoImpl implements CustomerService {
	final static Logger logger = Logger.getLogger(CustomerDaoImpl.class);

	private Session getSession() {
		logger.warn("make sure your database credentials are perfect");
		return HibernateUtil.buildSessionFactory().openSession();
	}

	public void addCustomer(Customers customer) throws CustomException {
		logger.info("entering add customer");

		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(customer);
			logger.info("save successful");
			transaction.commit();
		} catch (Exception e) {
			logger.error("Exception occured" + e.getMessage());
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public Customers loadCustomer(int customerId) throws CustomException {
		logger.info("entering load customer");
		Session session = getSession();
		Customers customer = (Customers) session.get(Customers.class, customerId);
		logger.info("loading customer successful");
		session.close();
		return customer;
	}

	public void updateCustomer(Customers customer) throws CustomException {
		logger.info("entering update customer");
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(customer);
			logger.info("update successful");
			transaction.commit();
		} catch (Exception e) {
			logger.error("Exception occured" + e.getMessage());
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void deleteCustomer(int customerId) throws CustomException {
		logger.info("entering delete customer");
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			Customers customer = (Customers) session.get(Customers.class, customerId);
			session.delete(customer);
			logger.info("deleted customer");
			transaction.commit();
		} catch (Exception e) {
			logger.error("Exception occured" + e.getMessage());
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}

	}
}
