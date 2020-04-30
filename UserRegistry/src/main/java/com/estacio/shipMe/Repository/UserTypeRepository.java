package com.estacio.shipMe.Repository;

import java.util.List;

import com.estacio.shipMe.Model.UserType;

public interface UserTypeRepository {
	
	public UserType save(UserType user);
	public List<UserType> list();
	public UserType findById(Long id);

}
