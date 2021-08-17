package com.xworkz.customerdetails;

import com.xworkz.customerdetails.dao.CustomerDAO;
import com.xworkz.customerdetails.dao.CustomerDAOImpl;
import com.xworkz.customerdetails.service.CustomerService;
import com.xworkz.customerdetails.service.CustomerServiceImpl;

public class CustomerFindAllTester {

	public static void main(String[] args) {

		CustomerDAO dao = new CustomerDAOImpl();
		CustomerService service = new CustomerServiceImpl();
		service.findAll();
		System.out.println(dao.findAll());

	}

}
