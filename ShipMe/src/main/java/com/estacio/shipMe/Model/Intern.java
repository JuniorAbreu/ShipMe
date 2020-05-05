package com.estacio.shipMe.Model;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

public class Intern extends Employee{
	
	Date contratExpirationDate;
	
	public Intern(Long id, String name, UserType type,String serialNumber, Date contratExpirationDate, String role, Double salary) {
		super(id, name, type, serialNumber, role, salary);
		this.contratExpirationDate = contratExpirationDate;
	}

	public Date getContratExpirationDate() {
		return contratExpirationDate;
	}

	public void setContratExpirationDate(Date contratExpirationDate) {
		this.contratExpirationDate = contratExpirationDate;
	}
	
	public Long calcExpirantionDate(Date startDate, Date finishDate) {
		long diffInMillies = Math.abs(startDate.getTime() - finishDate.getTime());
		return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

}
