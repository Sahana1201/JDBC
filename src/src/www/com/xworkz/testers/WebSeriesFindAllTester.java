package www.com.xworkz.testers;

import www.com.xworkz.dao.WebSeriesDAO;
import www.com.xworkz.dao.WebSeriesDAOImpl;

public class WebSeriesFindAllTester {

	public static void main(String[] args) {
		WebSeriesDAO dao = new WebSeriesDAOImpl();
		System.out.println(dao.findall());

	}

}
