package com.log4j.log4jcustomerhibernate.app;

import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.log4j.log4jcustomerhibernate.entity.*;
import com.log4j.log4jcustomerhibernate.exception.CustomException;
import com.log4j.log4jcustomerhibernate.interf.CustomerService;
import com.log4j.log4jcustomerhibernate.service.CustomerServiceImpl;

public class CustomerApplication {

	public static void main(String[] args) throws CustomException {
		String log4jConfPath = "C:\\Users\\DINESH\\eclipse-workspace\\customerlibrary\\src\\main\\java\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);

		try {
			while (true) {
				System.out.println("Select from the menu \n");
				System.out.println("1. Add a Customer");
				System.out.println("2. Delete a Customer");
				System.out.println("3. Update Customer");
				System.out.println("4. Display Customer");
				System.out.println("5. Exit");
				System.out.println("Please provide your choice \n");
				Scanner sc = new Scanner(System.in);
				int option = sc.nextInt();
				CustomerApplication capp = new CustomerApplication();
				switch (option) {
				case 1:
					capp.addCustomer(sc);
					break;
				case 2:
					capp.deleteCustomer(sc);
					break;
				case 3:
					capp.updateCustomer(sc);
					break;
				case 4:
					capp.displayCustomer(sc);
					break;
				case 5:
					System.exit(0);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void addCustomer(Scanner sc) throws Exception {
		Customers customer = customerDetails(sc);
		try {
			CustomerService simp = new CustomerServiceImpl();
			simp.addCustomer(customer);
			System.out.println("Customer with Name : " + customer.getFirstName() + " added to the DB");
		} catch (CustomException e) {
			System.out.println("Exception occured: " + e.getMessage());
		}
	}

	private void deleteCustomer(Scanner sc) throws Exception {
		System.out.println("Enter Customer ID : ");
		int customerId = sc.nextInt();
		try {
			CustomerService simp = new CustomerServiceImpl();
			simp.deleteCustomer(customerId);
			System.out.println("Customer with id " + customerId + " is deleted");
		} catch (CustomException e) {
			System.out.println("Exception occured: " + e.getMessage());
		}
	}

	private void updateCustomer(Scanner sc) throws Exception {
		System.out.println("Enter Customer ID : ");
		int customerId = sc.nextInt();
		Customers customer = customerDetails(sc);
		customer.setCustomerId(customerId);
		try {
			CustomerService simp = new CustomerServiceImpl();
			simp.updateCustomer(customer);
			System.out.println("Customer with id " + customerId + " is updated");
		} catch (CustomException e) {
			System.out.println("Exception occured: " + e.getMessage());
		}
	}

	private void displayCustomer(Scanner sc) {
		System.out.println("Enter Customer ID : ");
		int customerId = sc.nextInt();
		try {
			CustomerService simp = new CustomerServiceImpl();
			Customers customer = (Customers) simp.loadCustomer(customerId);
			System.out.println(customer);
		} catch (CustomException e) {
			e.printStackTrace();
		}
	}

	private Customers customerDetails(Scanner sc) {
		System.out.println("Enter Customer Title : ");
		String title = sc.next();
		System.out.println("Enter Customer First Name : ");
		String firstName = sc.next();
		System.out.println("Enter Customer Middle Name : ");
		String middleName = sc.next();
		System.out.println("Enter Customer Last Name : ");
		String lastName = sc.next();
		System.out.println("Enter Customer Suffix : ");
		String suffix = sc.next();
		System.out.println("Enter Customer Email : ");
		String email = sc.next();
		System.out.println("Enter Customer Company : ");
		String company = sc.next();
		System.out.println("Enter Display Name : ");
		String displayName = sc.next();
		System.out.println("Print On Check As : ");
		String printOnCheckAs = sc.next();
		System.out.println("Enter Customer Billing Street : ");
		String billingStreet = sc.next();
		System.out.println("Enter Customer Billing  City : ");
		String billingCity = sc.next();
		System.out.println("Enter Customer Billing State : ");
		String billingState = sc.next();
		System.out.println("Enter Customer Billing  Zip : ");
		String billingZip = sc.next();
		System.out.println("Enter Customer Billing  Country : ");
		String billingCountry = sc.next();
		System.out.println("Enter Customer Shipping Street : ");
		String shippingStreet = sc.next();
		System.out.println("Enter Customer Shipping City : ");
		String shippingCity = sc.next();
		System.out.println("Enter Customer shipping State : ");
		String shippingState = sc.next();
		System.out.println("Enter Customer shipping  Zip : ");
		String shippingZip = sc.next();
		System.out.println("Enter Customer shipping  Country : ");
		String shippingCountry = sc.next();
		System.out.println("Enter Other Details : ");
		String otherDetails = sc.next();
		return new Customers(title, firstName, middleName, lastName, suffix, email, company, displayName,
				printOnCheckAs, billingStreet, billingCity, billingState, billingZip, billingCountry, shippingStreet,
				shippingCity, shippingState, shippingZip, shippingCountry, otherDetails);
	}
}
