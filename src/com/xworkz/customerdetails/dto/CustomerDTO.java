package com.xworkz.customerdetails.dto;

import java.io.Serializable;

import com.xworkz.customerdetails.eduenum.EducationEnum;

public class CustomerDTO implements Serializable {

	private int id;
	private String name;
	private String from;
	private String to;
	private String resiAdress;
	private boolean married;
	private int passportNo;
	private EducationEnum education;

	

	public CustomerDTO() {
		super();
	}
	

	public CustomerDTO(int id, String name, String from, String to, String resiAdress, boolean married, int passportNo,
			EducationEnum education) {
		super();
		this.id = id;
		this.name = name;
		this.from = from;
		this.to = to;
		this.resiAdress = resiAdress;
		this.married = married;
		this.passportNo = passportNo;
		this.education = education;
	}
	


	public CustomerDTO(String name, String from, String to, String resiAdress, boolean married, int passportNo,
			EducationEnum education) {
		super();
		this.name = name;
		this.from = from;
		this.to = to;
		this.resiAdress = resiAdress;
		this.married = married;
		this.passportNo = passportNo;
		this.education = education;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public int getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(int passportNo) {
		this.passportNo = passportNo;
	}

	public EducationEnum getEducation() {
		return education;
	}

	public void setEducation(EducationEnum education) {
		this.education = education;
	}


	public String getResiAdress() {
		return resiAdress;
	}


	public void setResiAdress(String resiAdress) {
		this.resiAdress = resiAdress;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + id;
		result = prime * result + (married ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + passportNo;
		result = prime * result + ((resiAdress == null) ? 0 : resiAdress.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
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
		CustomerDTO other = (CustomerDTO) obj;
		if (education != other.education)
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (id != other.id)
			return false;
		if (married != other.married)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (passportNo != other.passportNo)
			return false;
		if (resiAdress == null) {
			if (other.resiAdress != null)
				return false;
		} else if (!resiAdress.equals(other.resiAdress))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", name=" + name + ", from=" + from + ", to=" + to + ", resiAdress="
				+ resiAdress + ", married=" + married + ", passportNo=" + passportNo + ", education=" + education + "]";
	}

	
	
}
