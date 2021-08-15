package www.com.xworkz.testers;

import java.util.ArrayList;
import java.util.Collection;

import www.com.xworkz.dao.WebSeriesDAO;
import www.com.xworkz.dao.WebSeriesDAOImpl;
import www.com.xworkz.dto.WebSeriesDTO;
import www.com.xworkz.webenum.Genertype;
import www.com.xworkz.webenum.StreamedInType;

public class WebSeriesInsertTester {

	public static void main(String[] args) {

		WebSeriesDTO dto = new WebSeriesDTO("Family man", 10, StreamedInType.AMAZON, Genertype.FAMILY, 18);
		WebSeriesDTO dto1 = new WebSeriesDTO("Vampire Diaries", 22, StreamedInType.AMAZON, Genertype.HOROR, 16);
		WebSeriesDTO dto2 = new WebSeriesDTO("The walking dead", 11, StreamedInType.NETFLIX, Genertype.HOROR, 18);
		WebSeriesDTO dto3 = new WebSeriesDTO("Friends", 20, StreamedInType.NETFLIX, Genertype.FAMILY, 16);

		WebSeriesDAO dao = new WebSeriesDAOImpl();
		dao.save(dto1);
		dao.save(dto2);
		dao.save(dto3);
		dao.save(dto);
	}

}
