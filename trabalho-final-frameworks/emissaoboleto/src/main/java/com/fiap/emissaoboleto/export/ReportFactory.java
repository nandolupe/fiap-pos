package com.fiap.emissaoboleto.export;

import org.apache.log4j.Logger;

import com.fiap.emissaoboleto.export.interfaces.ReportExportInterface;
import com.fiap.emissaoboleto.servlet.EmitirBoletoServlet;

/**
 * Classe responsável em, ser o ponto de implementação 
 * da criação dos objetos. 
 * 
 * @author Luiz
 */
public class ReportFactory implements com.fiap.emissaoboleto.export.interfaces.ReportFactory {
	
	private final static Logger logger = Logger.getLogger(EmitirBoletoServlet.class);
	
	/* (non-Javadoc)
	 * @see com.fiap.emissaoboleto.export.interfaces.ReportFactory#createExportBoleto()
	 */
	public ReportExportInterface createExportBoleto() {
		logger.debug("criando objetos para export!");
		ReportExportInterface reportExportInterface = new ReportExportBoleto();
		return reportExportInterface;
	}
	
	/* (non-Javadoc)
	 * @see com.fiap.emissaoboleto.export.interfaces.ReportFactory#createExportRelatorioCompleto()
	 */
	public ReportExportInterface createExportRelatorioCompleto() {
		logger.debug("criando objetos para export!");
		ReportExportInterface reportExportInterface = new ReportExportRelatorioCompleto();
		return reportExportInterface;
	}
}
