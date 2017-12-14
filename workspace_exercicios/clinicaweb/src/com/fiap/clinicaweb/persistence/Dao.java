package com.fiap.clinicaweb.persistence;

import java.io.Serializable;
import java.util.List;

public interface Dao<T extends Serializable> {
	
	void insert(T entity);
	
	void update(T entity);
	
	void delete(Serializable entity, Integer primaryKey) throws Exception;
	
	List<T> findAll(Serializable entity);
	
	List<T> findEspecific(Serializable entity, Integer id);
	
	T findById(Serializable entity, Integer primaryKey);

	T findById(Serializable entity, String primaryKey);
}