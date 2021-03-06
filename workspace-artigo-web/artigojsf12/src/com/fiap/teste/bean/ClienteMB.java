package com.fiap.teste.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe respons�vel em gerenciar as a��es do cadastro de clientes
 * 
 * @author Luiz Fernando Pereira
 *
 */
public class ClienteMB {
	
	/**
	 * Como no JSF 1.2 n�o tem um tratamento adequado ao objeto {@link java.util.Date}
	 * temos que tratar a data como String e depois realizar o parse para Date.
	 */
	private String dtNasc;
	
	/**
	 * Construtor padr�o.
	 */
	public ClienteMB() {
		cliente = new Cliente();
	}

	/**
	 * Objeto utilizado pelo JSP.
	 */
	private Cliente cliente;
	
	/**
	 * Lista em mem�ria, que dar� a impress�o de um cadastro em uma base de dados.
	 */
	private List<Cliente> clienteList = new ArrayList<Cliente>();

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

	/**
	 * M�todo respons�vel em inserir um cliente em nossa Lista.
	 * 
	 * @return
	 */
	public String inserirCliente() {
		cliente.setIdCliente(new Random().nextInt());
		
		// Instancia um SimpleDateFormat para parse da data da tela
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			cliente.setDtNasc(dateFormat.parse(dtNasc));
		} catch (ParseException e) {
			System.out.println("ERRO AO FAZER O PARSE DA DATA DE NASCIMENTO!");
		}
		// ADICIONA O CLIENTE NA LISTA.
		clienteList.add(cliente);
		// CRIA UMA NOVA REFERENCIA EM MEM�RIA PARA UM PR�XIMO CADASTRO.
		cliente = new Cliente();
		dtNasc = null;
		return "success";
	}

	/**
	 * Respons�vel em Remover um cliente da lista.
	 * 
	 * @return
	 */
	public String removerCliente() {
		clienteList.remove(cliente);
		cliente = new Cliente();
		return "success";
	}
}
