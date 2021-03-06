package com.fiap.contamedica.business;

import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.fiap.contamedica.entity.AnaliseConta;
import com.fiap.contamedica.entity.ContaMedica;
import com.fiap.contamedica.util.MailUtil;
import com.fiap.contamedica.util.PropertiesUtil;

/**
 * Respons�vel em implementar o neg�cio da Analise de Conta.
 * 
 * @author Luiz Fernando 
 *
 */
public class AnaliseContaBusiness {
	
	private final static Logger log = Logger.getLogger(AnaliseContaBusiness.class.getName()); 
	
	public AnaliseContaBusiness() {}
	
	/**
	 * M�todo respons�vel em implementar as regras de analise de conta.
	 * 
	 * @param xmlIn
	 * @return
	 */
	public String analisarConta(String xmlIn) {
		
		String xmlRetorno = "";
		
		ContaMedica contaMedica = parseXMLtoObject(xmlIn);
		AnaliseConta analiseConta = new AnaliseConta(new Random().nextInt());
		
		/* 
		 * IMPLEMENTA��O DA REGRA DE NEG�CIO
		 * No caso se houver diverg�ncia entre os valores informado e pago, 
		 * dever� haver a glosa e o envio de e-mail ao prestador notificando a diverg�ncia.
		 * 
		 */
		if (contaMedica.getValorInformado().doubleValue() != contaMedica.getValorAcatado().doubleValue()) {
			// SE OS VALORES ESTIVEREM DIVERGENTES GERA A GLOSA E INFORMA O PRESTADOR
			enviarEmailPrestador(contaMedica);
			analiseConta.setResultadoAnalise("Ocorreu glosa na conta m�dica " + contaMedica.getCodContaMedica() + " e o prestador foi informado no email: " + contaMedica.getEmailPrestador());
		} else {
			analiseConta.setResultadoAnalise("Conta M�dica analisada com sucesso!");
		}
		
		xmlRetorno = parseObjetcToXML(analiseConta);
		
		return xmlRetorno;
	}
	
	/**
	 * M�todo respons�vel em enviar o e-mail a partir das regras de conta m�dica.
	 * 
	 * @param contaMedica
	 */
	private void enviarEmailPrestador(ContaMedica contaMedica) {
		
		BigDecimal valorGlosado = new BigDecimal(contaMedica.getValorInformado()).subtract(new BigDecimal(contaMedica.getValorAcatado()));
		
		// obtem a mensagem default do e-mail
		String mensagemDefault = PropertiesUtil.getProperty("mail.message.default");
		mensagemDefault = mensagemDefault.replaceAll(":dscprestador", contaMedica.getDscPrestador());
		mensagemDefault = mensagemDefault.replaceAll(":numContaMedica", contaMedica.getCodContaMedica().toString());
		mensagemDefault = mensagemDefault.replaceAll(":valorGlosado", new DecimalFormat("0.00").format(valorGlosado));
		
		// obtem o assunto default do e-mail 
		String subjectDefault = PropertiesUtil.getProperty("mail.subject.default");
		subjectDefault = subjectDefault.replaceAll(":dscContaMedica", contaMedica.getDescricaoContaMedica());
		
		// envia o e-mail
		new MailUtil().enviarEmail(contaMedica.getEmailPrestador(), subjectDefault, mensagemDefault);
	}
	
	/**
	 * @param analiseConta
	 * @return
	 */
	private String parseObjetcToXML(AnaliseConta analiseConta) {
		
		String xml = "";
		
		StringWriter stringWriter = new StringWriter();
		
		try {
			
			// CRIA UM CONTEXTO PARA O JAXB
			JAXBContext jc = JAXBContext.newInstance(AnaliseConta.class);
			
			// INSTANCIA DO OBJETO QUE IR� FAZER A CONVERS�O
			Marshaller m = jc.createMarshaller();
			
			// COLOCANDO A PROPRIEDADE PARA DEIXAR FORMATADO O XML
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			// FAZENDO O PARSE PARA UM StringWriter
			m.marshal(analiseConta, stringWriter);
			
			// PARSEANDO PARA UM STRING
			xml = stringWriter.toString();
			
		} catch (JAXBException e) {
			log.info("Erro ao fazer o parse do XML!");
			e.printStackTrace();
		}
		return xml;
	}

	/**
	 * Respons�vel em fazer o parse de um XML para um objeto
	 * 
	 * @param xmlOut
	 * @return
	 */
	private ContaMedica parseXMLtoObject(String xmlOut) {
		
		ContaMedica contaMedica = null;
		
		try {
			JAXBContext jc = JAXBContext.newInstance(ContaMedica.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			StreamSource streamSource = new StreamSource(new StringReader(xmlOut));
			JAXBElement<ContaMedica> je = unmarshaller.unmarshal(streamSource, ContaMedica.class);

			contaMedica = (ContaMedica) je.getValue();

		} catch (JAXBException e) {
			log.info("Erro ao fazer o parse do XML!");
			e.printStackTrace();
		}
		
		return contaMedica;
	}
}
