package com.xworkz.jbdc.scamexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ScamInsertTester {

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
			// String scam = "insert into scam values(1,'Karvy Scam','Stock
			// Broking','2020-11-22',' Karvy',2000,'Hydrebad','On November 22, the SEBI
			// passed an ex parte ad interim order against Karvy Stock Broking')";

			// String scam1 = "insert into scam values(2,'PNB Scam','jeweller and
			// designer','1969-7-19','PNB',11356.84,'Mumbai','The PNB Fraud Case relates to
			// fraudulent letter of undertaking worth 11,356.84 crore')";
			// String scam2 = "insert into scam values(3,'DHFL Scam','Fake account
			// lending','2018-6-22','DHFL',14000,'Banglore',' DHFL Directors Conned Over Rs
			// 14,000 Crore in 2 Lakh Fake Loan Accounts Under PM Housing Fund')";
			// String scam3 = "insert into scam
			// values(3,'Reruitmentscam','Reciting','2021-2-28','VK
			// Purohit',2000,'Delhi','Input received about the alleged involment of serving
			// personnel in accepting bribes')";
			String scam4 = "insert into scam values(4,'KeralaGoldSmuggling','GoldSmuggling','2020-6-22','Kerala govt',10000,'Kerala','Customer official at airport carring baggage from dubai')";
			String scam5 = "insert into scam values(5,'TRP scam','TRP','2020-11-10','national tv',10000,'Mumbai','Files Charge sheet against National Republic tv')";
			String scam6 = "insert into scam values(6,'Roshini land Scam','Land scam','2020-11-4','Roshini',25000,'JammuKashmir','Accuried land givrn to homless of J&K')";
			String scam7 = "insert into scam values(7,'Amarapali Adya scam','Trading Scam','2019=8-2','Amrapali',200000,'India','It fraud investors by using their shares')";
			String scam8 = "insert into scam values(8,'SandalWoodDrugScam','Drug scam','2019-9-5','KannadaCinemaIndustry',100000,'Karnata','Kannada Film indystry is segment dedicated to the production')";
			String scam9 = "Insert into scam values(9,'PNB scam','Abdcanded Scam','2016-8-12','VijayMalya',900000,'Banglore','Anscond by taking loan')";

			statement.execute(scam9);
			statement.execute(scam8);
			statement.execute(scam7);
			statement.execute(scam6);
			statement.execute(scam5);
			statement.execute(scam4);
			// statement.execute(scam);
			// statement.execute(scam1);
			// statement.execute(scam2);
			// statement.execute(scam3);
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
