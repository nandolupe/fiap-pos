package br.com.fiap.log ;

import org.apache.commons.math.util.MathUtils ;

public class Operacoes
{

	public static void main( String[ ] args )
	{
		int numero = 12 ;
//		calcularFatorial( numero ) ;
		calcularFatorial(-10);
	}

	public static long calcularFatorial( int numero )
	{
		long fatorial = 0 ;
		try
		{
			fatorial = MathUtils.factorial( numero ) ;
		}
		catch (RuntimeException e)
		{
			throw e ;
		}
		return fatorial ;
	}
}
