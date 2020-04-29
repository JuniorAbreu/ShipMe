package com.estacio.userRegistry.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estacio.userRegistry.Model.User;
import com.estacio.userRegistry.Repository.UserRepository;

@Transactional
@Repository("userDAO")
public class UserDAO  extends AbstractDAO<User> implements UserRepository {

	public UserDAO() {
		super(User.class);
	}

	@Override
	public User save(User user) {
		return super.merge(user);
	}
	
	@Override
	public List<User> list() {
		return super.list();
	}
	
	@Override
	public void delete(User user) {
		super.delete(user, user.getId());
	}

}
