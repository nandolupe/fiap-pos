package com.fiap.artigostruts13.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.struts.action.ActionForm;

import com.fiap.artigostruts13.entity.Cliente;

public class ClienteForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	
	private Integer idCliente;
	private String nameCliente;
	private String sobrenome;
	private String dtNasc;
	
	public Cliente doCliente() {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		Cliente cliente = null;
		
		try {
			cliente = new Cliente(new Random().nextInt(), nameCliente, sobrenome, dateFormat.parse(dtNasc));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	public void resetForm() {
		this.idCliente = null;
		this.nameCliente = null;
		this.sobrenome = null;
		this.dtNasc = null;
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
	public String getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
}
