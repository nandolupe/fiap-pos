package com.exercicios.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exercicios.business.FuncionarioBusinessImpl;
import com.exercicios.datatypes.FuncionarioTO;

/**
 * Servlet implementation class FuncionarioServlet
 */
public class FuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public FuncionarioServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// OBTEM O NOME QUE O USUARIO DIGITOU NO CAMPO "NOME" DO JSP
		String nome = request.getParameter("nome");

		FuncionarioBusinessImpl funcionarioBusinessImpl = new FuncionarioBusinessImpl();
		FuncionarioTO funcionarioTO = new FuncionarioTO();
		funcionarioTO.setNome(nome);

		// FAZ A CHAMADA AO OBJETO BUSINESS DO FUNCIONARIO E OBTEM A LISTA DE FUNCINARIOS PESQUISADOS
		List<FuncionarioTO> list = funcionarioBusinessImpl.pesquisarFuncionarios(funcionarioTO);

		// COLOCA A LISTA DE FUNCIONARIOS NO REQUEST.
		request.setAttribute("funcionarioList", list);

		// O DISPACHER ENVIA OS DADOS PARA O JSP, OU SEJA RETORNA PARA O JSP A REQUISIÇÃO.
		RequestDispatcher dispatcher = request.getRequestDispatcher("teste.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
