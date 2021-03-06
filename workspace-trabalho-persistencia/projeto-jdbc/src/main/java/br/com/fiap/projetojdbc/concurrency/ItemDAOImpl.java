package br.com.fiap.projetojdbc.concurrency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.projetojdbc.datatypes.Item;

public class ItemDAOImpl extends BaseDAO {
	public Item buscarItemLock(Item item) {
		
		Item itemResult = null;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			// CRIA A QUERY PARA O INSERT DO PEDIDO
			StringBuffer query = new StringBuffer();
			query.append("SELECT ID_ITEM, DSC_ITEM, VALOR_ITEM FROM ITEM WHERE ID_ITEM = ? ");

			// ABRE UMA CONEXAO COM O BANCO DE DADOS UTILIZANDO JDBC
			connection = getConexao();
			
			// CRIA UM PREPARESTATEMENT A PARTIR DA QUERY E INFORMA QUE SER� REALIZADO O LOCK DO REGISTRO.
			pstmt = connection.prepareStatement(query.toString(), ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setInt(1, item.getIdItem());
			
			// EXECUTA A QUERY E OBTEM O RETORNO
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				itemResult = new Item();
				itemResult.setIdItem(rs.getInt("ID_ITEM"));
				itemResult.setValorItem(rs.getBigDecimal("VALOR_ITEM"));
				itemResult.setDscItem(rs.getString("DSC_ITEM"));
			}
			
		} catch (SQLException e) {
			try {
				// EM CASO DE ERRO, REALIZA O ROLLBACK DOS INSERTS.
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Erro ao realizar Rollback!");
			}
			System.out.println("Erro ao inserir um pedido e seus items!");
		} finally {
			fecharConexao(connection, pstmt);
		}
		
		return itemResult;
	}
}
