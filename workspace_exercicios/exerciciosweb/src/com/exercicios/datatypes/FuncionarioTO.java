package com.exercicios.datatypes;

import java.io.Serializable;

public class FuncionarioTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codFuncionario;
	private String nome;
	private String sobrenome;

	public Integer getCodFuncionario() {
		return codFuncionario;
	}
	public void setCodFuncionario(Integer codFuncionario) {
		this.codFuncionario = codFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
}
