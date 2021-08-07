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
		//	String scam4 = "insert into scam values(4,'KeralaGoldSmuggling','GoldSmuggling','2020-6-22','Kerala govt',10000,'Kerala','Customer official at airport carring baggage from dubai')";
		//	String scam5 = "insert into scam values(5,'TRP scam','TRP','2020-11-10','national tv',10000,'Mumbai','Files Charge sheet against National Republic tv')";
			//String scam6 = "insert into scam values(6,'Roshini land Scam','Land scam','2020-11-4','Roshini',25000,'JammuKashmir','Accuried land givrn to homless of J&K')";
		//	String scam7 = "insert into scam values(7,'Amarapali Adya scam','Trading Scam','2019=8-2','Amrapali',200000,'India','It fraud investors by using their shares')";
		//	String scam8 = "insert into scam values(8,'SandalWoodDrugScam','Drug scam','2019-9-5','KannadaCinemaIndustry',100000,'Karnata','Kannada Film indystry is segment dedicated to the production')";
		//	String scam9 = "Insert into scam values(9,'PNB scam','Abdcanded Scam','2016-8-12','VijayMalya',900000,'Banglore','Anscond by taking loan')";
		//	String scam10  = "insert into scam values(10,'KLA','corporatefrauds','2009-12-2' ,' Vijay Mallya',9000,'banglore','The company resorted to borrowing funds by all possible means, including related parties and pledge of Kingfisher brand by over-valuation of brand value. Good times did not last long, and Vijay Malia had to')";
		//	String scam11 = "insert into scam values(11,'Jet Airways','misappropriation',' 2010-8-5','jetairwayscompany',25000000,'mumbai','Jet had acquired an unassailable position in the industry and was a preferred airline for the business community, top industrialists and CEOs of the country. Its service standards were its USP') ";
		//	String scam12 = "insert into scam values(12,'PNB','banking fraud','2018-9-25','Niravmodi',15000000,'ahmedabad','PNB was the first major banking fraud reported in the country, involving a massive amount of around Rs. 15000 crores. Fraud was committed by Nirav Modi and Mehul Choksi, (through Gitanjali Gems, a listed company owned by him)') ";
		//	String scam13 = "insert into scam values(13,'ILFS','corporate fraud','2017-10-2','IL&FS',91000000,'banglore','ILFS fraud was the largest corporate fraud in India and triggered a showdown in the economy, as the company was a key vehicle for infrastructure development of the country') ";
		//	String scam14= "insert into scam values(14,'PMCBank','perpetuatedfraud','2011-2-5','PravinRaut',7000000,'banglore','Around 70 percent of its total loan book of Rs 8,383 crore as on March 31, 2019, had been taken by real estate firm HDIL.') ";
		//	String scam15="insert into scam values(15,'Coalgate Scam','political scandal','2012-11-20','CAG',1000000,'India','This was one of the scams that shook the whole nation from its core as many bureaucrats and politicians were involved in this. Although the CAG initially estimated the loss of over Rs 10 lakh crore')";
		//	String scam16="insert into scam values(16,'2G Spectrum scam','telephone','2012-12-05','CAG',176000,'India',' 2G spectrum subscriptions, and at the centre of this controversy was the former Telecom minister')";
		//	String scam17="insert into scam values(17,'Commonwealthscam','GameScam','2010-12-5','Suresh Kalmadi',70000,'India',' The whole event was marred with accusations of criminal conspiracy, cheating and forgery and the chairman of Common Wealth Games 2010 Suresh Kalmadi was accused of corruption and malpractices')";
		//	String scam18 = "insert into scam values(18,'PNB scam','Bank','2016-12-2','Vijay Mallya',9000,'Karnataka','rs 9000cr which he had taken as a loan to keep his now defunct Kingfisher airlines from failing.')";
			String scam19="insert into scam values(19,'BOFORSscanda','weapons-contract','1986-2-15','Swedish',640000,'India','weapons-contract scandal that took place between India and Sweden during the 1980s and 90s.')";
			String scam20="insert into scam values(20,'AgustaWestland','chopper scam','2010-12-1','UPA', 3600,'India','this case is about a 2010 deal signed between the UPA government and AgustaWestland for acquisition of 12 helicopters that were supposed to be used by the President of India')";
		//	statement.execute(scam9);
		//	statement.execute(scam8);
		//	statement.execute(scam7);
		//	statement.execute(scam6);
		//	statement.execute(scam5);
		//	statement.execute(scam4);
			// statement.execute(scam);
			// statement.execute(scam1);
			// statement.execute(scam2);
			// statement.execute(scam3);
		//	statement.execute(scam10);
		//	statement.execute(scam11);
		//	statement.execute(scam12);
		//	statement.execute(scam13);
		//	statement.execute(scam14);
		//	statement.execute(scam15);
		//	statement.execute(scam16);
		//	statement.execute(scam17);
		//	statement.execute(scam18);
			statement.execute(scam19);
			statement.execute(scam20);
			
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
