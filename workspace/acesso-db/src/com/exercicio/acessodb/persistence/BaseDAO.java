package com.exercicio.acessodb.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO {
	
	/**
	 * Método responsável em criar uma conexão com o banco de dados.
	 * 
	 * @return
	 */
	protected Connection createConnection() {

		Connection connection = null;
		
		String driverName = "oracle.jdbc.driver.OracleDriver";  
	    try {
			
	    	Class.forName(driverName);
			
		    String serverName = "localhost";  
		    String portNumber = "1521";  
		    String sid = "orcl";  
		    String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;  
		    String username = "system";  
		    String password = "admin";  
		    connection = DriverManager.getConnection(url, username, password);  

			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;  
	    
	}
	
	/**
	 * Método responsável em fechar uma conexão com o banco de dados.
	 * 
	 * @param rs
	 * @param ps
	 * @param connection
	 */
	protected void closeConnection(ResultSet rs, PreparedStatement ps, Connection connection) {
		try {
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
