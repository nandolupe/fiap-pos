package br.com.fiap.java.util;

/**
 * Import do arquivos externos utilizados na classe
 */
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * @category Utilidade
 * @author Turma Fiap 23SCJ
 */
public class Util {
	/**
	 * SimpleDateFormat m�scara de formata��o de data.
	 */
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * M�todo criptografa - Recebe o texto e criptografa
	 * 
	 * @param texto - String
	 * @return texto criptografado - String
	 */
	public static String criptografa(String texto) {
		int cont = 1;
		// Transforma o texto em array de bytes
		byte array[] = texto.getBytes();
		StringBuilder sb = new StringBuilder();
		// Percorre o array de bytes
		for (int x = 0; x < array.length; x++) {
			// adiciona na String o char somado com o valor do cont
			sb.append((char) (array[x] + cont));
			cont++;
			// Controle do cont
			if (cont > 3) {
				cont = 1;
			}
		}
		// Retorna a String com os bytes bagun�ados
		return sb.toString();
	}

	/**
	 * M�todo decriptografa - Recebe o texto e decriptografa
	 * 
	 * @param texto - String
	 * @return texto decriptografado - String
	 */
	public static String decriptografa(String texto) {
		int cont = 1;
		// Transforma o texto em array de bytes
		byte array[] = texto.getBytes();
		StringBuilder sb = new StringBuilder();
		// Percorre o array de bytes
		for (int x = 0; x < array.length; x++) {
			// adiciona na String o char subtraido com o valor do cont
			sb.append((char) (array[x] - cont));
			cont++;
			// Controle do cont
			if (cont > 3) {
				cont = 1;
			}
		}
		// Retorna a String com os bytes acertados
		return sb.toString();
	}

	/**
	 * M�todo isDataOk - Verifica se a data � v�lida
	 * 
	 * @param sData - java.util.Date
	 * @return data - java.util.Date
	 */
	public static Date isDataOk(String sData) {
		Date data = null;
		try {
			data = sdf.parse(sData);
		} catch (Exception e) {
		}
		return data;
	}

	/**
	 * M�todo dataParaArquivo - Transforma a data tipo Date em String
	 * 
	 * @param data - java.util.Date
	 * @return data - String
	 */
	public static String dataParaArquivo(Date data) {
		return sdf.format(data);
	}

	/**
	 * M�todo converteData - M�todo que cria a data 
	 * @param msg - String
	 * @return data - java.util.Date
	 */
	public static Date converteData(String msg) {
		Date data = null;
		String sData = "";
		// Enquanto a data n�o for v�lida ser� solicitado uma data ao usu�rio
		while (data == null) {
			sData = JOptionPane.showInputDialog(msg);
			data = Util.isDataOk(sData);
		}
		//Retorna a data v�lida
		return data;
	}

	/**
	 * M�todo converteInt - Converte a msg do usu�rio para inteiro
	 * @param msg - String
	 * @return valor - int
	 */
	public static int converteInt(String msg) {
		int ret = 0;
		while (ret == 0) {
			// Mostra a msg passada por par�metro
			String sTipo = JOptionPane.showInputDialog(msg);
			try {
				if (sTipo == null) {
					JOptionPane.showMessageDialog(null,
							"Cancelado pelo usu�rio.");
					System.exit(0);
				}
				ret = Integer.parseInt(sTipo);
			} catch (Exception e) {
				ret = 0;
			}
		}
		return ret;
	}
}
