package com.fiap.artigostruts2.action;

import java.io.Serializable;
import java.util.Date;

public class Cliente implements Serializable {
	
	private Integer idCliente;
	private String nameCliente;
	private String sobrenome;
	private Date dtNasc;
	
	public Cliente() {}
	
	public Cliente(Integer idCliente, String nameCliente, String sobrenome,
			Date dtNasc) {
		super();
		this.idCliente = idCliente;
		this.nameCliente = nameCliente;
		this.sobrenome = sobrenome;
		this.dtNasc = dtNasc;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNameCliente() {
		return nameCliente;
	}
	public void setNameCliente(String nameCliente) {
		this.nameCliente = nameCliente;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Date getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}
}
