package com.xworkz.resturant.dao;

import java.util.Collection;

import com.xworkz.resturantdto.ResturantDTO;
import com.xworkz.resturantenum.ResturantType;

public interface ResturantDAO {

	int save(ResturantDTO dto);

	ResturantDTO findByName(String name);

	Collection<ResturantDTO> findBytype(ResturantType type);

	default boolean updateTypeByName(ResturantType newType, String name) {
		return false;
	}

	default boolean deleteByTypeByName(ResturantType oldType, String name) {
		return false;
	}

}
