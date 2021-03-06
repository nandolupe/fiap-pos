package com.fiap.contamedica.business;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.fiap.contamedica.entity.AnaliseConta;
import com.fiap.contamedica.entity.ContaMedica;
import com.fiap.contamedica.gateway.ContaMedicaProdutorGateway;
	
/**
 * Classe respons�vel em implementar as regras de neg�cio do m�dulo de conta m�dica.
 * 
 * @author Luiz Fernando
 *
 */
public class ContaMedicaBusinessImpl {
	
	private ContaMedicaProdutorGateway contaMedicaGateway = new ContaMedicaProdutorGateway();
	
	public ContaMedicaBusinessImpl() {}
	
	/**
	 * M�todo respons�vel em implementar as regras de neg�cio da analise de conta.
	 * 
	 * @param contaMedica
	 * @return
	 */
	public AnaliseConta analisarConta(ContaMedica contaMedica) {
		
		String xmlEntrada = null;
		String xmlSaida = null;
		
		// PREPARAR PARSE DO CLIENTE
		xmlEntrada = parseObjetcToXML(contaMedica);
		
		// CONSUMIR QUEUE
		xmlSaida = contaMedicaGateway.enviarXml(xmlEntrada);
		
		// TRATAR RESPOSTA
		AnaliseConta analiseConta = parseXMLtoObject(xmlSaida);
		
		// RETORNAR PARA A SERVLET RESPOSTA
		return analiseConta;
		
	}
	
	/**
	 * M�todo respons�vel em transformar um objeto {@link ContaMedica} em um xml.
	 * 
	 * @param contaMedica
	 * @return
	 */
	private String parseObjetcToXML(ContaMedica contaMedica) {
		
		String xml = "";
		
		StringWriter stringWriter = new StringWriter();
		
		try {
			
			// CRIA UM CONTEXTO PARA O JAXB
			JAXBContext jc = JAXBContext.newInstance(ContaMedica.class);
			
			// INSTANCIA DO OBJETO QUE IR� FAZER A CONVERS�O
			Marshaller m = jc.createMarshaller();
			
			// COLOCANDO A PROPRIEDADE PARA DEIXAR FORMATADO O XML
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			// FAZENDO O PARSE PARA UM StringWriter
			m.marshal(contaMedica, stringWriter);
			
			// PARSEANDO PARA UM STRING
			xml = stringWriter.toString();
			
		} catch (JAXBException e) {
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
	private AnaliseConta parseXMLtoObject(String xmlOut) {
		
		AnaliseConta analiseConta = null;
		
		try {
			JAXBContext jc = JAXBContext.newInstance(AnaliseConta.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			StreamSource streamSource = new StreamSource(new StringReader(xmlOut));
			JAXBElement<AnaliseConta> je = unmarshaller.unmarshal(streamSource, AnaliseConta.class);

			analiseConta = (AnaliseConta) je.getValue();

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return analiseConta;
	}
}
