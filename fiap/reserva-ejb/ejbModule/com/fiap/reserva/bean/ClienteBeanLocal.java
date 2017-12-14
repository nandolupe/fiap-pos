package com.fiap.reserva.bean;

import javax.ejb.Local;

import com.fiap.reserva.entity.Cliente;

@Local
public interface ClienteBeanLocal {
	public void salvarCliente(Cliente cliente);
	public Cliente validarLogin(Cliente cliente) throws Exception;
}

