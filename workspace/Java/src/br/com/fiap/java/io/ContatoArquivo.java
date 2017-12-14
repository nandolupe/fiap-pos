package br.com.fiap.java.io;

/**
 * Import do arquivos externos utilizados na classe
 */
import java.io.File;
import java.util.logging.Level;

import br.com.fiap.java.exception.NegocioException;

/**
 * @category Neg�cio
 * @author Turma Fiap 23SCJ
 */
public class ContatoArquivo extends ArquivoGenerico {
	/**
	 * Constatante Caminho onde sera gravado informa��es do arquivo
	 */
	private static final String CAMINHO_ARQUIVO_CONTATOS = "C:\\contatos.txt";
	/**
	 * Atributo do tipo AtividadeArquivo
	 */
	public static ContatoArquivo singleton;

	/**
	 * Construtor private
	 */
	private ContatoArquivo() {
		super();
	}

	/**
	 * M�todo getInstance
	 * @return uma inst�ncia da classe
	 */
	public static ContatoArquivo getInstance() {
		// verifica se a inst�ncia �nica da classe esta nula
		if (singleton == null) {
			// Cria uma inst�ncia �nica
			singleton = new ContatoArquivo();
		}
		// Retorna inst�ncia �nica de AtividadeArquivo
		return singleton;
	}

	/**
	 * M�todo escreverContatos
	 * @param linha texto para persistir no arquivo
	 * @throws NegocioException 
	 */
	public void escreverContatos(String linha) throws NegocioException {
		// Seta a n�vel de permiss�o
		logger.setLevel(Level.ALL);
		// Escreve no console a msg passada como par�metro - level INFO
		logger.log(Level.INFO, "M�todo escreverContatos");
		// Escreve no console a msg passada como par�metro - level INFO
		logger.log(Level.INFO, "Criando o file contatos");
		// Cria o file com caminho da constante
		File file = new File(CAMINHO_ARQUIVO_CONTATOS);
		// Chama o m�todo salvarArquivo da classe pai.
		salvarArquivo(file, linha);
	}

	/**
	 * M�todo lerContatos
	 * @return os contatos persistidos no arquivo
	 * @throws NegocioException 
	 */
	public String lerContatos() throws NegocioException {
		// Seta a n�vel de permiss�o
		logger.setLevel(Level.ALL);
		// Escreve no console a msg passada como par�metro - level INFO
		logger.log(Level.INFO, "M�todo escreverContatos");
		// Escreve no console a msg passada como par�metro - level INFO
		logger.log(Level.INFO, "Criando o file contatos");
		// Cria o file com caminho da constante
		File file = new File(CAMINHO_ARQUIVO_CONTATOS);
		// Return o texto do m�todo lerArquivo da classe pai.
		return lerArquivo(file);
	}
}
