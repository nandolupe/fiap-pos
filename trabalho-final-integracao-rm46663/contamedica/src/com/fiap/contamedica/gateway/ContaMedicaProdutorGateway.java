package com.fiap.contamedica.gateway;

import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueRequestor;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.NamingException;

/**
 * Classe respons�vel em ser a integradora com a Queue. Cabe a ela enviar e
 * devolver a informa��o padr�o de comunica��o da queue no caso XML est� sendo
 * utilizado para troca de comunica��o..
 * 
 * @author Luiz Fernando
 * 
 */
public class ContaMedicaProdutorGateway extends QueueBase {
	
	private final static Logger log = Logger.getLogger(ContaMedicaProdutorGateway.class.getName()); 
	
	public ContaMedicaProdutorGateway() {
	}

	private static final String NOME_FILA = "queue/FilaFIAP";

	private Context jndiContext;
	private QueueConnectionFactory queueConnectionFactory;
	private QueueConnection queueConnection;
	private QueueSession queueSession;
	private Queue queue;
	private TextMessage message;
	
	/**
	 * M�todo respons�vel em enviar o XML para an�lise.
	 * 
	 * @param xmlIn
	 * @return
	 */
	public String enviarXml(String xmlIn) {

		String xmlRetorno = "";

		try {
			
			jndiContext = getInitial();
			queueConnectionFactory = (QueueConnectionFactory) jndiContext.lookup("ConnectionFactory");
			queue = (Queue) jndiContext.lookup(NOME_FILA);
			queueConnection = queueConnectionFactory.createQueueConnection();
			queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueRequestor queueRequestor = new QueueRequestor(queueSession, queue);
			queueConnection.start();
			message = queueSession.createTextMessage();
			message.setText(xmlIn);
			TextMessage reply = (TextMessage) queueRequestor.request(message);
			xmlRetorno = reply.getText();
		} catch (JMSException e) {
			log.info("Erro ao capturar Connection Factory!");
			e.printStackTrace();
		} catch (NamingException e) {
			log.info("Caminho JNDI n�o encontrado!");
			e.printStackTrace();
		} catch (Exception e) {
			log.info("Ocorreu um erro n�o esperado!");
			e.printStackTrace();
		} finally {
			fecharConexao(queueConnection);
		}

		return xmlRetorno;
	}

}
