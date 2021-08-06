package com.xworkz.jbdc.scamexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ScamUpdateYearAmountLocationTypebyNameId {

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
			String update = "update scam set s_year = '2018-06-22',s_amount = 14000 , s_location ='Banglore'  where(s_name ='TRP scam' and s_id=5)";
			statement.execute(update);

			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
