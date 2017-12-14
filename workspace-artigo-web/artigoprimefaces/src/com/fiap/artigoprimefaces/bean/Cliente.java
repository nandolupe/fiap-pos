package com.fiap.artigoprimefaces.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe responsável em simular um Entity.
 * 
 * @author Luiz Fernando Pereira
 * 	
 */
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idCliente;
	private String nameCliente;
	private Date dtNasc;
	private String endereco;
	private String celular;
	
	
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
	public Date getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
}
