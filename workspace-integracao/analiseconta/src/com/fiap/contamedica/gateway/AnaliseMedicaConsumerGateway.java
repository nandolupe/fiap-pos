package com.fiap.contamedica.gateway;

import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.NamingException;

import com.fiap.contamedica.business.AnaliseContaBusiness;

/**
 * Respons�vel em fazer fronteira com outros sistemas e realizar a analise
 * m�dica.
 * 
 * @author LUiz Fernando
 * 
 */
public class AnaliseMedicaConsumerGateway extends QueueBase {

	private final static Logger log = Logger
			.getLogger(AnaliseMedicaConsumerGateway.class.getName());

	public AnaliseMedicaConsumerGateway() {
		analiseContaBusiness = new AnaliseContaBusiness();
	}

	private static final String NOME_FILA = "queue/FilaAnaliseConta";
	private Context jndiContext;
	private QueueConnectionFactory queueConnectionFactory;
	private QueueConnection queueConnection;
	private QueueSession queueSession;
	private Queue queue;
	private QueueReceiver queueReceiver;
	private TextMessage message;
	private QueueSender replySender;
	private AnaliseContaBusiness analiseContaBusiness;

	/**
	 * M�todo respons�vel em consumir as analise da conta da QUEUE
	 */
	public void consumirXml() {

		while (true) {
			try {
				jndiContext = getInitial();
				queueConnectionFactory = (QueueConnectionFactory) jndiContext
						.lookup("ConnectionFactory");
				queue = (Queue) jndiContext.lookup(NOME_FILA);
				queueConnection = queueConnectionFactory
						.createQueueConnection();
				queueSession = queueConnection.createQueueSession(false,
						Session.AUTO_ACKNOWLEDGE);
				queueReceiver = queueSession.createReceiver(queue);
				queueConnection.start();

				String xmlOut = "";

				// Aguarda a mensagem por tempo indeterminado
				Message messageReceiver = queueReceiver.receive();
				if (messageReceiver != null) {
					if (messageReceiver instanceof TextMessage) {
						message = (TextMessage) messageReceiver;
						xmlOut = analiseContaBusiness.analisarConta(message
								.getText());

						/*
						 * Enviando a resposta
						 */
						Queue tempQueue = (Queue) message.getJMSReplyTo();

						// Cria um objeto sender para a fila de resposta
						replySender = queueSession.createSender(tempQueue);

						TextMessage resposta = queueSession.createTextMessage();
						resposta.setJMSCorrelationID(message.getJMSMessageID());
						resposta.setText(xmlOut);

						replySender.send(resposta);
					} else {
						break;
					}
				}
			} catch (JMSException e) {
				log.info("Erro ao capturar Connection Factory!");
			} catch (NamingException e) {
				log.info("O servidor n�o foi iniciado ou caminho JNDI n�o foi criado!");
			} catch (Exception e) {
				log.info("Ocorreu um erro n�o esperado!");
			} finally {
				fecharConexao(queueConnection);
			}
		}
	}
}
