package com.fiap.artigojsf20.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	private String dtNasc;
	
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
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			cliente.setDtNasc(dateFormat.parse(dtNasc));
		} catch (ParseException e) {
			System.out.println("ERRO AO FAZER O PARSE DA DATA DE NASCIMENTO!");
		}
		
		clienteList.add(cliente);
		return "/index";
	}
	
	public String removerCliente(ActionEvent actionEvent) {
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

	public String getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}
}
