package com.fiap.contamedica.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Classe respons�vel em carregar os propeties default da aplica��o.
 * 
 * @author Luiz Fernando
 *
 */
public class PropertiesUtil {
	
	private static Properties properties = new Properties();
	
	static {

		try {
			InputStream input = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties");
			
			// load a properties file
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Respons�vel em obter uma propriedade do arquivo de configura��o.
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	/**
	 * M�todo que retornar o arquivo de properties inteiro.
	 * 
	 * @return
	 */
	public static Properties getProperties() {
		return properties;
	}
}