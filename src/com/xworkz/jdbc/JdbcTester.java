package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTester {

	public static void main(String[] args) {
		String username = "root";
		String password = "sahana@123";
		String url = "jdbc:mysql://localhost:3306/apriltransformers";
		String fqnOfDriverImpl = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(fqnOfDriverImpl);
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			String query = "insert into insurance_table values(2,'sahana','jewellery',2,'IFCO',45212)";
			statement.execute(query);
			String query1 = "insert into insurance_table values(3,'Teju','Health Insurance',5,'IFCO',45225)";
			statement.execute(query1);
			String query2 = "insert into insurance_table values(4,'Anusha','Health Insurance',3,'LIC',45252)";
			statement.execute(query2);
			System.out.println(connection);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
