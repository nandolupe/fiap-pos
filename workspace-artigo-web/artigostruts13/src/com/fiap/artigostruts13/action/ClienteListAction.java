package com.fiap.artigostruts13.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.fiap.artigostruts13.form.ClienteForm;

/**
 * Classe responsável em listar os clientes no cadastro
 * 
 * @author Luiz Fernando
 */
public class ClienteListAction extends Action {
	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
	        throws Exception {
	 
			ClienteForm clienteForm = (ClienteForm) form;
			
			return mapping.findForward("success");
		}
}
