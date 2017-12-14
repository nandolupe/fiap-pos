package com.fiap.emissaoboleto.export.interfaces;

import java.util.Map;

/**
 * Interface responsável em manter o contrato de exportação 
 * de arquivos via Jasper Reports.
 * 
 * @author Luiz Fernando
 * @since 20/03/2015
 *	
 */
public interface ReportExportInterface {
	/**
	 * @param parameters
	 */
	public byte[] export(Map<String, Object> parameters);
}
