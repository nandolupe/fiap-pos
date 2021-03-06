package com.exercicios.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author LFP0713
 *
 */
public class BaseDAO {

	private static String URL_CONNECTION = "jdbc:mysql://localhost/exercicio";
	private static String USER = "root";
	private static String PASSWORD = "admin";

    /**
     * @return
     */
    protected Connection getConnection() {

    	Connection connection = null;
    	try {

    		Class.forName("com.mysql.jdbc.Driver");

    		connection = DriverManager.getConnection(URL_CONNECTION, USER, PASSWORD);

        } catch (SQLException e) {

        	e.printStackTrace();
        } catch (ClassNotFoundException e) {
        	System.out.println("Erro ao abrir a conex�o com o banco de dados!");
			e.printStackTrace();
		}

    	return connection;
    }

    /**
     * @param connection
     * @param prst
     * @param rs
     */
    protected void closeConnection(Connection connection, PreparedStatement prst, ResultSet rs) {

    	try {

    		// FECHANDO O RESULT SET
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}

			// FECHANDO O PREPARESTATEMENT
			if (prst != null && !prst.isClosed()) {
				prst.close();
			}

			// FECHANDO A CONNECTION
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println("Erro ao fechar a conex�o com o banco de dados!");
			e.printStackTrace();
		}

    }
}
