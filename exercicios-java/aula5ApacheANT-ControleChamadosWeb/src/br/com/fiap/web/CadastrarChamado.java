package br.com.fiap.web;

import java.io.IOException ;

import javax.servlet.ServletException ;
import javax.servlet.ServletRequest ;
import javax.servlet.ServletResponse ;
import javax.servlet.http.HttpServletRequest ;
import javax.servlet.http.HttpServletResponse ;

import br.com.fiap.persistencia.jdbc.ChamadosHelper ;

/**
 * Servlet implementation class for Servlet: ListarQuestionarios
 * 
 */
public class CadastrarChamado extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6335028593685656282L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public CadastrarChamado() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String descricao = request.getParameter("descricao");
		ChamadosHelper chamadosHelper = new ChamadosHelper();

		try {
			System.out.println("Cadastrando chamado...");
			chamadosHelper.criarChamado(descricao);
			response.sendRedirect("cadastrok.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("erro.jsp");
		}
		
	}

	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}
}