package br.com.fiap.java.io;

/**
 * Import do arquivos externos utilizados na classe
 */
import java.io.File;

import br.com.fiap.java.exception.NegocioException;

/**
 * @category Interface IO
 * @author Turma Fiap 23SCJ
 */
public interface IArquivo {
	/**
	 * Método salvarArquivo - Escreve no arquivo file a linha passados como parâmetros
	 * @param file - File
	 * @param linha - String
	 */
	void salvarArquivo(File file, String linha) throws NegocioException;

	/**
	 * Método lerArquivo - Lê o conteúdo do file passado como parâmetros
	 * @param file - File
	 * @return texto - String
	 */
	String lerArquivo(File file)throws NegocioException;
}
