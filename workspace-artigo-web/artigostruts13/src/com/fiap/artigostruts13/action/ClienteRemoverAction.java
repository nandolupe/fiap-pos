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
 * Classe responsável em remover um cliente do cadastro
 *
 * @author Luiz Fernando
 */
public class ClienteRemoverAction extends Action {

	/* 
	 * Método responsável em executar a ação.
	 */
	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
	        throws Exception {
	 
			ClienteForm clienteForm = (ClienteForm) form;
			
			// Captura a lista da sessão
			List<Cliente> clienteList = (List<Cliente>) request.getSession().getAttribute("clienteList");
			List<Cliente> clienteRetornoList = new ArrayList<Cliente>();
			
			// Cria uma nova lista sem o objeto que será excluído.
			if (clienteList == null) {
				clienteList = new ArrayList<Cliente>();
			} else {
				for (Cliente cliente : clienteList) {
					if (!cliente.getIdCliente().equals(clienteForm.getIdCliente())) {
						clienteRetornoList.add(cliente);
					}
				}
			}
			
			// adiciona a lista na sessão novamente.
			request.getSession().setAttribute("clienteList", clienteRetornoList);
			clienteForm.resetForm(); 
			
			// retornar para o sucess definido no xml.
			return mapping.findForward("success");
		}
}
