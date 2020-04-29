package com.estacio.userRegistry.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estacio.userRegistry.Model.UserType;
import com.estacio.userRegistry.Repository.UserTypeRepository;

@Transactional
@Repository("userTypeDAO")
public class UserTypeDAO  extends AbstractDAO<UserType> implements UserTypeRepository {

	public UserTypeDAO() {
		super(UserType.class);
	}
	
	@Override
	public UserType save(UserType user) {
		return null;
	}
	
	@Override
	public List<UserType> list() {
		return super.list();
	}
	
	public UserType findById(Long id) {
		return super.findById(id);
	}

}
