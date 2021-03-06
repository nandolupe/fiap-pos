package br.com.fiap.mensagemjava.view;

import javax.swing.JOptionPane;

import br.com.fiap.mensagemjava.servico.ServicoMensagem;
import br.com.fiap.mensagemjava.util.Util;

/**
 * Classe <code>MensagemView</code>.
 *
 * Classe respons�vel em apresentar as telas com as funcionalidades de Mensagem.
 *
 * @category br.com.fiap.mensagemjava.view.
 *
 * @author Luiz Fernando
 *
 * @since 15/07/2014 - VM (build 2.4, J2RE 1.6.0).
 *
 */
public class MensagemView {

	ServicoMensagem servicoMensagem = new ServicoMensagem();

	public static MensagemView singleton;

	/**
	 * Cria uma nova instancia (objeto) da classe MensagemView.
	 *
	 *
	 * @since 15/07/2014 - Luiz Fernando.
	 */
	private MensagemView() {
		super();
	}

	/**
	 * Metodo getInstance.
	 *
	 * @return
	 *
	 * @since 15/07/2014 - Luiz Fernando
	 */
	public static MensagemView getInstance() {
		if (singleton == null) {
			singleton = new MensagemView();
		}
		return singleton;
	}

	/**
	 * Metodo telaInicial, executa a tela inicial da aplica��o.
	 *
	 *
	 * @since 15/07/2014 - Luiz Fernando
	 */
	public void telaInicial() {
		int valor;
		try {
			valor = Util.converteInt("Digite 1 para (Codificar a Mensagem) \n"
					+ "Digite 2 para (Decodificar a Mensagem) \n" + "Digite 3 para (Sair)");
			if (valor > 3 || valor < 1) {
				JOptionPane.showMessageDialog(null, "Digite 1, 2 ou 3");
				telaInicial();
			}
			switch (valor) {
			case 1:
				telaCodificar();
				break;
			case 2:
				telaDecodificar();
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Cancelado pelo Usu�rio!");
				System.exit(0);
				break;
			}
		} catch (Exception e) {
			telaInicial();
		}
	}

	/**
	 * Metodo telaCodificar, inicia a tela de codifica��o de mensagem.
	 *
	 *
	 * @since 15/07/2014 - Luiz Fernando
	 */
	public void telaCodificar() {
		String mensagemDigitada = JOptionPane.showInputDialog("Digite a mensagem a ser codificada: ");
		servicoMensagem.codificar(mensagemDigitada);
		JOptionPane.showMessageDialog(null, "Mensagem codificada com sucesso!");
		telaInicial();
	}
	
	/**
	 * Metodo telaDecodificar, inicia a tela de decodifica��o de mensagem.
	 *
	 *
	 * @since 15/07/2014 - Luiz Fernando
	 */
	public void telaDecodificar() {
		String caminhoDigitado = JOptionPane.showInputDialog("Caminho do arquivo a ser decodificado: ");
		String mensagemDecodificada = servicoMensagem.decodificar(caminhoDigitado);
		
		JOptionPane.showMessageDialog(null, "Mensagem Decodificada: " + mensagemDecodificada);
		
		telaInicial();
	}
}
