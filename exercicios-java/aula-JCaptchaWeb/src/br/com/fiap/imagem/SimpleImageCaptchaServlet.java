package br.com.fiap.imagem ;

import java.io.IOException ;

import javax.imageio.ImageIO ;
import javax.servlet.ServletException ;
import javax.servlet.ServletOutputStream ;
import javax.servlet.http.HttpServlet ;
import javax.servlet.http.HttpServletRequest ;
import javax.servlet.http.HttpServletResponse ;

import com.octo.captcha.service.CaptchaServiceException ;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService ;
import com.octo.captcha.service.image.ImageCaptchaService ;

public class SimpleImageCaptchaServlet extends HttpServlet
{

	public static ImageCaptchaService service = new DefaultManageableImageCaptchaService() ;

	public SimpleImageCaptchaServlet( )
	{
		super( ) ;
	}

	protected void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		ServletOutputStream out ;

		response.setDateHeader( "Expires", 0L ) ;
		response.setHeader( "Cache-Control", "no-store, no-cache, must-revalidate" ) ;
		response.addHeader( "Cache-Control", "post-check=0, pre-check=0" ) ;
		response.setHeader( "Pragma", "no-cache" ) ;

		response.setContentType( "image/jpeg" ) ;
		//response.setContentType( "text/html" ) ;
		
		String sessId = request.getSession(true).getId();
		System.out.println("SessID ="+sessId);

		java.awt.image.BufferedImage bi = service.getImageChallengeForID( sessId ) ;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out = response.getOutputStream( ) ;
		ImageIO.write( bi, "jpg", out ) ;
		
		out.flush( ) ;
		out.close( ) ;
	}

	public static boolean validateResponse( HttpServletRequest request, String userCaptchaResponse )
	{
		if (request.getSession( false ) == null)
		{
			return false ;
		}
		boolean validated = false ;

		try
		{
			validated = service.validateResponseForID( request.getSession( ).getId( ),
					userCaptchaResponse ).booleanValue( ) ;
		}
		catch (CaptchaServiceException e)
		{
			e.printStackTrace( ) ;
		}

		return validated ;
	}

}
