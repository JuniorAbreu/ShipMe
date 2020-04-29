package com.estacio.userRegistry.Repository;

import java.util.List;

import com.estacio.userRegistry.Model.User;

public interface UserRepository {
	
	public User save(User user);
	public List<User> list();
	public void delete(User user);

}
