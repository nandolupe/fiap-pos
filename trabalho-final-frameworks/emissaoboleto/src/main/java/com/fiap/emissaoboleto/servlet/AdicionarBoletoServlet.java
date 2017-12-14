package com.fiap.emissaoboleto.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiap.emissaoboleto.entity.Boleto;

/**
 * Servlet implementation class AdicionarBoleto
 */
public class AdicionarBoletoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Boleto> lista = new ArrayList<Boleto>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarBoletoServlet() {
        super();
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
		
		String nomeCliente = request.getParameter("nomeCliente");
		String valorDocumento = request.getParameter("valorDocumento");
		String descricaoDetalhe = request.getParameter("descricaoDetalhe");
		lista = (ArrayList<Boleto>) request.getSession().getAttribute("lista");
		
		if (lista == null) {
			lista = new ArrayList<Boleto>();
		}
		
		Boleto boleto = new Boleto(lista.size()+1, nomeCliente, Double.parseDouble(valorDocumento), descricaoDetalhe);
		lista.add(boleto);
		
		request.getSession().setAttribute("lista", lista);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
