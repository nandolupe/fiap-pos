package br.com.fiap.mensagemjava.view;

/**
 * Classe <code>Executavel</code>.
 * 
 * Classe responsável em executar a aplicação, inicia a tela principal.
 *
 * @category br.com.fiap.mensagemjava.view.
 *
 * @author Luiz Fernando
 *
 * @since 15/07/2014 - VM (build 2.4, J2RE 1.6.0).
 *
 */
public class Executavel {
	
	/**
	 * Método main, método de inicialização da aplicação.
	 *
	 * @param args
	 *
	 * @since 15/07/2014 - Luiz Fernando
	 */
	public static void main(String[] args) {
		MensagemView.getInstance().telaInicial();
	}
}
