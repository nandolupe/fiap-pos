package br.com.fiap.java.servico;

/**
 * Import do arquivos externos utilizados na classe
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import br.com.fiap.java.bean.Atividade;
import br.com.fiap.java.exception.NegocioException;
import br.com.fiap.java.io.AtividadeArquivo;
import br.com.fiap.java.util.Util;

/**
 * @category Serviço
 * @author Turma Fiap 23SCJ
 */
public class ServicoAtividade {
	/**
	 * Atributo - Logger
	 */
	Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * Método salvar - Inclui no arquivo a atividade passada como parâmetro
	 * 
	 * @param atividade - Atividade
	 */
	public void salvar(Atividade atividade) {
		// Seta a nível de permissão
		logger.setLevel(Level.ALL);
		// Escreve no console a msg passada como parâmetro - level INFO
		logger.log(Level.INFO, "Método salvar()");
		//Monta a String a ser incluida no arquivo encima da atividade passada como parâmetro
		StringBuilder sb = new StringBuilder();
		sb.append(Util.dataParaArquivo(atividade.getDataInicio()));
		sb.append(";");
		sb.append(Util.dataParaArquivo(atividade.getDataFim()));
		sb.append(";");
		sb.append(atividade.getNome());
		sb.append(";");
		sb.append(atividade.getLocal());
		// Chama o método controle
		Map<Date, Atividade> mapa = controle();
		// recebe do mapa a atividade com a data inicial
		Atividade atividadeRegistrada = mapa.get(atividade.getDataInicio());
		try {
			// Verifica se a atividade já contém no arquivo
			if (atividadeRegistrada != null) {
				// Verfica se o usuário realmente quer incluir a atividade 
				int resp = JOptionPane
						.showConfirmDialog(null,
								"Este evento já existe na data solicitada! Deseja inclui-lo?");
				if (resp == INCLUIR) {
					// incluir 
					AtividadeArquivo.getInstance().escreverAtividades(
							sb.toString());
				} else {
					// Mensagem informativa
					JOptionPane.showMessageDialog(null, "Evento discartado");
				}
			} else {
				// incluir 
				AtividadeArquivo.getInstance()
						.escreverAtividades(sb.toString());
			}
		} catch (NegocioException e) {
			// Mensagem informativa
			JOptionPane.showMessageDialog(null, e.getMessage());
			// Escreve no console a msg passada como parâmetro - level SEVERE
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	/**
	 * Método listar - Lista do arquivo todas as atividades
	 * 
	 * @return lista de contatos - List<Atividade>
	 */
	public List<Atividade> listar() {
		// Seta a nível de permissão
		logger.setLevel(Level.ALL);
		// Escreve no console a msg passada como parâmetro - level INFO
		logger.log(Level.INFO, "Método listar()");
		List<Atividade> lista = new ArrayList<Atividade>();
		try {
			// Recebe a String retornada do método ler Atividades
			String atividades = AtividadeArquivo.getInstance().lerAtividades();
			// Quebra a String em array separador !@#
			String[] array = atividades.split("!@#");
			//Percorre o array
			for (int x = 0; x < array.length; x++) {
				// Verifica se o conteudo na posição do array é maior que 10 caracters
				if (array[x].length() > 10) {
					// Cria uma String com conteudo do array retirando as quebras de linha
					String trata = array[x].replaceAll("\n", "");
					Atividade c = new Atividade();
					// Quebra a String em array separador ;
					String[] arrayAtividades = trata.split(";");
					// Seta na atividade os valores do array
					c.setDataInicio(Util.isDataOk(arrayAtividades[0]));
					c.setDataFim(Util.isDataOk(arrayAtividades[1]));
					c.setNome(arrayAtividades[2]);
					c.setLocal(arrayAtividades[3]);
					// adiciona na lista
					lista.add(c);
				}
			}
		} catch (NegocioException e) {
			// Mensagem informativa
			JOptionPane.showMessageDialog(null, e.getMessage());
			// Escreve no console a msg passada como parâmetro - level SEVERE
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return lista;
	}

	/**
	 * Método controle - Verifica se já foi incluido a atividade
	 * 
	 * @return mapa de atividades - Map<Date, Atividade>
	 */
	private Map<Date, Atividade> controle() {
		// Seta a nível de permissão
		logger.setLevel(Level.ALL);
		// Escreve no console a msg passada como parâmetro - level INFO
		logger.log(Level.INFO, "Método controle()");
		Map<Date, Atividade> mapa = new HashMap<Date, Atividade>();
		try {
			// Recebe a String retornada do método ler Atividades
			String atividades = AtividadeArquivo.getInstance().lerAtividades();
			// Quebra a String em array separador !@#
			String[] array = atividades.split("!@#");
			//Percorre o array
			for (int x = 0; x < array.length; x++) {
				// Verifica se o conteudo na posição do array é maior que 10 caracters
				if (array[x].length() > 10) {
					// Cria uma String com conteudo do array retirando as quebras de linha
					String trata = array[x].replaceAll("\n", "");
					Atividade c = new Atividade();
					// Quebra a String em array separador ;
					String[] arrayAtividades = trata.split(";");
					// Seta na atividade os valores do array
					c.setDataInicio(Util.isDataOk(arrayAtividades[0]));
					c.setDataFim(Util.isDataOk(arrayAtividades[1]));
					c.setNome(arrayAtividades[2]);
					c.setLocal(arrayAtividades[3]);
					// adiciona no mapa
					mapa.put(c.getDataInicio(), c);
				}
			}
		} catch (NegocioException e) {
			// Mensagem informativa
			JOptionPane.showMessageDialog(null, e.getMessage());
			// Escreve no console a msg passada como parâmetro - level SEVERE
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return mapa;
	}
	/**
	 * Constante INCLUIR - do tipo int valor = 0
	 */
	private static int INCLUIR = 0;
}
