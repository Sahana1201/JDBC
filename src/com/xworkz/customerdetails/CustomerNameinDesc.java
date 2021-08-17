package com.xworkz.customerdetails;

import com.xworkz.customerdetails.dao.CustomerDAO;
import com.xworkz.customerdetails.dao.CustomerDAOImpl;

public class CustomerNameinDesc {

	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAOImpl();
		System.out.println(dao.findAllSortByNameDesc());
	}

}
