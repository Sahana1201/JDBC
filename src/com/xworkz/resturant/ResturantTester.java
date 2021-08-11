package com.xworkz.resturant;

import com.xworkz.resturant.dao.RestaurantDAOImpl;
import com.xworkz.resturant.dao.ResturantDAO;

import com.xworkz.resturantdto.ResturantDTO;
import com.xworkz.resturantenum.ResturantType;

public class ResturantTester {

	public static void main(String[] args) {
		ResturantDTO dto = new ResturantDTO("Navya bar and Resturant", "asaweshwara Nagar", "Parota", false,
				ResturantType.BAR);

		ResturantDAO dao = new RestaurantDAOImpl();
		System.out.println(dto);
		dao.save(dto);
		System.out.println(dto);
	}

}
