package com.xworkz.customerdetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.xworkz.customerdetails.dto.CustomerDTO;
import com.xworkz.customerdetails.eduenum.EducationEnum;
import com.xworkz.customerdetails.service.CustomerService;
import com.xworkz.customerdetails.service.CustomerServiceImpl;

public class CustomerInsertTester {

	public static void main(String[] args) {

		CustomerDTO cust = new CustomerDTO("Sahana", "Tumkur", "Banglore", "vani vilas nilaya tumkur", false,
				1245789635, EducationEnum.BE);
		CustomerDTO cust1 = new CustomerDTO("Teju", "Dahrwad", "Tumkur", "Dharwad near Vidya Nagar", false, 1245789625,
				EducationEnum.BE);
		CustomerDTO cust2 = new CustomerDTO("Anusha", "Banglore", "AndhraPradesh", "Anusha nilaya near Charminar",
				false, 1245878545, EducationEnum.MBA);
		CustomerDTO cust3 = new CustomerDTO("Harsha", "banglore", "Hydrebad", "Hydrebad near KVR Botanical Garden",
				false, 1245789354, EducationEnum.Mtech);

		CustomerService service = new CustomerServiceImpl();

		Collection<CustomerDTO> col = Arrays.asList(cust, cust1, cust3, cust2);
		service.validateAndSave(cust3);
		service.validateAndSave(cust2);
		service.validateAndSave(cust1);
		service.validateAndSave(cust);
		col.forEach(s -> System.out.println(s));

	}

}
