package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	protected Connection cn;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	
	private String url="jdbc:mysql://localhost/aula_jsf";
	
	public void abrirConexao() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url,"root","fiap");
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void fecharConexao() throws Exception {
		if(!cn.isClosed()){
			cn.close();
		}
	}
}
