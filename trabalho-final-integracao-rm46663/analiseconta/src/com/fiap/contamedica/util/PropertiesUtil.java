package com.fiap.contamedica.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Classe responsável em carregar os propeties default da aplicação.
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
	 * Responsável em obter uma propriedade do arquivo de configuração.
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	/**
	 * Método que retornar o arquivo de properties inteiro.
	 * 
	 * @return
	 */
	public static Properties getProperties() {
		return properties;
	}
}
