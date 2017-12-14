package br.com.fiap.java.view;

/**
 * Import do arquivos externos utilizados na classe
 */
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.java.bean.Contato;
import br.com.fiap.java.bean.Telefone;
import br.com.fiap.java.bean.TipoTelefone;
import br.com.fiap.java.servico.ServicoContato;
import br.com.fiap.java.util.Util;

/**
 * category Visualização
 * @author Turma Fiap 23SCJ
 */
public class ContatoView {
	/**
	 * Atributo - ServicoContato
	 */
	ServicoContato servicoContato = new ServicoContato();
	/**
	 * Atributo do tipo AtividadeView
	 */
	public static ContatoView singleton;

	/**
	 * Construtor private
	 */
	private ContatoView() {
		super();
	}

	/**
	 * Método getInstance
	 * @return uma instância da classe
	 */
	public static ContatoView getInstance() {
		if (singleton == null) {
			singleton = new ContatoView();
		}
		return singleton;
	}

	/**
	 * Método telaInicial
	 */
	public void telaInicial() {
		int valor;
		try {
			valor = Util.converteInt("Digite 1 para (Salvar Contato) \n" + "Digite 2 para (Listar os Contatos) \n"
					+ "Digite 3 para (Listar os Contatos Ordenados) \n" + "Digite 4 para (Voltar tela pricipal)");
			if (valor > 4 || valor < 1) {
				JOptionPane.showMessageDialog(null, "Digite 1, 2 , 3 ou 4");
				telaInicial();
			}
			switch (valor) {
			case 1:
				telaSalvar();
				break;
			case 2:
				telaListar();
				break;
			case 3:
				telaListarOrdenado();
				break;
			case 4:
				PrincipalView.getInstance().telaInicial();
				break;
			}
		} catch (Exception e) {
			telaInicial();
		}
	}

	/**
	 * Método telaSalvar
	 */
	public void telaSalvar() {
		Contato contato = new Contato();
		String nomeDigitado = JOptionPane.showInputDialog("Digite o nome do contato");
		String emailDigitado = JOptionPane.showInputDialog("Digite o email do contato");
		contato.setNome(nomeDigitado);
		contato.setEmail(emailDigitado);
		int qtd = Util.converteInt("Digite a quantidade de telefones");
		for (int x = 0; x < qtd; x++) {
			contato.setTelefones(telaTelefones());
		}
		servicoContato.salvar(contato);
		telaInicial();
	}

	/**
	 * Método telaListar
	 */
	public void telaListar() {
		List<Contato> lista = servicoContato.listar();
		imprime(lista);
	}

	/**
	 * Método telaListarOrdenado
	 */
	public void telaListarOrdenado() {
		List<Contato> lista = servicoContato.listarOrdenado();
		imprime(lista);
	}

	/**
	 * Método imprime
	 * @param lista
	 */
	private void imprime(List<Contato> lista) {
		StringBuilder sb = new StringBuilder("***********************************************");
		sb.append("\n");
		for (Contato contato : lista) {
			sb.append("Nome: ");
			sb.append(contato.getNome().replaceAll("\n", ""));
			sb.append("\n");
			sb.append(" Email: ");
			sb.append(contato.getEmail());
			sb.append("\n");
			sb.append("---------- Telefones ----------");
			sb.append("\n");
			for (Telefone fone : contato.getTelefones()) {
				sb.append(fone.getTipo());
				sb.append(": ");
				sb.append(fone.getNumero());
				sb.append("\n");
			}
			sb.append("***********************************************");
			sb.append("\n");
		}
		JOptionPane.showMessageDialog(null, sb.toString());
		telaInicial();
	}

	/**
	 * Método telaTelefones
	 */
	private Telefone telaTelefones() {
		Telefone telefones = null;
		TipoTelefone tipo = null;
		String numero = JOptionPane.showInputDialog("Digite o numero do telefone");
		int iTipo = Util
				.converteInt("Digite 1 para Residenciual \n Digite 2 para Comercial \n Digite 3 para Celular");
		switch (iTipo) {
		case 1:
			tipo = TipoTelefone.Residencial;
			break;
		case 2:
			tipo = TipoTelefone.Comercial;
			break;
		case 3:
			tipo = TipoTelefone.Celular;
			break;
		default:
			tipo = TipoTelefone.Residencial;
			break;
		}
		telefones = new Telefone(numero, tipo);
		return telefones;
	}
}
