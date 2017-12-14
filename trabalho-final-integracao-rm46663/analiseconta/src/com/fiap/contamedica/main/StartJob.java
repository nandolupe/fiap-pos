package com.fiap.contamedica.main;

import java.util.logging.Logger;

import com.fiap.contamedica.gateway.AnaliseMedicaConsumerGateway;

/**
 * @author Classe respons�vel em dar o start no job de consumo.
 *
 */
public class StartJob {
	
	private final static Logger log = Logger.getLogger(StartJob.class.getName());
	
	public StartJob() {}
	
	private AnaliseMedicaConsumerGateway consumerGateway = new AnaliseMedicaConsumerGateway();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final StartJob startJob = new StartJob();
		startJob.start();
	}
	
	/**
	 * m�todo respons�vel em chamar o job de an�lise de conta
	 */
	private void start() {
		log.info("Iniciando o Job de an�lise m�dica");
		consumerGateway.consumirXml();
	}
}
