package com.exercicio.acessodb.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exercicio.acessodb.to.UsuarioTO;

/**
 * Classe responsável em persistir as informações da tabela FUNCIONARIO
 * 
 * @author Luiz Fernando
 *
 */
public class UsuarioDAO extends BaseDAO {
	
	/**
	 * Método responsável em listar todos os registros de Funcionario.
	 * 
	 * @return
	 */
	public List<UsuarioTO> findAll() {
		
		// CRIANDO A QUERY NUMA STRING EQUIVALE: SELECT ID_USUARIO, NM_USUARIO, LOGIN, PASSWORD FROM FUNCIONARIO
		StringBuffer query = new StringBuffer();
		query.append("SELECT ");
		query.append("	ID_USUARIO ");
		query.append(",	NM_USUARIO ");
		query.append(", LOGIN ");
		query.append(", PASSWORD ");
		query.append("FROM ");
		query.append("	FUNCIONARIO ");
		
		// INICIALIZANDO AS VARIAVEIS
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UsuarioTO> usuarioTOList = null;
		
		try {
			
			// CRIA A CONEXÃO COM O BANCO DE DADOS
			connection = createConnection();
			
			// PREAPARA A QUERY PARA SER EXECUTADA
			ps = connection.prepareStatement(query.toString());
			
			// EXECUTA A QUERY NO BANCO DE DADOS E OBTEM O RESULTADO
			rs = ps.executeQuery();
			
			usuarioTOList = new ArrayList<>();
			UsuarioTO usuarioTO = null;
			
			// OBTEM REGISTRO A REGISTRO DO RESULTADO DA QUERY
			while (rs.next()) {
				
				// CRIA UM NOVO OBJETO USUARIOTO
				usuarioTO = new UsuarioTO();
				usuarioTO.setIdUsuario(rs.getInt("ID_USUARIO"));
				usuarioTO.setLogin(rs.getString("LOGIN"));
				usuarioTO.setNmUsuario(rs.getString("NM_USUARIO"));
				usuarioTO.setPassword(rs.getString("PASSWORD"));
				
				// ADICIONA O OBJETO USUARIOTO NA LISTA
				usuarioTOList.add(usuarioTO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// FECHA A CONEXÃO COM O BANCO DE DADOS EM CASO DE SUCESSO OU ERRO.
			closeConnection(rs, ps, connection);
		}
		
		// RETORNA A LISTA PREENCHIDA COM TODOS OS USUARIOS NO BANCO.
		return usuarioTOList;
	}
}
