package com.fiap.contamedica.gateway;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.naming.InitialContext;

/**
 * Classe abstrata respons�vel em prover a comunica��o com a queue,
 * ou seja, criar e fechar a conex�o.
 * 
 * @author Luiz Fernando 
 *
 */
public abstract class QueueBase {

	public QueueBase() {}
	
	/**
	 * Respons�vel em fechar a conex�o.
	 * 
	 * @param queueConnection
	 */
	protected void fecharConexao(QueueConnection queueConnection) {
		if (queueConnection != null) {
			try {
				queueConnection.close();
			} catch (JMSException e) {
			}
		}
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	protected static InitialContext getInitial() throws Exception {
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");
		InitialContext context = new InitialContext(props);
		return context;
	}

}
