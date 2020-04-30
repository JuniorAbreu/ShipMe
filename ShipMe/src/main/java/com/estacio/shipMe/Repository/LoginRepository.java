package com.estacio.shipMe.Repository;

import com.estacio.shipMe.DTO.loginDTO;

public interface LoginRepository {
	
	public boolean validateLogin(loginDTO login);

}
