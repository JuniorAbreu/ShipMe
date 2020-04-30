package com.estacio.shipMe.Repository;

import java.util.List;

import com.estacio.shipMe.Model.User;

public interface UserRepository {
	
	public User save(User user);
	public List<User> list();
	public void delete(User user);
	public User findById(Long id);

}
