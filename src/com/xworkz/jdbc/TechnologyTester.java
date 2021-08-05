package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TechnologyTester {

	public static void main(String[] args) {
		String username = "root";
		String password = "sahana@123";
		String url = "jdbc:mysql://localhost:3306/apriltransformers";
		String fqnOfDriverImpl = "com.mysql.cj.jdbc.Driver";

		Connection connection = null;

		try {
			Class.forName(fqnOfDriverImpl);
			connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			String query = "insert into technologies values('Java',1,'JavaDeveloper','1996-01-23','James Gosling')";
			String query1 = "insert into technologies values('Artificial Intelligence',2,'big Date Engineer','1956-01-23','Herbert Simon & Allen Newell')";
			String query2 = "insert into technologies values('IOT',3,'Aplication Architect','2015-01-20','Kevin Aston')";
			String query3 = "insert into technologies values('Robotics',4,'Robotics Engineer','1954-05-23','George Devol')";

			statement.execute(query);
			statement.execute(query1);

			statement.execute(query3);
			statement.execute(query2);
			System.out.println(connection);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
