package com.xworkz.resturant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.xworkz.resturantJdbcConstant.JDBCConstant;
import com.xworkz.resturantdto.ResturantDTO;

public class RestaurantDAOImpl implements ResturantDAO {

	String username = "root";
	String password = "sahana@123";
	String url = "jdbc:mysql://localhost:3306/apriltransformers";
	String fqnOfDriverImpl = "com.mysql.cj.jdbc.Driver";

	@Override
	public int save(ResturantDTO dto) {
		System.out.println("saving dto in db" + dto);
		Connection tempConnection = null;
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			Class.forName(fqnOfDriverImpl);
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into restaurant_table values(5,'" + dto.getName() + "','" + dto.getLocation() + "',"
					+ "'" + dto.getSpecialFood() + "'," + dto.isBest() + ",'" + dto.getType() + "')";
			Statement statement = connection.createStatement();
			statement.execute(query);
			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();

			try {
				tempConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return 0;

	}

}