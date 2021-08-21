package com.xworkz.flower;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Flower7 {

	public static void main(String[] args) {
		String username = "root";
		String password = "sahana@123";
		String url = "jdbc:mysql://localhost:3306/apriltransformers";
		String fqnOfDriverImpl = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(fqnOfDriverImpl);
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			String query = "insert into flowers_table values(7, 'Periwinkle', 'lightpink',100.000,false,'pooja','nosmell','Pooja purpose',10,2)";
			statement.execute(query);
			
			System.out.println(connection);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

