package com.xworkz.customerdetails.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.xworkz.customerdetails.dao.CustomerDAO;
import com.xworkz.customerdetails.dao.CustomerDAOImpl;
import com.xworkz.customerdetails.dto.CustomerDTO;
import com.xworkz.customerdetails.eduenum.EducationEnum;
import com.xworkz.customerdetails.jdbcConstant.JDBCConstant;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDAO dao = new CustomerDAOImpl();

	@Override
	public int validateAndSave(CustomerDTO dto) {

		int validation = 0;
		if (dto != null) {
			String name = dto.getName();
			if (name != null && !name.isEmpty() && name.length() > 3 && name.length() <= 20)
				System.out.println("name valid");
			validation++;
			String education = dto.getEducation().toString();
			if (education != null && !education.isEmpty())
				System.out.println("education valid");
			validation++;
			int passportNo = dto.getPassportNo();
			if (passportNo != 0)
				System.out.println("passport no valid");
			validation++;
			String from = dto.getFrom();
			if (from != null && !from.isEmpty())
				System.out.println("from valid");
			validation++;
			String to = dto.getTo();
			if (to != null && !to.isEmpty())
				System.out.println("to valid");
			validation++;
			if (validation == 5)
				validation = dao.save(dto);
		}
		return validation;
	}

	@Override
	public void ValidateAndSaveAll(Collection<CustomerDTO> collection) {
		List<CustomerDTO> list = new ArrayList<CustomerDTO>();
		
		collection.forEach(dto -> {
			int validation = 0;
			if (dto != null) {
				String name = dto.getName();
				if (name != null && !name.isEmpty() && name.length() > 3 && name.length() <= 20)
					validation++;
				String education = dto.getEducation().toString();
				if (education != null && !education.isEmpty())
					validation++;
				int passportNo = dto.getPassportNo();
				if (passportNo != 0)
					validation++;
				String from = dto.getFrom();
				if (from != null && !from.isEmpty())
					validation++;
				String to = dto.getTo();
				if (to != null && !to.isEmpty())
					validation++;
				if (validation == 5)
					list.add(dto);

			}
			if (list.containsAll(collection)) {
				dao.saveAll(collection);
			}

		});
	}

	@Override
	public Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate) {
		return dao.findone(predicate);
	}

	@Override
	public Collection<CustomerDTO> findAll() {

		return dao.findAll();
	}

	@Override
	public Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate) {

		return dao.findAll(predicate);
	}

	@Override
	public int total() {
		return dao.total();
	}

	@Override
	public Collection<CustomerDTO> findAllSortByNameDesc() {

		return dao.findAllSortByNameDesc();
	}

}
