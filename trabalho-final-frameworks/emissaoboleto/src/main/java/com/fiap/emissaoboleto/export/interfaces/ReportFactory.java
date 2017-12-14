package com.fiap.emissaoboleto.export.interfaces;

/**
 * Interface AbstractFactory para manter o contrato 
 * de quais objetos dever�o ser criados.
 * 
 * @author Luiz
 * 
 */
public interface ReportFactory {
	
	/**
	 * M�todo respons�vel em criar um inst�ncia do objeto 
	 * de gera��o de boleto.
	 * 
	 * @return
	 */
	public ReportExportInterface createExportBoleto();
	
	
	/**
	 * M�todo respons�vel em criar uma instancia do objeto
	 * de gera��o de Relat�rio Completo.
	 * 
	 * @return
	 */
	public ReportExportInterface createExportRelatorioCompleto();
}
