package com.xworkz.resturant;

import com.xworkz.resturant.dao.RestaurantDAOImpl;
import com.xworkz.resturant.dao.ResturantDAO;
import com.xworkz.resturantdto.ResturantDTO;

public class ResturantFindByNameTester {

	public static void main(String[] args) {
		ResturantDAO dao = new RestaurantDAOImpl();
		ResturantDTO dto = dao.findByName("Hut");
		System.out.println(dto);

	}

}
