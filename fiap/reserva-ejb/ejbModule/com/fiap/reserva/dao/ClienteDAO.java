package com.fiap.reserva.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.fiap.reserva.entity.Cliente;

public class ClienteDAO {
	
	private static ClienteDAO clienteDAO;
	
	private EntityManager em = null;
	
	private ClienteDAO(EntityManager entityManager) {
		em = entityManager;
	}
	
	/**
	 * Singleton para manter apenas uma instância em memória do DAO.
	 * 
	 * @param entityManager
	 * @return
	 */
	public static ClienteDAO newInstance(EntityManager entityManager) {
		if (clienteDAO == null) {
			clienteDAO = new ClienteDAO(entityManager);
		}
		return clienteDAO;
	}
	
	public void add(Cliente cliente){
		em.persist(cliente);
	}
	
	public List<Cliente> getAll(){
		TypedQuery<Cliente> query = em.createQuery("select u from Cliente u", Cliente.class);
		return query.getResultList();
	}
	
	public Cliente validarLogin(Cliente cliente){
		
		TypedQuery<Cliente> query = em.createQuery("select c from Cliente c where c.login = :login and c.senha = :senha", Cliente.class)
				.setParameter("login", cliente.getLogin())
				.setParameter("senha", cliente.getSenha());
		
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
