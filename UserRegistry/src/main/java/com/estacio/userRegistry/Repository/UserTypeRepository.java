package com.estacio.userRegistry.Repository;

import java.util.List;

import com.estacio.userRegistry.Model.UserType;

public interface UserTypeRepository {
	
	public UserType save(UserType user);
	public List<UserType> list();
	public UserType findById(Long id);

}
