package com.fiap.contamedica.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Classe utilitária responsável em implementar as necessidades de envio e consumo de e-mail.
 * 
 * @author Luiz Fernando
 *
 */
public class MailUtil {

	private static final String username = PropertiesUtil.getProperty("mail.user");
	private static final String password = PropertiesUtil.getProperty("mail.password");
	
	/**
	 * Método responsável em enviar e-mail.
	 * 
	 * @param sendFrom
	 * @param subject
	 * @param textMessage
	 */
	public void enviarEmail(String sendFrom, String subject, String textMessage) {
		if (sendFrom == null || sendFrom.equals("")) {
			throw new IllegalArgumentException("Informar destinatário do e-mail!");
		}
		Properties props = PropertiesUtil.getProperties();
		
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sendFrom));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendFrom));
			message.setSubject(subject);
			message.setText(textMessage);
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
