package com.xworkz.customerdetails;

import java.util.Collection;
import java.util.Optional;

import com.xworkz.customerdetails.dao.CustomerDAO;
import com.xworkz.customerdetails.dao.CustomerDAOImpl;
import com.xworkz.customerdetails.dto.CustomerDTO;

public class CustomerFindAllByPredicateTester {

	public static void main(String[] args) {

		CustomerDAO dao = new CustomerDAOImpl();
		Collection<CustomerDTO> col = dao.findAll(n -> n.getName().equals("Sahana"));
		col.forEach(k -> System.out.println(k));

	}

}
