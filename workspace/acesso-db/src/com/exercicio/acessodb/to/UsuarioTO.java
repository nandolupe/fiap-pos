package com.exercicio.acessodb.to;

import java.io.Serializable;

public class UsuarioTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer idUsuario;
	private String nmUsuario;
	private String login;
	private String password;
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNmUsuario() {
		return nmUsuario;
	}
	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
