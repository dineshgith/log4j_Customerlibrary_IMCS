package com.log4j.log4jcustomerhibernate.interf;

import com.log4j.log4jcustomerhibernate.entity.Customers;
import com.log4j.log4jcustomerhibernate.exception.CustomException;

public interface CustomerDao {
	public void addCustomer(Customers customer) throws CustomException;

	public Customers loadCustomer(int customerId) throws CustomException;

	public void updateCustomer(Customers customer) throws CustomException;

	public void deleteCustomer(int customerId) throws CustomException;
}
