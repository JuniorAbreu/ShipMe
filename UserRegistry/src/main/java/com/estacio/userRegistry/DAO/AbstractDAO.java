package com.estacio.userRegistry.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;


public abstract class AbstractDAO<T> {
	private final Class<T> persistentClass;
	
	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	public AbstractDAO(Class<T> argClass) {
		this.persistentClass = argClass;
	}

	public EntityManager getEntityManager(){
		return this.em;
	}
	
	public T findById(Long key) {
		return (T) em.find(persistentClass, key);
	}

	public T merge(T instance){
		
		T merge = em.merge(instance);
		em.flush();
		
		return merge;
	}

	public void delete(T instance, Long id) {
		em.remove(em.getReference(instance.getClass(), id));
		em.flush();
		em.clear();
	}

	@SuppressWarnings("unchecked")
	public List<T> list(){
		return em.createQuery("FROM "+persistentClass.getName()).getResultList();
	}

}
