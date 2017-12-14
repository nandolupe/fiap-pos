package br.com.fiap.java.view;

/**
 * Import do arquivos externos utilizados na classe
 */
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.java.bean.Atividade;
import br.com.fiap.java.servico.ServicoAtividade;
import br.com.fiap.java.util.Util;

/**
 * @category Visualização
 * @author Turma Fiap 23SCJ
 */
public class AtividadeView {
	/**
	 * Atributo - ServicoAtividade
	 */
	ServicoAtividade servicoAtividade = new ServicoAtividade();
	/**
	 * Atributo do tipo AtividadeView
	 */
	public static AtividadeView singleton;

	/**
	 * Construtor private
	 */
	private AtividadeView() {
		super();
	}

	/**
	 * Método getInstance
	 * @return uma instância da classe - AtividadeView
	 */
	public static AtividadeView getInstance() {
		// verifica se a instância única da classe esta nula
		if (singleton == null) {
			// Cria uma instância única
			singleton = new AtividadeView();
		}
		// Retorna instância única de AtividadeView
		return singleton;
	}

	/**
	 * Método telaInicial - Monta a tela inicial referente a atividades
	 */
	public void telaInicial() {
		int valor;
		try {
			// Recebe um int do método converteInt
			valor = Util.converteInt("Digite 1 para (Salvar Atividades) \n"
					+ "Digite 2 para (Listar os Atividadess) \n" + "Digite 3 para (Voltar tela pricipal)");
			//Verifica se o valor e maior que 3 ou menor que 1
			if (valor > 3 || valor < 1) {
				// Mostra msg
				JOptionPane.showMessageDialog(null, "Digite 1, 2 ou 3");
				telaInicial();
			}
			switch (valor) {
			case 1:
				//Caso valor 1 chama a tela salvar
				telaSalvar();
				break;
			case 2:
				//Caso valor 1 chama a tela Listar
				telaListar();
				break;
			case 3:
				//Caso valor 1 chama a tela inicial
				PrincipalView.getInstance().telaInicial();
				break;
			}
		} catch (Exception e) {
			// Tela inicial
			telaInicial();
		}
	}

	/**
	 * Método telaSalvar
	 */
	public void telaSalvar() {
		// Cria uma atividade
		Atividade atividade = new Atividade();
		Date inicialDigitado = Util.converteData("Digite a data inicial no fomato dd/mm/aaaa");	
		Date finalDigitado = new Date(0);
		// Enquanto a data inicial for maior que a data final sera solicitado uma nova data
		while(inicialDigitado.getTime() > finalDigitado.getTime()){
			finalDigitado = Util.converteData("Digite a data final no fomato dd/mm/aaaa");
		}	
		// Seta os valores de atividade
		String nomeDigitado = JOptionPane.showInputDialog("Digite o nome para do evento");
		String localDigitado = JOptionPane.showInputDialog("Digite o local do evento");
		atividade.setDataInicio(inicialDigitado);
		atividade.setDataFim(finalDigitado);
		atividade.setNome(nomeDigitado);
		atividade.setLocal(localDigitado);
		// Chama o método onde sera incluso a atividade
		servicoAtividade.salvar(atividade);
		// Chama tela inicial
		telaInicial();
	}

	/**
	 * Método telaListar
	 */
	public void telaListar() {
		// Recebe a lista de atividades
		List<Atividade> lista = servicoAtividade.listar();
		// chama o método imprime
		imprime(lista);
	}

	/**
	 * Método imprime
	 * @param lista
	 */
	private void imprime(List<Atividade> lista) {
		// Prepara a String que será mostrada em MSG
		StringBuilder sb = new StringBuilder("***********************************************");
		sb.append("\n");
		// Percorre a lista adicionando na String
		for (Atividade atividade : lista) {
			sb.append("Data Inicio: ");
			sb.append(Util.dataParaArquivo(atividade.getDataInicio()));
			sb.append("\n");
			sb.append(" Data Fim: ");
			sb.append(Util.dataParaArquivo(atividade.getDataFim()));
			sb.append("\n");
			sb.append(" Nome Evento: ");
			sb.append(atividade.getNome());
			sb.append("\n");
			sb.append(" Local Evento: ");
			sb.append(atividade.getLocal());
			sb.append("\n");
			sb.append("***********************************************");
			sb.append("\n");
		}
		// Mostra 
		JOptionPane.showMessageDialog(null, sb.toString());
		telaInicial();
	}
}
