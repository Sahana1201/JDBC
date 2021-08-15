package www.com.xworkz.testers;

import java.util.Collection;

import www.com.xworkz.dao.WebSeriesDAO;
import www.com.xworkz.dao.WebSeriesDAOImpl;
import www.com.xworkz.dto.WebSeriesDTO;

public class WebSeriesFindAllByPredicate {

	public static void main(String[] args) {

		WebSeriesDAO dao = new WebSeriesDAOImpl();
		Collection<WebSeriesDTO> collection = dao.findall(m -> m.getW_noOfEpisodes() > 20);
		collection.forEach(k -> System.out.println(k));

	}

}
