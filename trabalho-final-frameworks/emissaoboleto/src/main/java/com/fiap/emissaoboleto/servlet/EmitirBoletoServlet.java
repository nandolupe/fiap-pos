package com.fiap.emissaoboleto.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.fiap.emissaoboleto.export.ReportFactory;
import com.fiap.emissaoboleto.export.interfaces.ReportExportInterface;
import com.fiap.emissaoboleto.util.ConfigProperties;

/**
 * Servlet implementation class EmitirBoletoServlet
 */
public class EmitirBoletoServlet extends HttpServlet {

	private final static Logger logger = Logger.getLogger(EmitirBoletoServlet.class);

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public EmitirBoletoServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.debug("Servlet - Emitindo Boleto");
		
		
		try {
			
			// recupera os valores do JSP.
			String nome = request.getParameter("nome");
			String valor = request.getParameter("valor");
			String descricao = request.getParameter("descricao");
			
			// Intancia o arquivo de properties
			ConfigProperties configProperties = ConfigProperties.getInstance();
	        
			// Prepara o mapa com os dados para o Boleto.
	        HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("codigo", "34191690282945517091900827590001124999");
			map.put("nome", nome);
			map.put("codigoBarra", "34191690282945517091900827590001124999");
			map.put("nomeBanco", configProperties.getProperty("nomeBanco"));
			map.put("observacao", descricao);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			map.put("dataDocumento", sdf.format(new Date()));
			
			GregorianCalendar startDate = new GregorianCalendar();
			// Adiciona 1 mês a data corrente para o vencimento.
			startDate.add(Calendar.MONTH, 1);
			
			map.put("dataVencimento", sdf.format(startDate.getTime()));
			map.put("valorDocumento", valor);
			map.put("multa", configProperties.getProperty("multa"));
			map.put("valorCobrado", valor);
			map.put("codigoCedente", configProperties.getProperty("codigoCedente"));
			map.put("especieDoc", configProperties.getProperty("especieDoc"));
			map.put("nossoNumero", configProperties.getProperty("nossoNumero"));
			map.put("sacado", nome);
			map.put("localPagamento", configProperties.getProperty("localPagamento"));
			map.put("cedente", configProperties.getProperty("cedente"));
			map.put("numeroDocumento", "3333");
			map.put("aceite", configProperties.getProperty("aceite"));
			map.put("carteira", configProperties.getProperty("carteira"));
			map.put("moeda", configProperties.getProperty("moeda"));
	
			ServletOutputStream servletOutputStream = response.getOutputStream();
			

			// Faz a chamada para geração do Relatório Jasper.
			ReportExportInterface export = new ReportFactory().createExportBoleto();
			byte[] bytes = export.export(map);
			
			
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

		logger.debug("Servlet - Boleto Emitido");
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
				configProperties.getProperty("export.file"), 
				new SimpleDateFormat("YYYY-MM-dd-HH-mm-ss").format(new Date()), 
				configProperties.getProperty("export.extension.pdf"),
				"\""});
		
		logger.info("Nome do arquivo gerado: " + nameFile);
		
		logger.info("Nome do arquivo de relatório criado!");
		return nameFile;
	}
}
