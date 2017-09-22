package com.exampleZone.SpringMVCJavaBased.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author chinmay
 *
 * @param <K>    // do make the entity's id as a serializable object in future
 * @param <T>
 */
public abstract class RootDao <K,T extends Serializable> {

	private final Class<T> persistentClass;
	
	
	/*
	 * reflection is been used here , go thrrough this part 
	 * and also find other way to fetch Class type of the current extending class at runtime (for method getById() )
	 * 
	 * */
	
	@SuppressWarnings("unchecked")
	public RootDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@PersistenceContext
	EntityManager entityManager;
	
	protected EntityManager setEntityManager()
	{
		return entityManager;
	}
	
	protected T getById( K id )
	{
		return (T) entityManager.find(persistentClass, id);
	}
	
	protected  void persist(T entity)
	{
		entityManager.persist(entity);
	}
	
	protected  void update(T entity)
	{
		entityManager.merge(entity);
	}
	
	protected void delete(T entity)
	{
		entityManager.remove(entity);
	}
	
}
