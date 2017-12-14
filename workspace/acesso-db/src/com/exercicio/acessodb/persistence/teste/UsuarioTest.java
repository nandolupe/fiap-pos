package com.exercicio.acessodb.persistence.teste;

import java.util.List;

import com.exercicio.acessodb.persistence.UsuarioDAO;
import com.exercicio.acessodb.to.UsuarioTO;

/**
 * Classe responsável em Testar a UsuarioDAO.
 * 
 * @author Luiz Fernando
 *
 */
public class UsuarioTest {

	public static void main(String[] args) {
		
		UsuarioDAO dao = new UsuarioDAO();
		List<UsuarioTO> usuarioList = dao.findAll();
		
		if (usuarioList != null && usuarioList.size() > 0) {
			for (UsuarioTO usuarioTO : usuarioList) {
				System.out.println(usuarioTO.getIdUsuario());
				System.out.println(usuarioTO.getNmUsuario());
			}
		}
	}

}
