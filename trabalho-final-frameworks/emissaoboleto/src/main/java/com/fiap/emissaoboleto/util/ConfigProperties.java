package com.fiap.emissaoboleto.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Objeto Singleton respons�vel em obter as propriedades 
 * padr�es da aplica��o
 * 
 * @author Luiz
 *
 */
public class ConfigProperties {

	private static Properties prop = null;
	private static ConfigProperties instance = null;
	
	/**
	 * Singleton para manter a mesma inst�ncia do objeto em mem�ria.
	 * 
	 * @return
	 */
	public static ConfigProperties getInstance() {
		if (instance == null) {
			instance = new ConfigProperties();
		}
		return instance;
	}
	
	/**
	 * Construtor default privado, para impedir a utiliza��o da constru��o do 
	 * objeto sem ser pelo m�todo est�tico getInstance()
	 */
	private ConfigProperties() {
		InputStream input = null;
		try {

			input = new FileInputStream("src/main/resources/config.properties");

			// load a properties file
			prop = new Properties();
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * M�todo respons�vel em obter um property do arquivo.
	 * 
	 * @param key
	 * @return
	 */
	public String getProperty(String key) {
		return prop.getProperty(key);
	}
}
