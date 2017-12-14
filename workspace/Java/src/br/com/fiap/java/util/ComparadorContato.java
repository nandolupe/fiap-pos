package br.com.fiap.java.util;

/**
 * Import do arquivos externos utilizados na classe
 */
import java.util.Comparator;

import br.com.fiap.java.bean.Contato;

/**
 * @category Utilidade
 * @author Turma Fiap 23SCJ
 */
public class ComparadorContato implements Comparator<Contato> {
	/**
	 * Método compare - Ordena collections
	 */
	public int compare(Contato contato, Contato outroContato) {
		return contato.getNome().compareTo(outroContato.getNome());
	}
}