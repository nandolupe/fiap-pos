package br.com.fiap.java.servico;

/**
 * Import do arquivos externos utilizados na classe
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import br.com.fiap.java.bean.Contato;
import br.com.fiap.java.bean.Telefone;
import br.com.fiap.java.bean.TipoTelefone;
import br.com.fiap.java.exception.NegocioException;
import br.com.fiap.java.io.ContatoArquivo;
import br.com.fiap.java.util.ComparadorContato;

/**
 * @category Serviço
 * @author Turma Fiap 23SCJ
 */
public class ServicoContato {
	/**
	 * Atributo - Logger
	 */
	Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * Método salvar
	 * 
	 * @param contato
	 */
	public void salvar(Contato contato) {
		// Seta a nível de permissão
		logger.setLevel(Level.ALL);
		// Escreve no console a msg passada como parâmetro - level INFO
		logger.log(Level.INFO, "Método salvar()");
		//Monta a String a ser incluida no arquivo encima do contato passado como parâmetro
		StringBuilder sb = new StringBuilder();
		sb.append(contato.getNome());
		sb.append(";");
		sb.append(contato.getEmail());
		sb.append(";");
		// Percorre a lista de telefones do contato e adiciona na String
		for (Telefone fone : contato.getTelefones()) {
			sb.append(fone.getTipo().getDescricao());
			sb.append("@");
			sb.append(fone.getNumero());
			sb.append("@");
		}
		try {
			// incluir 
			ContatoArquivo.getInstance().escreverContatos(sb.toString());
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			// Escreve no console a msg passada como parâmetro - level SEVERE
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	/**
	 * Método listarOrdenado
	 * 
	 * @return lista de contatos ordenada
	 */
	public List<Contato> listarOrdenado() {
		// Seta a nível de permissão
		logger.setLevel(Level.ALL);
		// Escreve no console a msg passada como parâmetro - level INFO
		logger.log(Level.INFO, "Método ordenaListar()");
		List<Contato> contatos = listar();
		// Instância a classe ComparadorContato
		ComparadorContato comparadorContato = new ComparadorContato();
		// Utiliza a classe Collections para ordenar
		Collections.sort(contatos, comparadorContato);
		// Retorna os contatos ordenados
		return contatos;
	}

	/**
	 * Método listar
	 * 
	 * @return lista de contatos
	 */
	public List<Contato> listar() {
		// Seta a nível de permissão
		logger.setLevel(Level.ALL);
		// Escreve no console a msg passada como parâmetro - level INFO
		logger.log(Level.INFO, "Método listar()");
		List<Contato> lista = new ArrayList<Contato>();
		try {
			// Recebe a String retornada do método ler Contatos
			String contatos = ContatoArquivo.getInstance().lerContatos();
			// Quebra a String em array separador !@#
			String[] array = contatos.split("!@#");
			//Percorre o array
			for (int x = 0; x < array.length; x++) {
				// Verifica se o conteudo na posição do array é maior que 10 caracters
				if (array[x].length() > 10) {
					Contato c = new Contato();
					// Quebra a String em array separador ;
					String[] contato = array[x].split(";");
					// Seta no contato os valores do array
					c.setNome(contato[0]);
					c.setEmail(contato[1]);
					// Quebra a String em array separador @
					String telefones[] = contato[2].split("@");
					for (int y = 0; y < telefones.length; y++) {
						// Seta o tipo de telefone
						TipoTelefone tipo = null;
						if (y % 2 == 0) {
							if (telefones[y].equalsIgnoreCase("Residencial")) {
								tipo = TipoTelefone.Residencial;
							} else if (telefones[y]
									.equalsIgnoreCase("Comercial")) {
								tipo = TipoTelefone.Comercial;
							} else {
								tipo = TipoTelefone.Celular;
							}
							// Seta o telefone com o respectivo tipo
							Telefone tel = new Telefone(telefones[y + 1], tipo);
							c.setTelefones(tel);
						}
					}
					// Adiciona na lista
					lista.add(c);
				}
			}
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			// Escreve no console a msg passada como parâmetro - level SEVERE
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		// retorna a lista de contatos
		return lista;
	}
}
