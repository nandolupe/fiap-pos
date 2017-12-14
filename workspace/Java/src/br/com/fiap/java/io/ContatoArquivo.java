package br.com.fiap.java.io;

/**
 * Import do arquivos externos utilizados na classe
 */
import java.io.File;
import java.util.logging.Level;

import br.com.fiap.java.exception.NegocioException;

/**
 * @category Negócio
 * @author Turma Fiap 23SCJ
 */
public class ContatoArquivo extends ArquivoGenerico {
	/**
	 * Constatante Caminho onde sera gravado informações do arquivo
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
	 * Método getInstance
	 * @return uma instância da classe
	 */
	public static ContatoArquivo getInstance() {
		// verifica se a instância única da classe esta nula
		if (singleton == null) {
			// Cria uma instância única
			singleton = new ContatoArquivo();
		}
		// Retorna instância única de AtividadeArquivo
		return singleton;
	}

	/**
	 * Método escreverContatos
	 * @param linha texto para persistir no arquivo
	 * @throws NegocioException 
	 */
	public void escreverContatos(String linha) throws NegocioException {
		// Seta a nível de permissão
		logger.setLevel(Level.ALL);
		// Escreve no console a msg passada como parâmetro - level INFO
		logger.log(Level.INFO, "Método escreverContatos");
		// Escreve no console a msg passada como parâmetro - level INFO
		logger.log(Level.INFO, "Criando o file contatos");
		// Cria o file com caminho da constante
		File file = new File(CAMINHO_ARQUIVO_CONTATOS);
		// Chama o método salvarArquivo da classe pai.
		salvarArquivo(file, linha);
	}

	/**
	 * Método lerContatos
	 * @return os contatos persistidos no arquivo
	 * @throws NegocioException 
	 */
	public String lerContatos() throws NegocioException {
		// Seta a nível de permissão
		logger.setLevel(Level.ALL);
		// Escreve no console a msg passada como parâmetro - level INFO
		logger.log(Level.INFO, "Método escreverContatos");
		// Escreve no console a msg passada como parâmetro - level INFO
		logger.log(Level.INFO, "Criando o file contatos");
		// Cria o file com caminho da constante
		File file = new File(CAMINHO_ARQUIVO_CONTATOS);
		// Return o texto do método lerArquivo da classe pai.
		return lerArquivo(file);
	}
}
