package br.com.fiap.mensagemjava.exception;

/**
 * Classe <code>NegocioException</code>.
 *
 * Exception responsável pelos erros de Negócio do sistema.
 * 
 * @category br.com.fiap.mensagemjava.exception.
 *
 * @author Luiz Fernando
 *
 * @since 15/07/2014 - VM (build 2.4, J2RE 1.6.0).
 *
 */
public class NegocioException extends Exception{

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Cria uma nova instancia (objeto) da classe NegocioException.
	 *
	 *
	 * @since 15/07/2014 - Luiz Fernando.
	 */
	public NegocioException() {

	}
	
	/**
	 * Cria uma nova instancia (objeto) da classe NegocioException.
	 *
	 * @param msg
	 * @param e
	 *
	 * @since 15/07/2014 - Luiz Fernando.
	 */
	public NegocioException(String msg, Throwable e) {
		super(msg, e);
	}
}
