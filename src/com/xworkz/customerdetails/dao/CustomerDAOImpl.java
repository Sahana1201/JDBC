package com.xworkz.customerdetails.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.xworkz.customerdetails.dto.CustomerDTO;
import com.xworkz.customerdetails.eduenum.EducationEnum;
import com.xworkz.customerdetails.jdbcConstant.JDBCConstant;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public int save(CustomerDTO dto) {
		System.out.println("DTO is Saving in DataBase");
		int aid = 0;
		Connection tempCon = null;
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {
			tempCon = connection;
			connection.setAutoCommit(false);
			String query = "insert into customerdetails(c_name,c_from,c_to,c_resiadress,c_married,c_passportNo,c_education) values (?,?,?,?,?,?,?)";
			PreparedStatement stm = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stm.setString(1, dto.getName());
			stm.setString(2, dto.getFrom());
			stm.setString(3, dto.getTo());
			stm.setString(4, dto.getResiAdress());
			stm.setBoolean(5, dto.isMarried());
			stm.setInt(6, dto.getPassportNo());
			stm.setString(7, dto.getEducation().toString());
			stm.execute();
			ResultSet resultSet = stm.getGeneratedKeys();
			if (resultSet.next()) {
				aid = resultSet.getInt(1);
			}

			dto.setId(aid);

			connection.commit();
			System.out.println(dto);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				tempCon.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();

			}
		}
		return aid;
	}

	@Override
	public void saveAll(Collection<CustomerDTO> collection) {
		collection.stream().forEach(dto -> save(dto));
	}

	@Override
	public Optional<CustomerDTO> findone(Predicate<CustomerDTO> pridecate) {
		System.out.println("Find one from table using predicate");

		Optional<CustomerDTO> optional = Optional.empty();
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {
			String query = "select * from customerdetails";
			PreparedStatement stm = connection.prepareStatement(query);
			ResultSet resultSet = stm.executeQuery();
			while (resultSet.next()) {

				String name = resultSet.getString("c_name");
				String from = resultSet.getString("c_from");
				String to = resultSet.getString("c_to");
				boolean married = resultSet.getBoolean("c_married");
				String resiadress = resultSet.getString("c_resiAdress");
				int passportNo = resultSet.getInt("c_passportNo");
				String education = resultSet.getString("c_education");
				CustomerDTO dto = new CustomerDTO(name, from, to, resiadress, married, passportNo,
						EducationEnum.valueOf(education));
				if (pridecate.test(dto)) {
					optional = Optional.of(dto);
					break;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return optional;
	}

	@Override
	public Collection<CustomerDTO> findAll() {
		System.out.println("Find all data's from table");
		Collection<CustomerDTO> collection = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {
			String query = "select * from customerdetails";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int id = resultSet.getInt("c_id");
				String name = resultSet.getString("c_name");
				String from = resultSet.getString("c_from");
				String to = resultSet.getString("c_to");
				boolean married = resultSet.getBoolean("c_married");
				String resiadress = resultSet.getString("c_resiAdress");
				int passportNo = resultSet.getInt("c_passportNo");
				String education = resultSet.getString("c_education");
				CustomerDTO dto = new CustomerDTO(name,from, to, resiadress, married, passportNo,
						EducationEnum.valueOf(education));
				dto.setId(id);

				collection.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate) {

		System.out.println("Find All from table using predicate");
		int aid = 0;
		Collection<CustomerDTO> optional = new ArrayList<CustomerDTO>();
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {
			String query = "select * from customerdetails";
			PreparedStatement stm = connection.prepareStatement(query);
			ResultSet resultSet = stm.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("c_name");
				String from = resultSet.getString("c_from");
				String to = resultSet.getString("c_to");
				boolean married = resultSet.getBoolean("c_married");
				String resiadress = resultSet.getString("c_resiAdress");
				int passportNo = resultSet.getInt("c_passportNo");
				String education = resultSet.getString("c_education");
				CustomerDTO dto = new CustomerDTO(name, from, to, resiadress, married, passportNo,
						EducationEnum.valueOf(education));
				if (predicate.test(dto)) {
					optional.add(dto);

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return optional;
	}

	@Override
	public Collection<CustomerDTO> findAllSortByNameDesc() {
		System.out.println("Find all data's from table name in decending order");
		Collection<CustomerDTO> collection = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {
			String query = "select * from customerdetails order by c_name desc";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int id = resultSet.getInt("c_id");
				String name = resultSet.getString("c_name");
				String from = resultSet.getString("c_from");
				String to = resultSet.getString("c_to");
				boolean married = resultSet.getBoolean("c_married");
				String resiadress = resultSet.getString("c_resiAdress");
				int passportNo = resultSet.getInt("c_passportNo");
				String education = resultSet.getString("c_education");
				CustomerDTO dto = new CustomerDTO(name, from, to, resiadress, married, passportNo,
						EducationEnum.valueOf(education));
				dto.setId(id);

				collection.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;

	}

	@Override
	public int total() {

		int value = 0;
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {

			String count = "select * from customerdetails";

			Statement statement = connection.createStatement();
			statement.execute(count);
			ResultSet resultset = statement.getResultSet();
			int counts = 1;

			while (resultset.next()) {
				value = counts++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return value;
	}

}
