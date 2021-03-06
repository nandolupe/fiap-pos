package com.fiap.artigostruts2.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@Results({
	@Result(name="success", location="/index.jsp"),
	@Result(name="input", location="/index.jsp")
})
public class CadastroListarCliente extends ActionSupport {
	private Cliente cliente;
	private List<Cliente> clienteList;

	@Action(value="/listarcliente")
	public String execute() {

		return SUCCESS;
	}

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
