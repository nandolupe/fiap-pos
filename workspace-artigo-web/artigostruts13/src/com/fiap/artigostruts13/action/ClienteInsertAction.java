package com.fiap.artigostruts13.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.fiap.artigostruts13.entity.Cliente;
import com.fiap.artigostruts13.form.ClienteForm;

/**
 * Classe respons�vel em Inserir um cliente no cadastro
 * @author Luiz Fernando
 *
 */
public class ClienteInsertAction extends Action {
	
	/* 
	 * M�todo respons�vel em executar a a��o.
	 */
	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
	        throws Exception {
	 
			ClienteForm clienteForm = (ClienteForm) form;
			
			// Captura a lista da sess�o.
			List<Cliente> clienteList = (List<Cliente>) request.getSession().getAttribute("clienteList");

			if (clienteList == null) {
				clienteList = new ArrayList<Cliente>();
			}
			
			// Adiciona o cliente na lista
			clienteList.add(clienteForm.doCliente());
			
			// Devolve a lista atualizada para o JSP.
			request.getSession().setAttribute("clienteList", clienteList);
			clienteForm.resetForm();
			
			// retorna para o success que est� configurado no xml.
			return mapping.findForward("success");
		}
}
