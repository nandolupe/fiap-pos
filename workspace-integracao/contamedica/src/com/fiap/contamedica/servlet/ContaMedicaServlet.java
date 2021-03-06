package com.fiap.contamedica.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiap.contamedica.business.ContaMedicaBusinessImpl;
import com.fiap.contamedica.entity.AnaliseConta;
import com.fiap.contamedica.entity.ContaMedica;

/**
 * Servlet responsável em fazer a análise da conta.
 * 
 * @author Luiz Fernando
 */
@WebServlet("/ContaMedica")
public class ContaMedicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContaMedicaBusinessImpl contaMedicaBusinessImpl = new ContaMedicaBusinessImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContaMedicaServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String dscPrestador = request.getParameter("dscPrestador");
		String emailPrestador = request.getParameter("emailPrestador");
		Double valorInformado = new Double(request.getParameter("valorInformado"));
		Double valorAcatado = new Double(request.getParameter("valorAcatado"));
		String descricaoContaMedica = request.getParameter("descricaoContaMedica");
		String tipoConta = request.getParameter("tipoConta");

		ContaMedica contaMedica = new ContaMedica(new Random().nextInt(),
				dscPrestador, emailPrestador, valorInformado, valorAcatado,
				descricaoContaMedica, tipoConta);
		
		// CHAMAR QUEUE
		AnaliseConta analiseConta = contaMedicaBusinessImpl.analisarConta(contaMedica);
		request.setAttribute("numProtocolo", analiseConta.getNumProtocolo());
		request.setAttribute("resultadoAnalise", analiseConta.getResultadoAnalise());
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resultadoAnalise.jsp");
		dispatcher.forward(request, response);
	}

}
