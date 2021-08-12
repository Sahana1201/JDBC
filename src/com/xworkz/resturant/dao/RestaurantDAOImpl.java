package com.xworkz.resturant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import com.xworkz.resturantJdbcConstant.JDBCConstant;
import com.xworkz.resturantdto.ResturantDTO;
import com.xworkz.resturantenum.ResturantType;

public class RestaurantDAOImpl implements ResturantDAO {

	@Override
	public int save(ResturantDTO dto) {
		System.out.println("saving dto in db");
		Connection tempConnection = null;
		int alid = 0;
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {

			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into restaurant_table(r_name,r_location,r_special,r_best,r_type) values" + "('"
					+ dto.getName() + "','" + dto.getLocation() + "'," + "'" + dto.getSpecialFood() + "',"
					+ dto.isBest() + ",'" + dto.getType() + "')";
			Statement statement = connection.createStatement();
			statement.execute(query, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				alid = rs.getInt(1);

			}

			connection.commit();
			dto.setId(alid);
			System.out.println(dto);

		} catch (SQLException e) {
			e.printStackTrace();

			try {
				tempConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
		return alid;

	}

	@Override
	public ResturantDTO findByName(String name) {
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {
			String query = "SELECT * FROM restaurant_table WHERE r_name = '" + name + "'";
			Statement statement = connection.createStatement();
			statement.execute(query);
			ResultSet resultSet = statement.getResultSet();
			if (resultSet.next()) {
				int id = resultSet.getInt("r_id");
				String resName = resultSet.getString("r_name");
				String location = resultSet.getString("r_location");
				String special = resultSet.getString("r_special");
				boolean best = resultSet.getBoolean("r_best");
				String type = resultSet.getString("r_type");
				System.out.println("should convert type to enum" + type);
				ResturantDTO dto = new ResturantDTO(resName, location, special, best, ResturantType.valueOf(type));
				dto.setId(id);
				return dto;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Collection<ResturantDTO> findBytype(ResturantType type) {
		Collection<ResturantDTO> collection = new ArrayList<ResturantDTO>();
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {
			String query = "SELECT * FROM restaurant_table WHERE r_type = '" + type + "'";
			Statement statement = connection.createStatement();
			statement.execute(query);
			ResultSet resultSet = statement.getResultSet();
			if (resultSet.next()) {
				int id = resultSet.getInt("r_id");
				String name = resultSet.getString("r_name");
				String location = resultSet.getString("r_location");
				String special = resultSet.getString("r_special");
				boolean best = resultSet.getBoolean("r_best");
				String resType = resultSet.getString("r_type");
				System.out.println("should convert type to enum " + type);
				ResturantDTO dto = new ResturantDTO(name, location, special, best, ResturantType.valueOf(resType));
				dto.setId(id);
				collection.add(dto);
				return collection;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public boolean updateTypeByName(ResturantType newType, String givenName) {
		System.out.println("Update type by name : ");
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {
			connection.setAutoCommit(false);
			String query = "UPDATE restaurant_table SET r_type = '" + newType + "'" + "WHERE r_name = '" + givenName
					+ "'";
			Statement statement = connection.createStatement();
			statement.execute(query);
			connection.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteByTypeByName(ResturantType oldType, String name) {

		System.out.println("DELETE type by name : ");
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {
			ResturantDTO dto1 = new ResturantDTO();
			connection.setAutoCommit(false);

			String query = "DELETE FROM restaurant_table WHERE r_type = '" + oldType + "' AND r_name = '" + name + "'";
			Statement statement = connection.createStatement();
			statement.execute(query);
			connection.commit();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
