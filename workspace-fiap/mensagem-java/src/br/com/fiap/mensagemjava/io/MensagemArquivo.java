package br.com.fiap.mensagemjava.io;

import java.io.File;
import java.util.logging.Level;

import br.com.fiap.mensagemjava.exception.NegocioException;

/**
 * Classe <code>MensagemArquivo</code>.
 * 
 * Responsável em contemplar as funcionalidades de acesso a 
 * arquivo da funciondalidade de Mensagem.
 *
 * @category br.com.fiap.mensagemjava.io.
 *
 * @author Luiz Fernando
 *
 * @since 15/07/2014 - VM (build 2.4, J2RE 1.6.0).
 *
 */
public class MensagemArquivo extends ArquivoGenerico {

	private static final String CAMINHO_ARQUIVO_MENSAGEM = "C:\\arquivos\\mensagem-codificada.txt";
	
	
	public static MensagemArquivo singleton;

	/**
	 * Cria uma nova instancia (objeto) da classe MensagemArquivo.
	 *
	 *
	 * @since 15/07/2014 - Luiz Fernando.
	 */
	private MensagemArquivo() {
		super();
	}

	/**
	 * Metodo getInstance.
	 *
	 * @return
	 *
	 * @since 15/07/2014 - Luiz Fernando
	 */
	public static MensagemArquivo getInstance() {
		if (singleton == null) {
			singleton = new MensagemArquivo();
		}
		return singleton;
	}

	/**
	 * Metodo codificarMensagem, método responsável em codificar uma Mensagem.
	 *
	 * @param linha
	 * @throws NegocioException
	 *
	 * @since 15/07/2014 - Luiz Fernando
	 */
	public void codificarMensagem(String linha) throws NegocioException {
		logger.setLevel(Level.ALL);
		logger.log(Level.INFO, "Método escrever mensagem");
		logger.log(Level.INFO, "Criando o file mensagem");
		File file = new File(CAMINHO_ARQUIVO_MENSAGEM);
		salvarArquivo(file, linha);
	}
	
	/**
	 * Metodo decodificarMensagem, responsável em decodificar uma Mensagem.
	 *
	 * @param caminho
	 * @return
	 * @throws NegocioException
	 *
	 * @since 15/07/2014 - Luiz Fernando
	 */
	public String decodificarMensagem(String caminho) throws NegocioException {
		logger.setLevel(Level.ALL);
		logger.log(Level.INFO, "Método decodificar mensagem");
		logger.log(Level.INFO, "Lendo o file mensagem");
		File file = new File(caminho);
		return lerArquivo(file);
	}
}
