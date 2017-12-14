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
 * @category Servi�o
 * @author Turma Fiap 23SCJ
 */
public class ServicoAtividade {
	/**
	 * Atributo - Logger
	 */
	Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * M�todo salvar - Inclui no arquivo a atividade passada como par�metro
	 * 
	 * @param atividade - Atividade
	 */
	public void salvar(Atividade atividade) {
		// Seta a n�vel de permiss�o
		logger.setLevel(Level.ALL);
		// Escreve no console a msg passada como par�metro - level INFO
		logger.log(Level.INFO, "M�todo salvar()");
		//Monta a String a ser incluida no arquivo encima da atividade passada como par�metro
		StringBuilder sb = new StringBuilder();
		sb.append(Util.dataParaArquivo(atividade.getDataInicio()));
		sb.append(";");
		sb.append(Util.dataParaArquivo(atividade.getDataFim()));
		sb.append(";");
		sb.append(atividade.getNome());
		sb.append(";");
		sb.append(atividade.getLocal());
		// Chama o m�todo controle
		Map<Date, Atividade> mapa = controle();
		// recebe do mapa a atividade com a data inicial
		Atividade atividadeRegistrada = mapa.get(atividade.getDataInicio());
		try {
			// Verifica se a atividade j� cont�m no arquivo
			if (atividadeRegistrada != null) {
				// Verfica se o usu�rio realmente quer incluir a atividade 
				int resp = JOptionPane
						.showConfirmDialog(null,
								"Este evento j� existe na data solicitada! Deseja inclui-lo?");
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
			// Escreve no console a msg passada como par�metro - level SEVERE
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	/**
	 * M�todo listar - Lista do arquivo todas as atividades
	 * 
	 * @return lista de contatos - List<Atividade>
	 */
	public List<Atividade> listar() {
		// Seta a n�vel de permiss�o
		logger.setLevel(Level.ALL);
		// Escreve no console a msg passada como par�metro - level INFO
		logger.log(Level.INFO, "M�todo listar()");
		List<Atividade> lista = new ArrayList<Atividade>();
		try {
			// Recebe a String retornada do m�todo ler Atividades
			String atividades = AtividadeArquivo.getInstance().lerAtividades();
			// Quebra a String em array separador !@#
			String[] array = atividades.split("!@#");
			//Percorre o array
			for (int x = 0; x < array.length; x++) {
				// Verifica se o conteudo na posi��o do array � maior que 10 caracters
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
			// Escreve no console a msg passada como par�metro - level SEVERE
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return lista;
	}

	/**
	 * M�todo controle - Verifica se j� foi incluido a atividade
	 * 
	 * @return mapa de atividades - Map<Date, Atividade>
	 */
	private Map<Date, Atividade> controle() {
		// Seta a n�vel de permiss�o
		logger.setLevel(Level.ALL);
		// Escreve no console a msg passada como par�metro - level INFO
		logger.log(Level.INFO, "M�todo controle()");
		Map<Date, Atividade> mapa = new HashMap<Date, Atividade>();
		try {
			// Recebe a String retornada do m�todo ler Atividades
			String atividades = AtividadeArquivo.getInstance().lerAtividades();
			// Quebra a String em array separador !@#
			String[] array = atividades.split("!@#");
			//Percorre o array
			for (int x = 0; x < array.length; x++) {
				// Verifica se o conteudo na posi��o do array � maior que 10 caracters
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
			// Escreve no console a msg passada como par�metro - level SEVERE
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return mapa;
	}
	/**
	 * Constante INCLUIR - do tipo int valor = 0
	 */
	private static int INCLUIR = 0;
}
