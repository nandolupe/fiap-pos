package br.com.fiap.mensagemjava.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.fiap.mensagemjava.exception.NegocioException;
import br.com.fiap.mensagemjava.util.Util;

/**
 * Classe <code>ArquivoGenerico</code>.
 *
 * Classe abstrata respons�vel em ter as funcionalidades padr�es para leitura e cria��o de arquivos.
 * 
 * @category br.com.fiap.mensagemjava.io.
 *
 * @author Luiz Fernando
 *
 * @since 15/07/2014 - VM (build 2.4, J2RE 1.6.0).
 *
 */
public abstract class ArquivoGenerico implements IArquivo {

	Logger logger = Logger.getLogger(this.getClass().getName());

	public void salvarArquivo(File file, String linha) throws NegocioException {
		logger.setLevel(Level.ALL);
		logger.log(Level.INFO, "M�todo escreverFile");
		FileWriter fw = null;
		BufferedWriter bw = null;
		StringBuilder escreve = new StringBuilder();
		//escreve.append(lerArquivo(file));
		escreve.append(linha);
		try {
			if (file != null && !file.exists()) {
				logger.log(Level.INFO, "Criando arquivo " + file.toString());
				file.createNewFile();
			}
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			logger.log(Level.INFO, "Escrevendo no arquivo " + Util.criptografar(escreve.toString()));
			bw.write(Util.criptografar(escreve.toString()));
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			throw new NegocioException("Cancelado ao Salvar Arquivo: ", e);			
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				logger.log(Level.SEVERE, e.getMessage(), e);
				throw new NegocioException("Cancelado ao Salvar Arquivo: ", e);				
			}
		}
	}

	public String lerArquivo(File file) throws NegocioException {
		logger.setLevel(Level.ALL);
		FileReader fr = null;
		BufferedReader br = null;
		StringBuilder retorno = new StringBuilder();
		try {
			if (file != null && !file.exists()) {
				file.createNewFile();
			}
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			logger.log(Level.INFO, "Lendo arquivo " + file.toString());
			while (br.ready()) {
				retorno.append(br.readLine());
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			throw new NegocioException("Arquivo n�o encontrado!", e);	
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				logger.log(Level.SEVERE, e.getMessage(), e);
				throw new NegocioException("Arquivo n�o encontrado!", e);	
			}
		}
		return Util.descriptografar(retorno.toString());
	}
}
