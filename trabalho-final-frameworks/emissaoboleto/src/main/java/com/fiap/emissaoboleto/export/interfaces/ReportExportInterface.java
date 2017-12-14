package com.fiap.emissaoboleto.export.interfaces;

import java.util.Map;

/**
 * Interface respons�vel em manter o contrato de exporta��o 
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
