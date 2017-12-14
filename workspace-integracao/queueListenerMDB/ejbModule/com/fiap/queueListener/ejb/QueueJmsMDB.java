package com.fiap.queueListener.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * Message-Driven Bean implementation class for: QueueJmsMDB
 */
@MessageDriven(
		activationConfig = {
				@ActivationConfigProperty(
						propertyName = "destinationType",
						propertyValue = "javax.jms.Queue"),
						@ActivationConfigProperty(
								propertyName = "destination",
								propertyValue = "queue/FilaFIAP"),
		})
public class QueueJmsMDB implements MessageListener {

	/**
	 * Default constructor. 
	 */
	public QueueJmsMDB() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		if (message instanceof ObjectMessage) {
			try {
				ObjectMessage txtMessage = (ObjectMessage) message;
				Cliente c = null;
				if (txtMessage.getObject() instanceof Cliente) {
					c = (Cliente)txtMessage;
				}
				System.out.println("*** A mensagem recebida: "
						+ c.getNomeCliente());
			} catch (Exception e) {
				/*
				 * Aqui a exceção deve ser tratada.
				 * No mínimo deve-se logar a
				 * causa da falha.
				 */
				throw new
				EJBException("Falha ao processar a mensagem..."
						, e);
			}
		} else {
			throw new EJBException("*** Erro: Não foi forncecida "
					+ "mensagem em formato TextMessage !!");
		}

	}

}
