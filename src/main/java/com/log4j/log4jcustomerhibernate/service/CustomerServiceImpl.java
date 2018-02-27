package com.log4j.log4jcustomerhibernate.service;

import com.log4j.log4jcustomerhibernate.dao.CustomerDaoImpl;
import com.log4j.log4jcustomerhibernate.entity.Customers;
import com.log4j.log4jcustomerhibernate.exception.CustomException;
import com.log4j.log4jcustomerhibernate.interf.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	CustomerDaoImpl cdao = new CustomerDaoImpl();

	public void addCustomer(Customers customer) throws CustomException {
		cdao.addCustomer(customer);

	}

	public Customers loadCustomer(int customerId) throws CustomException {
		return cdao.loadCustomer(customerId);

	}

	public void updateCustomer(Customers customer) throws CustomException {
		cdao.updateCustomer(customer);

	}

	public void deleteCustomer(int customerId) throws CustomException {
		cdao.deleteCustomer(customerId);
	}
}
