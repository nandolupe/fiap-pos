package com.fiap.emissaoboleto.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.fiap.emissaoboleto.entity.Boleto;
import com.fiap.emissaoboleto.export.ReportFactory;
import com.fiap.emissaoboleto.export.interfaces.ReportExportInterface;
import com.fiap.emissaoboleto.util.ConfigProperties;

/**
 * Servlet implementation class EmitirRelatorioCompleto
 */
public class EmitirRelatorioCompletoServlet extends HttpServlet {
	
	private final static Logger logger = Logger.getLogger(EmitirRelatorioCompletoServlet.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmitirRelatorioCompletoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Boleto> lista = (ArrayList<Boleto>) request.getSession().getAttribute("lista");
		
		try {
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("lista", lista);
			
			// Realiza a chamada do relatório, fazendo a utilização do Abstract Factory.
			ReportExportInterface export = new ReportFactory().createExportRelatorioCompleto();
			byte[] bytes = export.export(map);
			
			ServletOutputStream servletOutputStream = response.getOutputStream();
			// adiciona ao header o tipo e o nome do arquivo exportado, isso 
			// faz com que o browser faça o download do arquivo.
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", createNameFile());
			response.setContentLength(bytes.length);
	
			servletOutputStream.write(bytes, 0, bytes.length);
			servletOutputStream.flush();
			servletOutputStream.close();
			
		} catch (Exception e) {
			logger.error("Erro ao gerar relatório!");
		}
	}
	
	/**
	 * Método responsável em criar o nome do arquivo seguindo o pattern do
	 * negócio.
	 * 
	 * Esse método Utiliza Apache Commons(vide comentário no trecho de código)
	 * 
	 * @return
	 */
	private String createNameFile() {
		logger.info("Criando nome do arquivo de relatório.");

		String nameFile = "";

		ConfigProperties configProperties = ConfigProperties.getInstance();
		
		/*Na linha abaixo, é utilizado a classe StringUtils, do commons lang, 
		 * mais especificamente o método join(), que nos facilita a concatenação 
		 * de Strings sem a utilização do operador matemático "+", com isso deixando 
		 * o código mais limpo e performático.
		 */
		
		nameFile = StringUtils.join(new Object[] {
				"filename=\"", 
				configProperties.getProperty("export.relatoriocompleto.file"), 
				new SimpleDateFormat("YYYY-MM-dd-HH-mm-ss").format(new Date()), 
				configProperties.getProperty("export.extension.pdf"),
				"\""});
		
		logger.info("Nome do arquivo gerado: " + nameFile);
		
		logger.info("Nome do arquivo de relatório criado!");
		return nameFile;
	}
}
