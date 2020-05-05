package com.estacio.shipMe.Model;

public class Employee extends User{
	
	String serialNumber;
	String role;
	Double salary;
	
	public Employee(Long id, String name, UserType type,String serialNumber, String role, Double salary) {
		super(id, name, type);
		this.serialNumber = serialNumber;
		this.role = role;
		this.salary = salary;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}	
	
	public void calcSalary(int daysInMonth, int workedOursPerDay, Double hourValue) {
		this.salary = (hourValue * workedOursPerDay) * daysInMonth;
	}

}
