package com.fiap.artigostruts2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@Results({
	@Result(name="success", location="/index.jsp"),
	@Result(name="input", location="/index.jsp")
})
public class CadastroInserirCliente extends ActionSupport {
	private Cliente cliente;

	@Action(value="/inserircliente")
	public String execute() {
		
		List<Cliente> clienteList = (List<Cliente>) ServletActionContext.getRequest().getSession().getAttribute("clienteList");
		
		if (clienteList == null) {
			clienteList = new ArrayList<Cliente>();
		}
		
		cliente.setIdCliente(new Random().nextInt());
		clienteList.add(cliente);
		cliente = new Cliente();
		ServletActionContext.getRequest().getSession().setAttribute("clienteList", clienteList);
		
		return SUCCESS;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
