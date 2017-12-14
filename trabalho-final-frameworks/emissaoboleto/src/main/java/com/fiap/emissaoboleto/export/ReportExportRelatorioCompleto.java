package com.fiap.emissaoboleto.export;

import java.util.ArrayList;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.log4j.Logger;

import com.fiap.emissaoboleto.entity.Boleto;
import com.fiap.emissaoboleto.export.interfaces.ReportExportInterface;

/**
 * Classe responsável em gerar o relatório completo com jasperreport.
 * 
 * @author Luiz
 *
 */
public class ReportExportRelatorioCompleto implements ReportExportInterface {

	private final static Logger logger = Logger.getLogger(ReportExportRelatorioCompleto.class);

	private static final String fileName = "src/main/resources/jasper/relatorio_completo.jasper";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fiap.emissaoboleto.export.interfaces.ReportExportInterface#export
	 * (java.util.Map)
	 */
	public byte[] export(Map<String, Object> parameters) {
		logger.info("Export do relatório completo.");
		byte[] bytes = null;

		try {
			
			ArrayList<Boleto> lista = (ArrayList<Boleto>) parameters.get("lista");
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(lista, false);
			
			bytes = JasperRunManager.runReportToPdf(fileName, null, beanColDataSource);

		} catch (JRException e) {
			logger.error("Erro ao gerar o relatório", e);
		} catch (Exception e) {
			logger.error("Erro indefinido ao gerar o relatório", e);
		}
		logger.info("Fim do export do relatório completo.");
		return bytes;
	}
}
