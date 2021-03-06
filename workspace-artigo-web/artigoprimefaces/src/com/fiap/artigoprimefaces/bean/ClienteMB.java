package com.fiap.artigoprimefaces.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

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
// a n�vel de tempo de Request, ou seja, por requisi��o.
@SessionScoped
public class ClienteMB {
	
	public ClienteMB() {
		cliente = new Cliente();
		clienteList = new ArrayList<Cliente>();
	}
	
	// Inst�ncia do objeto que servir� para salvar os dados do cliente
	private Cliente cliente;
	
	// Lista de clientes, que servir� para listar todos os clientes salvos.
	private List<Cliente> clienteList;
	
	/**
	 * M�todo respons�vel em simular a inclus�o de um cliente, 
	 * por�m ele s� atualiza a lista, dando a impress�o de .
	 */
	public String salvarCliente() {
		cliente.setIdCliente(new Random().nextInt());
		clienteList.add(cliente);
		cliente = new Cliente();
		return "/index";
	}
	
	/**
	 * M�todo respons�vel em remove um cliente da lista da mem�ria.
	 * 
	 * @param actionEvent
	 * @return
	 */
	public String removerCliente(ActionEvent actionEvent) {
		clienteList.remove(cliente);
		cliente = new Cliente();
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
