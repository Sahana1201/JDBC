package www.com.xworkz.testers;


import java.util.Optional;

import www.com.xworkz.dao.WebSeriesDAO;
import www.com.xworkz.dao.WebSeriesDAOImpl;
import www.com.xworkz.dto.WebSeriesDTO;

public class WebSeriesFindOneByPredicate {

	public static void main(String[] args) {
		
	WebSeriesDAO dao = new WebSeriesDAOImpl();
		Optional<WebSeriesDTO> opt = dao.findone((a)->a.getW_name().equals("Friends"));
		if(opt.isPresent()) {
			WebSeriesDTO dto = opt.get();
			System.out.println(dto);


	}

}
}
