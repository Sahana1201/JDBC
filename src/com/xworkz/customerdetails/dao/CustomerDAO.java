package com.xworkz.customerdetails.dao;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.xworkz.customerdetails.dto.CustomerDTO;

public interface CustomerDAO {
	
	int save(CustomerDTO dto);
	void saveAll(Collection<CustomerDTO> collection);
	Optional<CustomerDTO> findone(Predicate<CustomerDTO> pridecate);
	Collection<CustomerDTO> findAll();
	Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate);
	Collection<CustomerDTO> findAllSortByNameDesc();
	int total();
	

}
