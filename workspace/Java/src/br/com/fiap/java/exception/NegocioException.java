package br.com.fiap.java.exception;

/**
 * @category Exception
 * @author Turma Fiap 23SCJ
 */
public class NegocioException extends Exception{

	/**
	 * Id default
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor default
	 */
	public NegocioException() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Construtor sobrecarregado
	 */
	public NegocioException(String msg, Throwable e) {
		super(msg, e);
	}
}
