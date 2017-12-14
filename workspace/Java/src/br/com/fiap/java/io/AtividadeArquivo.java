package br.com.fiap.java.io;

/**
 * Import do arquivos externos utilizados na classe
 */
import java.io.File;
import java.util.logging.Level;

import br.com.fiap.java.exception.NegocioException;

/**
 * 
 * @category Neg�cio 
 * @author Turma Fiap 23SCJ
 * 
 */
public class AtividadeArquivo extends ArquivoGenerico {
	/**
	 * Constatante Caminho onde sera gravado informa��es da atividades
	 */
	private static final String CAMINHO_ARQUIVO_ATIVIDADES = "C:\\atividades.txt";
	/**
	 * Atributo do tipo AtividadeArquivo - singleton
	 */
	public static AtividadeArquivo singleton;

	/**
	 * Construtor private
	 */
	private AtividadeArquivo() {
		super();
	}

	/**
	 * M�todo getInstance
	 * @return uma inst�ncia da classe - AtividadeArquivo
	 */
	public static AtividadeArquivo getInstance() {
		// verifica se a inst�ncia �nica da classe esta nula
		if (singleton == null) {
			// Cria uma inst�ncia �nica
			singleton = new AtividadeArquivo();
		}
		// Retorna inst�ncia �nica de AtividadeArquivo
		return singleton;
	}

	/**
	 * M�todo escreverAtividades
	 * @param linha texto para persistir no arquivo
	 * @throws NegocioException 
	 */
	public void escreverAtividades(String linha) throws NegocioException {
		// Seta a n�vel de permiss�o
		logger.setLevel(Level.ALL);
		// Escreve no console a msg passada como par�metro - level INFO
		logger.log(Level.INFO, "M�todo escreverAtividades");
		// Escreve no console a msg passada como par�metro - level INFO
		logger.log(Level.INFO, "Criando o file atividades");
		// Cria o file com caminho da constante
		File file = new File(CAMINHO_ARQUIVO_ATIVIDADES);
		// Chama o m�todo salvarArquivo da classe pai.
		salvarArquivo(file, linha);
	}

	/**
	 * M�todo lerAtividades
	 * @return as atividades persistidos no arquivo
	 * @throws NegocioException 
	 */
	public String lerAtividades() throws NegocioException {
		// Seta a n�vel de permiss�o
		logger.setLevel(Level.ALL);
		// Escreve no console a msg passada como par�metro - level INFO
		logger.log(Level.INFO, "M�todo lerAtividades");
		// Escreve no console a msg passada como par�metro - level INFO
		logger.log(Level.INFO, "Criando o file atividades");
		// Cria o file com caminho da constante
		File file = new File(CAMINHO_ARQUIVO_ATIVIDADES);
		// Return o texto do m�todo lerArquivo da classe pai.
		return lerArquivo(file);
	}
}
