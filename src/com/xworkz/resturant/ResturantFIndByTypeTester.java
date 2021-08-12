package com.xworkz.resturant;

import java.util.Collection;

import com.xworkz.resturant.dao.RestaurantDAOImpl;
import com.xworkz.resturant.dao.ResturantDAO;
import com.xworkz.resturantdto.ResturantDTO;
import com.xworkz.resturantenum.ResturantType;

public class ResturantFIndByTypeTester {

	public static void main(String[] args) {

		ResturantDAO dao = new RestaurantDAOImpl();
		Collection<ResturantDTO> collection = dao.findBytype(ResturantType.FAMILY);
		collection.forEach(dto -> System.out.println(dto));
	}

}
