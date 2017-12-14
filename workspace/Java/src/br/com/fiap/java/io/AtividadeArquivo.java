package br.com.fiap.java.io;

/**
 * Import do arquivos externos utilizados na classe
 */
import java.io.File;
import java.util.logging.Level;

import br.com.fiap.java.exception.NegocioException;

/**
 * 
 * @category Negócio 
 * @author Turma Fiap 23SCJ
 * 
 */
public class AtividadeArquivo extends ArquivoGenerico {
	/**
	 * Constatante Caminho onde sera gravado informações da atividades
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
	 * Método getInstance
	 * @return uma instância da classe - AtividadeArquivo
	 */
	public static AtividadeArquivo getInstance() {
		// verifica se a instância única da classe esta nula
		if (singleton == null) {
			// Cria uma instância única
			singleton = new AtividadeArquivo();
		}
		// Retorna instância única de AtividadeArquivo
		return singleton;
	}

	/**
	 * Método escreverAtividades
	 * @param linha texto para persistir no arquivo
	 * @throws NegocioException 
	 */
	public void escreverAtividades(String linha) throws NegocioException {
		// Seta a nível de permissão
		logger.setLevel(Level.ALL);
		// Escreve no console a msg passada como parâmetro - level INFO
		logger.log(Level.INFO, "Método escreverAtividades");
		// Escreve no console a msg passada como parâmetro - level INFO
		logger.log(Level.INFO, "Criando o file atividades");
		// Cria o file com caminho da constante
		File file = new File(CAMINHO_ARQUIVO_ATIVIDADES);
		// Chama o método salvarArquivo da classe pai.
		salvarArquivo(file, linha);
	}

	/**
	 * Método lerAtividades
	 * @return as atividades persistidos no arquivo
	 * @throws NegocioException 
	 */
	public String lerAtividades() throws NegocioException {
		// Seta a nível de permissão
		logger.setLevel(Level.ALL);
		// Escreve no console a msg passada como parâmetro - level INFO
		logger.log(Level.INFO, "Método lerAtividades");
		// Escreve no console a msg passada como parâmetro - level INFO
		logger.log(Level.INFO, "Criando o file atividades");
		// Cria o file com caminho da constante
		File file = new File(CAMINHO_ARQUIVO_ATIVIDADES);
		// Return o texto do método lerArquivo da classe pai.
		return lerArquivo(file);
	}
}
