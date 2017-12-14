package br.com.fiap.java.bean;

/**
 * @category Beans
 * @author Turma Fiap 23SCJ
 */
public class Telefone {
	/**
	 * Atributo da classe tipo String - numero
	 */
	private String numero;
	/**
	 * Atributo da classe tipo TipoTelefone - tipo
	 */
	private TipoTelefone tipo;

	/**
	 * Construtor que obriga ser passado os parametros para instanciar
	 * @param numero
	 * @param tipo
	 */
	public Telefone(String numero, TipoTelefone tipo) {
		super();
		this.numero = numero;
		this.tipo = tipo;
	}

	/**
	 * @return o numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @return o tipo
	 */
	public TipoTelefone getTipo() {
		return tipo;
	}
}
