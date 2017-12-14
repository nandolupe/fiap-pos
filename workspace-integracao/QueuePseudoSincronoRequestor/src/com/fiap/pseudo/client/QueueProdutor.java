package com.fiap.pseudo.client;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueRequestor;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

public class QueueProdutor {
	private static final String NOME_FILA =
			"queue/FilaFIAP";
	Context jndiContext;
	QueueConnectionFactory queueConnectionFactory;
	QueueConnection queueConnection;
	QueueSession queueSession;
	Queue queue;
	QueueSender queueSender;
	TextMessage message;
	private static InitialContext getInitial()
			throws Exception{
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
	
	private void enviaMensagem(String txtMensagem){
		try {
			jndiContext = getInitial();
		} catch (Exception e) {
			System.out.println("Não foi possível criar o JNDI "+
					" API" + e.toString());
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
			System.out.println("*** Criando conexão com " +
					"Queue Connection Factory...");
			queueConnection =
					queueConnectionFactory.createQueueConnection();
			System.out.println("*** Criando conexão com Queue...");
			queueSession =
					queueConnection.createQueueSession(false,
							Session.AUTO_ACKNOWLEDGE);
			System.out.println("*** Criando o Sender...");
			QueueRequestor queueRequestor = new QueueRequestor(queueSession, queue);
			System.out.println("*** Iniciando a conexão...");
			queueConnection.start();
			System.out.println("*** Criando Mensagem Text..");
			message = queueSession.createTextMessage();
			message.setText(txtMensagem);
			System.out.println("*** Enviando mensagem...");
			TextMessage reply = (TextMessage) queueRequestor.request(message);
			System.out.println("*** Resposta :" + reply.getText());
		} catch (JMSException e) {
			System.out.println("Exception : " +
					e.toString());
		} finally {
			System.out.println("*** Fechando conexão " +
					"com a Queue...");
			if (queueConnection != null) {
				try {
					System.out.println("*** Fechando " +
							"conexão com o Queue Connection.");
					queueConnection.close();
				} catch (JMSException e) {
					System.out.println("Exception : "
							+ e.toString());
				}
			}
		}
	}
	
	public static void main(String[] args) {
		QueueProdutor produtor = new QueueProdutor();
		while (true) {
			String mensagem = JOptionPane.showInputDialog("Digite uma mensagem:");
			produtor.enviaMensagem(mensagem);
		}
	}
}