package com.xworkz.jdbc.scamexampleLatest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xworkz.jdbc.scamdto.ScamDTO;
import com.xworkz.jdbcconstant.JdbcConstant;

public class ScamOrderByIdDesc {
	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection(JdbcConstant.url, JdbcConstant.username,
				JdbcConstant.password)) {

			String desc = "select * from scam order by s_id DESC ";
			Statement statement = connection.createStatement();
			statement.execute(desc);
			ResultSet resultset = statement.getResultSet();
			ScamDTO dto = null;
			List<ScamDTO> user = new ArrayList<ScamDTO>();

			while (resultset.next()) {
				ScamDTO users = new ScamDTO();

				users.setS_id(resultset.getInt("s_id"));

				String names = resultset.getString("s_name");
				int id = resultset.getInt("s_id");
				String type = resultset.getString("s_type");
				Date year = resultset.getDate("s_year");
				String by = resultset.getString("s_by");
				int amount = resultset.getInt("s_amount");
				String location = resultset.getString("s_location");

				System.out.println(names);

				dto = new ScamDTO(names, id, type, year, by, amount, location);
				System.out.println(dto);
				user.add(users);
			}

			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
