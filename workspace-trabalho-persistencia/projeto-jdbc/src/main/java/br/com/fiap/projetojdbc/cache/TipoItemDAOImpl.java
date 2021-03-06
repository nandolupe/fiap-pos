package br.com.fiap.projetojdbc.cache;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.projetojdbc.datatypes.PedidoItem;
import br.com.fiap.projetojdbc.datatypes.TipoItem;

public class TipoItemDAOImpl extends BaseDAO {
	public List<TipoItem> findAll() {
		
		List<TipoItem> list = new ArrayList<TipoItem>();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			// CRIA A QUERY PARA O INSERT DO PEDIDO
			StringBuffer query = new StringBuffer();
			query.append("SELECT ID_TIPO_ITEM, DSC_TIPO_ITEM FROM TIPO_ITEM ");

			// ABRE UMA CONEXAO COM O BANCO DE DADOS UTILIZANDO JDBC
			connection = getConexao();
			
			// CRIA UM PREPARESTATEMENT A PARTIR DA QUERY
			pstmt = connection.prepareStatement(query.toString());
			
			// EXECUTA A QUERY E OBTEM O RETORNO
			rs = pstmt.executeQuery();
			
			TipoItem tipoItem = null;
			
			while (rs.next()) {
				tipoItem = new TipoItem();
				tipoItem.setIdTipoItem(rs.getInt("ID_TIPO_ITEM"));
				tipoItem.setDscTipoItem(rs.getString("DSC_TIPO_ITEM"));
				list.add(tipoItem);
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
		
		return list;
	}
}
