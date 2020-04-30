package com.estacio.shipMe.Model;

import java.sql.Date;

public class Intern extends Employee{
	
	Date contratExpirationDate;
	
	public Intern(Long id, String name, UserType type,String serialNumber, Date contratExpirationDate) {
		super(id, name, type, serialNumber);
		this.contratExpirationDate = contratExpirationDate;
	}

	public Date getContratExpirationDate() {
		return contratExpirationDate;
	}

	public void setContratExpirationDate(Date contratExpirationDate) {
		this.contratExpirationDate = contratExpirationDate;
	}

}
