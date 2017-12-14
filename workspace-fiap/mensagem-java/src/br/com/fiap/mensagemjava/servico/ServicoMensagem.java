package br.com.fiap.mensagemjava.servico;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import br.com.fiap.mensagemjava.exception.NegocioException;
import br.com.fiap.mensagemjava.io.MensagemArquivo;

/**
 * Classe <code>ServicoMensagem</code>.
 *
 * Classe respons�vel em contemplar as funcionalidade de 
 * neg�cio da funcionalidade de Mensagem.
 *
 * @category br.com.fiap.mensagemjava.servico.
 *
 * @author Luiz Fernando
 *
 * @since 15/07/2014 - VM (build 2.4, J2RE 1.6.0).
 *
 */
public class ServicoMensagem {
	Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * Metodo codificar, respons�vel em codificar uma Mensagem.
	 *
	 * @param mensagem
	 *
	 * @since 15/07/2014 - Luiz Fernando
	 */
	public void codificar(String mensagem) {
		logger.setLevel(Level.ALL);
		logger.log(Level.INFO, "M�todo codificar()");

		try {
			
			MensagemArquivo.getInstance().codificarMensagem(mensagem);
			
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	/**
	 * Metodo decodificar, respons�vel em decodificar uma Mensagem.
	 *
	 * @param caminho
	 * @return
	 *
	 * @since 15/07/2014 - Luiz Fernando
	 */
	public String decodificar(String caminho) {
		logger.setLevel(Level.ALL);
		logger.log(Level.INFO, "M�todo decodificar()");

		String mensagemDecodificada = "";
		
		try {
			
			mensagemDecodificada = MensagemArquivo.getInstance().decodificarMensagem(caminho);
			
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return mensagemDecodificada;
	}
}
