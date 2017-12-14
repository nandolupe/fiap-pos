package com.fiap.emissaoboleto.export;

import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

import org.apache.log4j.Logger;

import com.fiap.emissaoboleto.export.interfaces.ReportExportInterface;
import com.fiap.emissaoboleto.servlet.EmitirBoletoServlet;

/**
 * Classe responsável em gerar o boleto com jasperreport.
 * 
 * @author Luiz
 */
public class ReportExportBoleto implements ReportExportInterface {
	private final static Logger logger = Logger.getLogger(EmitirBoletoServlet.class);

	private static final String fileName = "src/main/resources/jasper/Boleto.jasper";

	/* (non-Javadoc)
	 * @see com.fiap.emissaoboleto.export.interfaces.ReportExportInterface#export(java.util.Map)
	 */
	public byte[] export(Map<String, Object> parameters) {
		logger.info("Export de boleto.");
		byte[] bytes = null;
		
		try {
			
			bytes = JasperRunManager.runReportToPdf(fileName, parameters, new JREmptyDataSource());
			
		} catch (JRException e) {
			logger.error("Erro ao gerar o relatório", e);
		} catch (Exception e) {
			logger.error("Erro indefinido ao gerar o relatório", e);
		}
		logger.info("Fim do export de boleto.");
		return bytes;
	}
}
