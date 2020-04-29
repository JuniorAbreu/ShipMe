package com.estacio.userRegistry.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estacio.userRegistry.DTO.loginDTO;
import com.estacio.userRegistry.Repository.LoginRepository;

@Transactional
@Repository("loginDAO")
public class LoginDAO  extends AbstractDAO<Object> implements LoginRepository{
	

	public LoginDAO() {
		super(Object.class);
	}
	
	@Override
	public boolean validateLogin(loginDTO login) {
		EntityManager em = super.getEntityManager();
		String queryString = "SELECT * FROM ESTACIO.LOGIN WHERE ID=:id AND PASSWORD = :password";
		Query query = em.createNativeQuery(queryString);
		query.setParameter("id", login.getEmail());
		query.setParameter("password", login.getPassword());
		Object user;
		try {
			user = query.getSingleResult();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
