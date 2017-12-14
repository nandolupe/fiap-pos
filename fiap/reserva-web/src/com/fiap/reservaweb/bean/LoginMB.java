package com.fiap.reservaweb.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.fiap.reserva.bean.ClienteBeanLocal;
import com.fiap.reserva.entity.Cliente;

@ManagedBean(name = "clienteMB")
@SessionScoped
public class LoginMB {
	
	@EJB(lookup = "ejb:/reserva-ejb/ClienteBean!com.fiap.reserva.bean.ClienteBeanLocal")
	private ClienteBeanLocal clienteBeanLocal;
	
	private Cliente cliente;
	
	public LoginMB() {
		cliente = new Cliente();
	}
		
	/**
	 * Método responsável em simular a inclusão de um cliente, 
	 * porém ele só atualiza a lista, dando a impressão de .
	 */
	public String salvarCliente() {
		return "/index";
	}
	
	/**
	 * Método responsável em remove um cliente da lista da memória.
	 * 
	 * @param actionEvent
	 * @return
	 */
	public String removerCliente(ActionEvent actionEvent) {
		return "/index";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String logar() {
		try {
			clienteBeanLocal.validarLogin(cliente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "/index";
	}
}
