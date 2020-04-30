package com.estacio.shipMe.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estacio.shipMe.Model.UserType;
import com.estacio.shipMe.Repository.UserTypeRepository;

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
