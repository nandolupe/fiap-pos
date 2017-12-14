package com.artigojsf12.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClienteMB {
	
	public ClienteMB() {
		cliente = new Cliente();
	}
	
	// Instância do objeto que servirá para salvar os dados do cliente
	private Cliente cliente;
	
	// Lista de clientes, que servirá para listar todos os clientes salvos.
	private List<Cliente> clienteList = new ArrayList<Cliente>();
	
	/**
	 * Método responsável em simular a inclusão de um cliente, 
	 * porém ele só atualiza a lista, dando a impressão de .
	 */
	public String salvarCliente() {
		cliente.setIdCliente(new Random().nextInt());
		clienteList.add(cliente);
		return "/index";
	}
	
	public String removerCliente() {
		clienteList.remove(cliente);
		return "/index";
	}
	
	// Getters and Setters
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Cliente> getClienteList() {
		return clienteList;
	}

	public void setClienteList(List<Cliente> clienteList) {
		this.clienteList = clienteList;
	} 
}
