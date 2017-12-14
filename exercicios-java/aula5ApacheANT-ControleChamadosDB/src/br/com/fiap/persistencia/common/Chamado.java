package br.com.fiap.persistencia.common;


public class Chamado {

	private int id;
	private String descricao;
	
	
	/**
	 * @return descricao - descricao do chamado
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/**
	 * @param descricao - descricao do chamado
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * @return id - id do chamado
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id - id do chamado
	 */
	public void setId(int id) {
		this.id = id;
	}
	
}
