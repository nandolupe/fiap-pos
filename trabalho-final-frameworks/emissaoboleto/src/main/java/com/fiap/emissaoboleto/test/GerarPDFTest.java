package com.fiap.emissaoboleto.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import com.fiap.emissaoboleto.util.ConfigProperties;

public class GerarPDFTest {
	public static void main(String[] args) {
        String fileName = "src/main/resources/jasper/Boleto.jasper";
        String outFileName = "C:\\REPOSITORIO_JASPER\\relatorio\\Boleto.pdf";
        ConfigProperties configProperties = ConfigProperties.getInstance();
        
        HashMap map = new HashMap();
		map.put("codigo", "34191690282945517091900827590001124999");
		map.put("nome", "Teste abc");
		map.put("codigoBarra", "34191690282945517091900827590001124999");
		
		map.put("nomeBanco", configProperties.getProperty("nomeBanco"));
		map.put("observacao", "TESTE ABC");
		map.put("dataDocumento", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		map.put("dataVencimento", "15/05/2015");
		map.put("valorDocumento", "R$150,56");
		
		map.put("multa", configProperties.getProperty("multa"));
		map.put("valorCobrado", "56,54");
		map.put("codigoCedente", configProperties.getProperty("codigoCedente"));
		map.put("especieDoc", configProperties.getProperty("especieDoc"));
		map.put("nossoNumero", configProperties.getProperty("nossoNumero"));
		map.put("sacado", "regdfgdfd");
		map.put("localPagamento", configProperties.getProperty("localPagamento"));
		map.put("cedente", "weewrwewrewwe");
		map.put("numeroDocumento", "3333");
		map.put("aceite", configProperties.getProperty("aceite"));
		map.put("carteira", configProperties.getProperty("carteira"));
		map.put("moeda", configProperties.getProperty("moeda"));

        try {
            // Fill the report using an empty data source
            JasperPrint print = JasperFillManager.fillReport(fileName, map, new JREmptyDataSource());
             
            // Create a PDF exporter
            JRExporter exporter = new JRPdfExporter();
             
            // Configure the exporter (set output file name and print object)
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileName);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
             
            // Export the PDF file
            exporter.exportReport();
             
        } catch (JRException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
