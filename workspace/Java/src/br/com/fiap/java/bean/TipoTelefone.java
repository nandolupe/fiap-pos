package br.com.fiap.java.bean;

/**
 * @category Enum
 * @author Turma Fiap 23SCJ Enum de tipo de Telefone
 */
public enum TipoTelefone {
	Residencial("Residencial", 1), Comercial("Comercial", 2), Celular("Celular", 3);
	/**
	 * Atributo do Enum - codigo
	 */
	private int codigo;
	/**
	 * Atributo do Enum - descricao
	 */
	private String descricao;

	/**
	 * Construtor
	 * @param descricao
	 * @param codigo
	 */
	TipoTelefone(String descricao, int codigo) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	/**
	 * @return o codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo seta para  codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return o numero
	 */
	public String getDescricao() {
		return descricao;
	}
}