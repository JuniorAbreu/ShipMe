package com.estacio.shipMe.Model;

public class Employee extends User{
	
	String serialNumber;
	
	public Employee(Long id, String name, UserType type,String serialNumber) {
		super(id, name, type);
		this.serialNumber = serialNumber;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

}
