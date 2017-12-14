package br.com.fiap.log ;

import org.apache.commons.math.util.MathUtils ;
import org.apache.log4j.Appender ;
import org.apache.log4j.ConsoleAppender ;
import org.apache.log4j.Logger ;
import org.apache.log4j.PatternLayout ;

public class Operacoes
{
	private static Logger log = Logger.getLogger( Operacoes.class ) ;

	public static void main( String[ ] args )
	{
		// configuracao console appender
		PatternLayout patternLayout = new PatternLayout( ) ;
		patternLayout.setConversionPattern( "[%d{ISO8601}] %-5p %m %n" ) ;
		ConsoleAppender consoleAppender = new ConsoleAppender( patternLayout ) ;
		Appender appender = consoleAppender ;
		log.addAppender( appender ) ;

		int numero = 12 ;
		log.info( "Calculando fatorial de " + numero ) ;
		calculaFatorial( numero ) ;
	}

	public static long calculaFatorial( int numero )
	{
		log.debug( "Obtendo número " + numero ) ;
		long fatorial = 0 ;
		try
		{
			log.debug( "Executando cálculo" ) ;
			fatorial = MathUtils.factorial( numero ) ;
			log.debug( "Calculo efetuado" ) ;
		}
		catch (RuntimeException e)
		{
			log.error( e ) ;
			throw e ;
		}
		log.debug( "Fatorial obtido: " + fatorial ) ;
		return fatorial ;
	}

}
