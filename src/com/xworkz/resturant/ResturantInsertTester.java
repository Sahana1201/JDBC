package com.xworkz.resturant;

import com.xworkz.resturant.dao.RestaurantDAOImpl;
import com.xworkz.resturant.dao.ResturantDAO;

import com.xworkz.resturantdto.ResturantDTO;
import com.xworkz.resturantenum.ResturantType;

public class ResturantInsertTester {

	public static void main(String[] args) {
		ResturantDTO dto = new ResturantDTO("Navya bar and Resturant", "asaweshwara Nagar", "Parota", false,
				ResturantType.BAR);
		ResturantDTO dto1 = new ResturantDTO("Prithvi", "Ashok Nagar", "Gobi Mancuri", false, ResturantType.FAMILY);
		ResturantDTO dto2 = new ResturantDTO("Hoysala", "BH Road", "FriedRice", false, ResturantType.FAMILY);
		ResturantDTO dto3 = new ResturantDTO("Hut", "MG Road", "Parota", false, ResturantType.FAMILY);
		ResturantDTO dto4 = new ResturantDTO("A2B", "RT nagar", "sweets", true, ResturantType.FAMILY);
		ResturantDTO dto5 = new ResturantDTO("Saravana Bhavan", "RT nagar", "mini sambar idly", true,
				ResturantType.FAMILY);
		ResturantDTO dto6 = new ResturantDTO("Andhra Gunpowder", "RT nagar", "Andhra veg meals", true,
				ResturantType.FAMILY);
		ResturantDTO dto7 = new ResturantDTO("JetLag", "Soap Factory", "Potato fries", false, ResturantType.BAR);
		ResturantDTO dto8 = new ResturantDTO("CCD", "Koramangala", "Capaccino", false, ResturantType.Cafe);
		ResturantDAO dao = new RestaurantDAOImpl();

		dao.save(dto);
		dao.save(dto1);
		dao.save(dto2);
		dao.save(dto3);
		dao.save(dto4);
		dao.save(dto5);
		dao.save(dto6);
		dao.save(dto7);
		dao.save(dto8);
		
		
	}

}
