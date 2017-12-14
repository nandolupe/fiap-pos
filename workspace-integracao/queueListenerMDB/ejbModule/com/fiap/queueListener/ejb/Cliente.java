package com.fiap.queueListener.ejb;

import java.io.Serializable;

public class Cliente implements Serializable {
	
	private Integer idCliente;
	private String nomeCliente;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer idCliente, String nomeCliente) {
		super();
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
}
