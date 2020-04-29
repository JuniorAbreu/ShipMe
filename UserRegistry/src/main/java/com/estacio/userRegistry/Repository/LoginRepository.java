package com.estacio.userRegistry.Repository;

import com.estacio.userRegistry.DTO.loginDTO;

public interface LoginRepository {
	
	public boolean validateLogin(loginDTO login);

}
