package com.xworkz.resturantdto;

import java.io.Serializable;

import com.xworkz.resturantenum.ResturantType;

public class ResturantDTO implements Serializable {

	private String name;
	private String location;
	private String specialFood;
	private boolean best;
	private ResturantType type;

	public ResturantDTO(String name, String location, String specialFood, boolean best, ResturantType type) {
		super();
		this.name = name;
		this.location = location;
		this.specialFood = specialFood;
		this.best = best;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSpecialFood() {
		return specialFood;
	}

	public void setSpecialFood(String specialFood) {
		this.specialFood = specialFood;
	}

	public boolean isBest() {
		return best;
	}

	public void setBest(boolean best) {
		this.best = best;
	}

	public ResturantType getType() {
		return type;
	}

	public void setType(ResturantType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (best ? 1231 : 1237);
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((specialFood == null) ? 0 : specialFood.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResturantDTO other = (ResturantDTO) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;

		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResturantDTO [name=" + name + ", location=" + location + ", specialFood=" + specialFood + ", best="
				+ best + ", type=" + type + "]";
	}
	
}
