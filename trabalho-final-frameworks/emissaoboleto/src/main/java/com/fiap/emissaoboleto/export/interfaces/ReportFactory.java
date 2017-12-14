package com.fiap.emissaoboleto.export.interfaces;

/**
 * Interface AbstractFactory para manter o contrato 
 * de quais objetos deverão ser criados.
 * 
 * @author Luiz
 * 
 */
public interface ReportFactory {
	
	/**
	 * Método responsável em criar um instância do objeto 
	 * de geração de boleto.
	 * 
	 * @return
	 */
	public ReportExportInterface createExportBoleto();
	
	
	/**
	 * Método responsável em criar uma instancia do objeto
	 * de geração de Relatório Completo.
	 * 
	 * @return
	 */
	public ReportExportInterface createExportRelatorioCompleto();
}
