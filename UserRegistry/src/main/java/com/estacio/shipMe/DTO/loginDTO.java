package com.estacio.shipMe.DTO;

public class loginDTO {
	
	String email;
	String password;
	
	public loginDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public loginDTO() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
