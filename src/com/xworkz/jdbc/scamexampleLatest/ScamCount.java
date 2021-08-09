package com.xworkz.jdbc.scamexampleLatest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.jdbcconstant.JdbcConstant;

public class ScamCount {
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(JdbcConstant.url, JdbcConstant.username,
				JdbcConstant.password)) {

			String count = "select * from scam";
			Statement statement = connection.createStatement();
			statement.execute(count);
			ResultSet resultset = statement.getResultSet();
			int counts = 0;

			while (resultset.next()) {
				counts++;

			}
			System.out.println(counts);
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
}
