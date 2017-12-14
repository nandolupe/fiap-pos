package br.com.fiap.servlet ;

import java.io.IOException ;
import java.io.PrintWriter ;

import javax.servlet.ServletException ;
import javax.servlet.http.HttpServlet ;
import javax.servlet.http.HttpServletRequest ;
import javax.servlet.http.HttpServletResponse ;

import br.com.fiap.impressora.ImpressoraUtil ;
import br.com.fiap.relatorio.RelatorioUtil ;

public class RelatorioServlet extends HttpServlet
{
	public RelatorioServlet( )
	{
		super( ) ;
	}

	protected void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
	}

	protected void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		response.setContentType( "text/html" ) ;

		String acao = request.getParameter( "acao" ) ;

		PrintWriter out = response.getWriter( ) ;

		if ("gerarRelatorio".equals( acao ))
		{

			try
			{
				RelatorioUtil.gerarRelatorioPDF( ) ;
				out.println( "Relatório PDF gerado com sucesso" ) ;
			}
			catch (Exception e)
			{
				out.print( "Erro ao gerar relatório: " + e.getMessage( ) ) ;
				e.printStackTrace( ) ;
			}
			finally
			{
				out.flush( ) ;
				out.close( ) ;
			}

		}
		else if ("imprimirRelatorios".equals( acao ))
		{
			try
			{
				ImpressoraUtil.gerarPostScript( ) ;
				ImpressoraUtil.simulaImpressao( ) ;
				out.println( "Impressão de relatórios finalizada com sucesso" ) ;
			}
			catch (Exception e)
			{
				out.print( "Erro ao imprimir relatórios: " + e.getMessage( ) ) ;
				e.printStackTrace( ) ;
			}
			finally
			{
				out.flush( ) ;
				out.close( ) ;
			}
		}

	}

}
