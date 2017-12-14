package br.com.fiap ;

import java.io.IOException ;

import javax.servlet.ServletException ;
import javax.servlet.http.HttpServlet ;
import javax.servlet.http.HttpServletRequest ;
import javax.servlet.http.HttpServletResponse ;

import br.com.fiap.imagem.SimpleImageCaptchaServlet ;

public class Teste extends HttpServlet
{

	protected void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{

		String userCaptchaResponse = request.getParameter( "jcaptcha" ) ;
		boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse( request,
				userCaptchaResponse ) ;

		if (captchaPassed)
		{
			response.getWriter( ).write( "captcha Ok" ) ;
		}
		else
		{
			response.getWriter( ).write( "captcha falhou!" ) ;
			response.getWriter( ).write( "<br/><a href='index.jsp'>Tente novamente.</a>" ) ;
		}
	}
}
