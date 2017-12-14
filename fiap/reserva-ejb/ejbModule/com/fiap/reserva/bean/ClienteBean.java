package com.fiap.reserva.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.fiap.reserva.dao.ClienteDAO;
import com.fiap.reserva.entity.Cliente;

/**
 * Session Bean implementation class LivrosBean
 */
@Stateless
public class ClienteBean implements ClienteBeanLocal {

	/**
	 * Default constructor. 
	 */
	public ClienteBean() { 
		//clienteDAO = ClienteDAO.newInstance(em);
	}
	
	@PersistenceContext(unitName="fiapPU")
	private EntityManager em;
	
	private ClienteDAO clienteDAO;
	
	@Override
	public void salvarCliente(Cliente cliente) {
		clienteDAO.add(cliente);
	}

	@Override
	public Cliente validarLogin(Cliente cliente) throws Exception {
		
		Cliente clienteResult = clienteDAO.validarLogin(cliente);
		
		if (clienteResult == null) {
			throw new Exception("Login e/ou Senha inválidos!");
		}
		
		return cliente;
	}
}
