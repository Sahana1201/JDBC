package com.xworkz.customerdetails;

import java.util.Optional;

import com.xworkz.customerdetails.dao.CustomerDAO;
import com.xworkz.customerdetails.dao.CustomerDAOImpl;
import com.xworkz.customerdetails.dto.CustomerDTO;
import com.xworkz.customerdetails.service.CustomerService;
import com.xworkz.customerdetails.service.CustomerServiceImpl;

public class CustomerFindOneByPredicateTester {

	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAOImpl();

		Optional<CustomerDTO> opt = dao.findone((a) -> a.getName().equals("Sahana"));
		if (opt.isPresent()) {
			CustomerDTO dto = opt.get();
			System.out.println(dto);
		}
	}
}
