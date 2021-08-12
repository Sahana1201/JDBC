package com.xworkz.resturant;

import com.xworkz.resturant.dao.RestaurantDAOImpl;
import com.xworkz.resturant.dao.ResturantDAO;
import com.xworkz.resturantenum.ResturantType;

public class ResturantDeleteBtTypeAndName {

	public static void main(String[] args) {
		ResturantDAO dao = new RestaurantDAOImpl();
		boolean ref = false;
		ref = dao.deleteByTypeByName(ResturantType.Cafe, "CCD");
		System.out.println(ref);

	}

}
