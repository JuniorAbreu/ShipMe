package com.estacio.shipMe.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estacio.shipMe.Model.User;
import com.estacio.shipMe.Repository.UserRepository;

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
	
	public User findById(Long id) {
		return super.findById(id);
	}

}
