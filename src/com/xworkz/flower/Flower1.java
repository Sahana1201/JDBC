package com.xworkz.flower;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Flower1 {

	public static void main(String[] args) {
		String username = "root";
		String password = "sahana@123";
		String url = "jdbc:mysql://localhost:3306/apriltransformers";
		String fqnOfDriverImpl = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(fqnOfDriverImpl);
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			String query = "insert into flowers_table values(1, 'Lily', 'White',40.000,false,'temple','Lily','Domestic flower',16,2)";
			statement.execute(query);
			
			System.out.println(connection);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	}


