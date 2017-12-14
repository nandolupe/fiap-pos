package br.com.fiap.java.view;

/**
 * Import do arquivos externos utilizados na classe
 */
import javax.swing.JOptionPane;

import br.com.fiap.java.util.Util;
/**
 * category Visualização
 * @author Turma Fiap 23SCJ
 */
public class PrincipalView {
	/**
	 * Atributo - PrincipalView
	 */
	public static PrincipalView singleton;

	/**
	 * Construtor private
	 */
	private PrincipalView() {
		super();
	}

	/**
	 * Método getInstance
	 * @return uma instância da classe
	 */
	public static PrincipalView getInstance() {
		if (singleton == null) {
			singleton = new PrincipalView();
		}
		return singleton;
	}

	/**
	 * Método telaInicial
	 */
	public void telaInicial() {
		int valor;
		try {
			valor = Util.converteInt("Digite 1 para (Contatos) \n" + "Digite 2 para (Atividades)");
			if (valor > 2 || valor < 1) {
				JOptionPane.showMessageDialog(null, "Digite 1 ou 2");
				telaInicial();
			}
			switch (valor) {
			case 1:
				ContatoView.getInstance().telaInicial();
				break;
			case 2:
				AtividadeView.getInstance().telaInicial();
				break;
			case 3:
				System.exit(0);
				break;
			}
		} catch (Exception e) {
			telaInicial();
		}
	}
}
