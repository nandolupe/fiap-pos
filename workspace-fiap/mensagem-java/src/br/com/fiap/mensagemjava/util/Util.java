package br.com.fiap.mensagemjava.util;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

/**
 * Classe <code>Util</code>.
 *
 * Respons�vel em contemplar todas as funcionalidades comuns na aplica��o
 * 
 * @category br.com.fiap.mensagemjava.util.
 *
 * @author Luiz Fernando
 *
 * @since 15/07/2014 - VM (build 2.4, J2RE 1.6.0).
 *
 */
public class Util {
	
	/*
	 * Map que cont�m as vogais convertidas em numerico.
	 */
	private static Map<Integer, Integer> vogaisNumericoMap = new HashMap<>();
	/*
	 * .
	 * Map que cont�m os numericos convertidos em vogais.
	 */
	private static Map<Integer, Integer> numericoVogaisMap = new HashMap<>();
	
	/*
	 * 
	 * Static respons�vel em inicializar os maps com os valores das vogais e numericos.
	 */
	static {
		vogaisNumericoMap.put(97, 49);
		vogaisNumericoMap.put(101, 50);
		vogaisNumericoMap.put(105, 51);
		vogaisNumericoMap.put(111, 52);
		vogaisNumericoMap.put(117, 53);
		
		numericoVogaisMap.put(49, 97);
		numericoVogaisMap.put(50, 101);
		numericoVogaisMap.put(51, 105);
		numericoVogaisMap.put(52, 111);
		numericoVogaisMap.put(53, 117);
	}
	
	/**
	 * M�todo criptografar, respons�vel em criptografar uma mensagem.
	 * Regras:
	 * - Transforma as vogais em num�ricos (a=1, e=2, i=3, o=4, u=5)
	 * - Transforma as consoantes convertendo seu c�digo ASCII + 6
	 *
	 * @param texto
	 * @return
	 *
	 * @since 15/07/2014 - Luiz Fernando
	 */
	public static String criptografar(String texto) {
		
		byte array[] = texto.getBytes();
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < array.length; x++) {
			
			if (vogaisNumericoMap.get(new Integer(array[x])) != null) {
				sb.append((char) vogaisNumericoMap.get(new Integer(array[x])).intValue());
			} else {
				sb.append((char) new Integer(array[x] + 6).intValue());
			}
		}
		return sb.toString();
	}

	/**
	 * Metodo descriptografar, respons�vel em descriptografar uma mensagem.
	 * - Transforma os num�ricos em vogais (1=a, 2=e, 3=i, 4=o, 5=u)
     * - Transforma as consoantes convertendo seu c�digo ASCII - 6
     * 
	 * @param texto
	 * @return
	 *
	 * @since 15/07/2014 - Luiz Fernando
	 */
	public static String descriptografar(String texto) {
		byte array[] = texto.getBytes();
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < array.length; x++) {
			if (numericoVogaisMap.get(new Integer(array[x])) != null) {
				sb.append((char) numericoVogaisMap.get(new Integer(array[x])).intValue());
			} else {
				sb.append((char) new Integer(array[x] - 6).intValue());
			}
		}
		return sb.toString();
	}

	/**
	 * Metodo converteInt, respons�vel em converter uma String em um int.
	 *
	 * @param msg
	 * @return
	 *
	 * @since 15/07/2014 - Luiz Fernando
	 */
	public static int converteInt(String msg) {
		int ret = 0;
		while (ret == 0) {
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
