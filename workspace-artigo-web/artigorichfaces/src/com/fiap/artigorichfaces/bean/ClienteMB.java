package com.fiap.artigorichfaces.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Classe respons�vel em ser o Managed Bean da tela de cadastro de clientes.
 * 
 * @author Luiz Fernando
 *
 */
// Annotation respons�vel em identificar o nome do Managed Bean que o 
// faces ir� utilizar para administrar o cadastro de clientes
@ManagedBean(name = "clienteMB")
// @RequestScoped identifica que a vida �til desse Managed Bean ser� 
// a n�vel de tempo de Session, ou seja, por sess�o.
@SessionScoped
public class ClienteMB {
	
	// Construtor padr�o
	public ClienteMB() {
		cliente = new Cliente();
	}
	
	// Inst�ncia do objeto que servir� para salvar os dados do cliente
	private Cliente cliente;
	
	// Lista de clientes, que servir� para listar todos os clientes salvos.
	private List<Cliente> clienteList = new ArrayList<Cliente>();
	
	/**
	 * M�todo respons�vel em simular a inclus�o de um cliente, 
	 * por�m ele s� atualiza a lista, dando a impress�o de .
	 */
	public String salvarCliente() {
		cliente.setIdCliente(new Random().nextInt());
		clienteList.add(cliente);
		return "/index";
	}
	
	/**
	 * M�todo respons�vel em remover um cliente da lista.
	 */
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
