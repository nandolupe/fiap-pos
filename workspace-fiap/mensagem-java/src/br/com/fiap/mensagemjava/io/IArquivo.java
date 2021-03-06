package br.com.fiap.mensagemjava.io;

import java.io.File;

import br.com.fiap.mensagemjava.exception.NegocioException;

/**
 * Classe <code>IArquivo</code>.
 *
 * Interface responsável em manter o contrato para a criação de arquivos.
 * 
 * @category br.com.fiap.mensagemjava.io.
 *
 * @author Luiz Fernando
 *
 * @since 15/07/2014 - VM (build 2.4, J2RE 1.6.0).
 *
 */
public interface IArquivo {

	/**
	 * Metodo salvarArquivo, responsável em criar e salvar um arquivo.
	 *
	 * @param file
	 * @param linha
	 * @throws NegocioException
	 *
	 * @since 15/07/2014 - Luiz Fernando
	 */
	void salvarArquivo(File file, String linha) throws NegocioException;

	/**
	 * Metodo lerArquivo, responsável em fazer uma leitura de um arquivo a partir de um caminho específico.
	 *
	 * @param file
	 * @return
	 * @throws NegocioException
	 *
	 * @since 15/07/2014 - Luiz Fernando
	 */
	String lerArquivo(File file)throws NegocioException;
}
