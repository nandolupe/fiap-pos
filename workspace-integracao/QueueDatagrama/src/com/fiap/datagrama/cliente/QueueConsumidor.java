package com.fiap.datagrama.cliente;

import java.util.Properties;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class QueueConsumidor {

	private static final String NOME_FILA = "queue/FilaFIAP";
	Context jndiContext;
	QueueConnectionFactory queueConnectionFactory;
	QueueConnection queueConnection;
	QueueSession queueSession;
	Queue queue;
	QueueReceiver queueReceiver;
	TextMessage message;

	public static void main(String[] args) {
		QueueConsumidor queueConsumidor =
		new QueueConsumidor();
		queueConsumidor.iniciaProcesso();
	}

	private static InitialContext getInitial() throws Exception{
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial",
				"org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url",
				"localhost:1099");
		props.setProperty("java.naming.factory.url.pkgs",
				"org.jboss.naming");
		InitialContext context = new InitialContext(props);
		return context;
	}

	private void iniciaProcesso() {

		try {
			// Obtem o InitialContext
			System.out.println("*** Obtendo InitialContext...");
			jndiContext = getInitial();
		} catch (Exception e) {
			System.out.println("N�o foi poss�vel criar o JNDI API"
					+ e.toString());
			System.exit(1);
		}

		try {
			System.out.println("*** Obtendo Queue Connection Factory");
			queueConnectionFactory = (QueueConnectionFactory)
					jndiContext.lookup("ConnectionFactory");

			System.out.println("*** Obtendo Queue");
			queue = (Queue) jndiContext.lookup(NOME_FILA);


		} catch (NamingException e) {
			System.out.println("problemas no JNDI API lookup : " +
					e.toString());
			System.exit(1);
		}

		try {
			System.out.println("*** Criando conex�o com " +
					"Queue Connection Factory...");
			queueConnection =
					queueConnectionFactory.createQueueConnection();
			System.out.println("*** Criando conex�o com Queue...");
			queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

			System.out.println("*** Criando o Receiver");
			queueReceiver = queueSession.createReceiver(queue);

			System.out.println("*** Iniciando a conex�o...");
			queueConnection.start();

			while (true) {
				// Aguarda a mensagem por tempo indeterminado
				Message m = queueReceiver.receive();
				if (m != null) {
					if (m instanceof TextMessage) {
						message = (TextMessage) m;
						System.out.println("A mensagem recebida: "
								+ message.getText());
						if ("fim".equalsIgnoreCase(message.getText()))
						{
							break;
						}
					} else {
						break;
					}
				}
			}
		} catch (JMSException e) {
			System.out.println("Exception : " +
					e.toString());
		} finally {
			System.out.println("*** Fechando conex�o " +
					"com a Queue...");
			if (queueConnection != null) {
				try {
					System.out.println("*** Fechando " +
							"conex�o com o Queue Connection.");
					queueConnection.close();
				} catch (JMSException e) {
					System.out.println("Exception : "
							+ e.toString());
				}
			}
		}

	}

}