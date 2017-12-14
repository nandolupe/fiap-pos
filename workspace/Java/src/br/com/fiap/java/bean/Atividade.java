package br.com.fiap.java.bean;

/**
 * Import do arquivos externos utilizados na classe
 */
import java.util.Date;

/**
 * @category Beans
 * @author Turma Fiap 23SCJ
 */
public class Atividade {
	/**
	 * Atributo da classe do tipo java.util.Date - dataInicio
	 */
	private Date dataInicio;
	/**
	 * Atributo da classe do tipo java.util.Date - dataFim
	 */
	private Date dataFim;
	/**
	 * Atributo da classe do tipo String - nome
	 */
	private String nome;
	/**
	 * Atributo da classe do tipo String - local
	 */
	private String local;

	/**
	 * @return a dataInicio
	 */
	public Date getDataInicio() {
		return dataInicio;
	}

	/**
	 * @param dataInicio seta para dataInicio
	 */
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	/**
	 * @return a dataFim
	 */
	public Date getDataFim() {
		return dataFim;
	}

	/**
	 * @param dataFim seta para  dataFim
	 */
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
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
	 * @return o local
	 */
	public String getLocal() {
		return local;
	}

	/**
	 * @param local seta para local
	 */
	public void setLocal(String local) {
		this.local = local;
	}
}
