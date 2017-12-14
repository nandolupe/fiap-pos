package br.com.fiap.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.persistencia.common.Chamado ;

public class ChamadosHelper {

	
	/**
	 * Cria uma chamado no sistema de controle
	 * 
	 * @param descricao - descricao do chamado
	 * @throws Exception - Exceção
	 */
	public void criarChamado(String descricao) throws Exception {
		ChamadosDBManager DBManager = new ChamadosDBManager();
		Connection conexao = DBManager.obterConexaoMySQLDataSource();
		String sql = "INSERT INTO chamados (descricao1) VALUES (?)";
		PreparedStatement preparedStatement = conexao.prepareStatement(sql);
		preparedStatement.setString(1, descricao);
		preparedStatement.execute();
		preparedStatement.close();
		conexao.close();
	}

	
	/**
	 * Obtem chamado por código.
	 * 
	 * @param id - id do chamado
	 * @return ChamadoVO - chamado
	 * @throws Exception - Exceção
	 */
	public Chamado obterChamado(int id) throws Exception {
		Chamado chamado = null;
		ChamadosDBManager DBManager = new ChamadosDBManager();
		Connection conexao = DBManager.obterConexaoMySQLDataSource();
		String sql = "SELECT * FROM chamado WHERE id=?";

		PreparedStatement preparedStatement = conexao.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			chamado = new Chamado();
			chamado.setDescricao(rs.getString("descricao"));
		}
		preparedStatement.close();
		rs.close();
		conexao.close();
		return chamado;
	}
}
