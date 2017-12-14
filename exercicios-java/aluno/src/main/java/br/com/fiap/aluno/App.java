package br.com.fiap.aluno;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.Log4jEntityResolver;


/**
 * Hello world!
 *
 */
public class App 
{
	private static Logger LOGGER = Logger.getLogger(App.class);
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        LOGGER.debug("Teste");
    }
}
