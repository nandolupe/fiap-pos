package br.com.fiap.projetojdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public abstract class BaseDAO {
	
	// STRING DE CONEX�O COM O BANCO DE DADOS
	private static final String URL = "jdbc:mysql://localhost:3306/ecommerce";
	
	// USERNAME NO BANCO DE DADOS
	private static final String USERNAME = "root";
	
	// PASSWORD DO BANCO DE DADOS
	private static final String PASSWORD = "admin";
	
	// DRIVER DO BANCO DE DADOS, NESSE CASO DO MYSQL
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	
	protected Connection getConexao() {
		
		Connection connection = null;
			
		try {
			
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setUrl(URL);
			dataSource.setUser(USERNAME);
			dataSource.setPassword(PASSWORD);
			dataSource.setCachePreparedStatements(true);
			dataSource.setCachePrepStmts(true);
			dataSource.setCacheResultSetMetadata(true);
			dataSource.setAlwaysSendSetIsolation(false);
			dataSource.setElideSetAutoCommits(true);
			
			// COLOCA O DRIVER EM MEM�RIA PARA SER UTILIZADO PARA A CONEX�O.
			Class.forName(DRIVER_NAME);
			
			// OBTEM A CONEX�O COM O BANCO DE DADOS UTILIZANDO AS INFORMA��ES.
			
			connection = dataSource.getConnection();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao capturar o Driver!");
		} catch (SQLException e) {
			System.out.println("Erro ao obter a conex�o com o Banco de Dados!");
		}
		
		return connection;
	}
	
	protected void fecharConexao(Connection connection, PreparedStatement preparedStatement) {
		
		try {
			
			// OBTEM UM PREPARESTATEMENT E FECHA-O
			if (preparedStatement != null && !preparedStatement.isClosed()) {
				preparedStatement.close();
			}
			
			// OBTEM A CONEX�O E FECHA-A
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao fechar a conex�o com o banco de dados!");
		}

	}
}
