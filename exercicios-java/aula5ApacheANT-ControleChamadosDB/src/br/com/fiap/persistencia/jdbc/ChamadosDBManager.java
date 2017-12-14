package br.com.fiap.persistencia.jdbc;

import java.sql.Connection;
import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ChamadosDBManager {

	
	/**
	 * Obtem Conex�o do banco de dados
	 * 
	 * @return Connection - Conex�o do BD
	 * @throws Exception - Exce��o
	 */
	public Connection obterConexaoMySQLDataSource() throws Exception {
		Hashtable ht = new Hashtable();
		ht.put(InitialContext.INITIAL_CONTEXT_FACTORY,
				"org.jnp.interfaces.NamingContextFactory");
		ht.put(InitialContext.PROVIDER_URL, "jnp://localhost:1099");
		ht.put(InitialContext.URL_PKG_PREFIXES,
				"org.jboss.naming:org.jnp.interfaces");

		InitialContext initialContext = new InitialContext(ht);
		DataSource dataSource = (DataSource) initialContext
				.lookup("java:/jdbc/fiap");
		return dataSource.getConnection();
	}
}
