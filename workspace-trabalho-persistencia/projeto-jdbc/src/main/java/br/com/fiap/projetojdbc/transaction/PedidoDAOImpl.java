package br.com.fiap.projetojdbc.transaction;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.projetojdbc.datatypes.Pedido;
import br.com.fiap.projetojdbc.datatypes.PedidoItem;

public class PedidoDAOImpl extends BaseDAO {
	public void inserirPedido(Pedido pedido) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			
			// CRIA A QUERY PARA O INSERT DO PEDIDO
			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO PEDIDO (ID_PEDIDO, DT_PEDIDO, STATUS_PEDIDO, ID_CLIENTE ) ");
			query.append(" VALUES (?, ?, ?, ?); ");
			
			// ABRE UMA CONEXAO COM O BANCO DE DADOS UTILIZANDO JDBC
			connection = getConexao();
			
			// CRIA UM PREPARESTATEMENT A PARTIR DA QUERY
			pstmt = connection.prepareStatement(query.toString());
			
			// ATRIBUI OS VALORES PARA A QUERY DE INSERT DO PEDIDO
			pstmt.setInt(1, pedido.getIdPedido());
			pstmt.setDate(2, new Date(pedido.getDtPedido().getTime()));
			pstmt.setString(3, pedido.getStatusPedido());
			pstmt.setInt(4, pedido.getCliente().getIdCliente());
			
			// EXECUTA A QUERY, POR�M AINDA N�O ATUALIZA O BANCO DE DADOS COM OS NOVOS VALORES
			pstmt.executeUpdate();
			
			for (PedidoItem pedidoItem : pedido.getPedidoItems()) {
				
				// CRIA A QUERY PARA O INSERT DO ITEM PEDIDO
				query.append("INSERT INTO PEDIDO_ITEM (ID_PEDIDO_ITEM, QTD_ITEM, ID_PEDIDO, ID_ITEM) ");
				query.append(" VALUES (?, ?, ?, ?); ");
				
				// CRIA UM PREPARESTATEMENT A PARTIR DA QUERY
				pstmt = connection.prepareStatement(query.toString());
				
				// ATRIBUI OS VALORES PARA A QUERY DE INSERT DO PEDIDO ITEM
				pstmt.setInt(1, pedidoItem.getIdPedidoItem());
				pstmt.setInt(2, pedidoItem.getQtdItem());
				pstmt.setInt(3, pedidoItem.getPedido().getIdPedido());
				pstmt.setInt(4, pedidoItem.getItem().getIdItem());
				
				// EXECUTA A QUERY, POR�M AINDA N�O ATUALIZA O BANCO DE DADOS COM OS NOVOS VALORES
				pstmt.executeUpdate();
			}
			
			// CONFIRMA AO BANCO DE DADOS SOBRE OS NOVOS INSERTS
			connection.commit();
			
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
	}
}
