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
	 * M�todo salvarArquivo - Escreve no arquivo file a linha passados como par�metros
	 * @param file - File
	 * @param linha - String
	 */
	void salvarArquivo(File file, String linha) throws NegocioException;

	/**
	 * M�todo lerArquivo - L� o conte�do do file passado como par�metros
	 * @param file - File
	 * @return texto - String
	 */
	String lerArquivo(File file)throws NegocioException;
}
