package br.com.fiap.java.bean;

/**
 * Import do arquivos externos utilizados na classe
 */
import java.util.ArrayList;
import java.util.List;

/**
 * @category Beans
 * @author Turma Fiap 23SCJ
 */
public class Contato {
	/**
	 * Atributo da classe do tipo String - nome
	 */
	private String nome;
	/**
	 * Atributo da classe do tipo String - email
	 */
	private String email;
	/**
	 * Atributo da classe do tipo List - telefones
	 */
	private List<Telefone> telefones;

	/**
	 * Construtor de Contato
	 */
	public Contato() {
		super();
		// Instância a List telefones com ArrayList
		telefones = new ArrayList<Telefone>();
	}

	/**
	 * @return o nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome seta para nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return o email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email seta para email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return os telefones
	 */
	public List<Telefone> getTelefones() {
		return telefones;
	}

	/**
	 * @param telefones seta para telefones
	 */
	public void setTelefones(Telefone... telefones) {
		for (Telefone telefone : telefones) {
			this.telefones.add(telefone);
		}
	}
}
