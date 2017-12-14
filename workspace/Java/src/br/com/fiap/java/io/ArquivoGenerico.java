package br.com.fiap.java.io;

/**
 * Import do arquivos externos utilizados na classe
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.fiap.java.exception.NegocioException;
import br.com.fiap.java.util.Util;

/**
 * @category IO
 * @author Turma Fiap 23SCJ
 */
public abstract class ArquivoGenerico implements IArquivo {
	/**
	 * Atributo - Logger
	 */
	Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * M�todo salvarArquivo - Escreve no arquivo file a linha passados como par�metros
	 * @param file - File
	 * @param linha - String
	 */
	public void salvarArquivo(File file, String linha) throws NegocioException {
		// Seta a n�vel de permiss�o
		logger.setLevel(Level.ALL);
		// Escreve no console a msg passada como par�metro - level INFO
		logger.log(Level.INFO, "M�todo escreverFile");
		FileWriter fw = null;
		BufferedWriter bw = null;
		StringBuilder escreve = new StringBuilder();
		//Concatenado na StringBuilder
		escreve.append(lerArquivo(file));
		escreve.append(linha);
		escreve.append("!@#");
		escreve.append("\n");
		try {
			// Verificando se o file n�o � nulo ou se n�o existe
			if (file != null && !file.exists()) {
				// Escreve no console a msg passada como par�metro - level INFO
				logger.log(Level.INFO, "Criando arquivo " + file.toString());
				// Caso n�o exista cria um arquivo no caminho setado no file
				file.createNewFile();
			}
			// Criando objetos do tipo FileWriter e BufferedWriter
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			// Escreve no console a msg passada como par�metro - level INFO
			logger.log(Level.INFO, "Escrevendo no arquivo " + Util.criptografa(escreve.toString()));
			// Escrevendo no file
			bw.write(Util.criptografa(escreve.toString()));
		} catch (IOException e) {
			// Escreve no console a msg passada como par�metro - level SEVERE
			logger.log(Level.SEVERE, e.getMessage(), e);
			// Lan�a a exce��o para cima
			throw new NegocioException("Cancelado ao Salvar Arquivo: ", e);			
		} finally {
			try {
				// Caso o bw - BufferedWriter esteja conectado, fecha-o
				if (bw != null) {
					bw.close();
				}
				// Caso o fw - FileWriter esteja conectado, fecha-o
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				// Escreve no console a msg passada como par�metro - level SEVERE
				logger.log(Level.SEVERE, e.getMessage(), e);
				// Lan�a a exce��o para cima
				throw new NegocioException("Cancelado ao Salvar Arquivo: ", e);				
			}
		}
	}

	/**
	 * M�todo lerArquivo - L� o conte�do do file passado como par�metros
	 * @param file - File
	 * @return texto - String
	 */
	public String lerArquivo(File file) throws NegocioException {
		// Seta a n�vel de permiss�o
		logger.setLevel(Level.ALL);
		FileReader fr = null;
		BufferedReader br = null;
		StringBuilder retorno = new StringBuilder();
		try {
			// Verificando se o file n�o � nulo ou se n�o existe
			if (file != null && !file.exists()) {
				// Escreve no console a msg passada como par�metro - level INFO
				logger.log(Level.INFO, "Criando arquivo " + file.toString());
				// Caso n�o exista cria um arquivo no caminho setado no file
				file.createNewFile();
			}
			// Criando objetos do tipo FileWriter e BufferedWriter
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			// Escreve no console a msg passada como par�metro - level INFO
			logger.log(Level.INFO, "Lendo arquivo " + file.toString());
			// Lendo do br enquanto houver pr�xima linha
			while (br.ready()) {
				retorno.append(br.readLine());
			}
		} catch (IOException e) {
			// Escreve no console a msg passada como par�metro - level SEVERE
			logger.log(Level.SEVERE, e.getMessage(), e);
			// Lan�a a exce��o para cima
			throw new NegocioException("Cancelado ao Ler Arquivo: ", e);	
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				// Escreve no console a msg passada como par�metro - level SEVERE
				logger.log(Level.SEVERE, e.getMessage(), e);
				// Lan�a a exce��o para cima
				throw new NegocioException("Cancelado ao Ler Arquivo: ", e);	
			}
		}
		// Retorna o texto 
		return Util.decriptografa(retorno.toString());
	}
}
