package com.fiap.clinicaweb.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 * 
 * @author Luiz Pereira
 * 
 * @since 14/05/2014
 */
public class GenericDAO implements Dao<Serializable> {

	private EntityManager em;

	public GenericDAO(EntityManager em) {
		this.em = em;
	}

	/* (non-Javadoc)
	 * @see com.fiap.exercicios.jpa.dao.Dao#insert(java.io.Serializable)
	 */
	@Override
	public void insert(Serializable entity) {
		try{
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.fiap.exercicios.jpa.dao.Dao#update(java.io.Serializable)
	 */
	@Override
	public void update(Serializable entity) {
		try{
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.fiap.exercicios.jpa.dao.Dao#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Serializable entity, Integer primaryKey) throws Exception {
		try{
			em.getTransaction().begin();
			em.remove(em.find(entity.getClass(), primaryKey));
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	/* (non-Javadoc)
	 * @see com.fiap.exercicios.jpa.dao.Dao#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Serializable> findAll(Serializable entity) {
		
		List<Serializable> list = null;
		
		try{
			em.getTransaction().begin();
			list = em.createNamedQuery(entity.getClass().getSimpleName() + ".findAll").getResultList();
		}catch(NoResultException e){
			System.out.println("Não há dados na tabela.");
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			em.flush();
			em.close();
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.fiap.exercicios.jpa.dao.Dao#findEspecific(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Serializable> findEspecific(Serializable entity, Integer id) {
		
		List<Serializable> list = null;
		
		try{
			em.getTransaction().begin();
			list = (List<Serializable>) em.find(entity.getClass().getComponentType(), id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.fiap.exercicios.jpa.dao.Dao#findById(java.lang.Integer)
	 */
	@Override
	public Serializable findById(Serializable entity, Integer primaryKey) {

		
		try{
			em.getTransaction().begin();
			entity = (Serializable) em.find(entity.getClass(), primaryKey);
		}catch(Exception e){
			e.printStackTrace();
		}
		return entity;
	}
	
	/* (non-Javadoc)
	 * @see com.fiap.clinicaweb.persistence.Dao#findById(java.io.Serializable, java.lang.String)
	 */
	@Override
	public Serializable findById(Serializable entity, String primaryKey) {

		try{
			em.getTransaction().begin();
			entity = (Serializable) em.find(entity.getClass(), primaryKey);
		}catch(Exception e){
			e.printStackTrace();
		}
		return entity;
	}
}
