package com.fiap.contamedica.main;

import java.util.logging.Logger;

import com.fiap.contamedica.gateway.AnaliseMedicaConsumerGateway;

/**
 * @author Classe responsável em dar o start no job de consumo.
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
	 * método responsável em chamar o job de análise de conta
	 */
	private void start() {
		log.info("Iniciando o Job de análise médica");
		consumerGateway.consumirXml();
	}
}
