package br.com.fiap.util ;

import net.sf.jasperreports.engine.JasperCompileManager ;

public class JasperCompiler
{

	public static void main( String[ ] args )
	{
		try
		{
			JasperCompileManager.compileReportToFile( "Boleto_subreport1.jrxml", "Boleto_subreport1.jasper" ) ;
			JasperCompileManager.compileReportToFile( "Boleto.jrxml", "Boleto.jasper" ) ;
			System.out.println( "Jasper compilado com sucesso !!!" ) ;
		}
		catch (Exception e)
		{
			e.printStackTrace( ) ;
		}
	}
}
