package br.com.fiap.relatorio ;

import java.io.File ;
import java.io.FileInputStream ;
import java.io.InputStream ;
import java.text.SimpleDateFormat ;
import java.util.ArrayList ;
import java.util.Date ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import br.com.fiap.vo.Boleto ;
import br.com.fiap.vo.Cliente ;
import br.com.fiap.vo.NotaFiscal ;

import net.sf.jasperreports.engine.JREmptyDataSource ;
import net.sf.jasperreports.engine.JRExporter ;
import net.sf.jasperreports.engine.JRExporterParameter ;
import net.sf.jasperreports.engine.JasperFillManager ;
import net.sf.jasperreports.engine.JasperPrint ;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource ;
import net.sf.jasperreports.engine.export.JRPdfExporter ;

import javax.xml.parsers.DocumentBuilder ;
import javax.xml.parsers.DocumentBuilderFactory ;

import org.jaxen.BaseXPath ;
import org.jaxen.dom.DOMXPath ;
import org.w3c.dom.Document ;
import org.w3c.dom.Element ;

public class RelatorioUtil
{
	
	private static final String ROOTDIR = "E:\\REPOSITORIO_JASPER\\notasFiscais";

	private static final String CAMINHOXML = ROOTDIR + "\\notasFiscais.xml" ;

	private static final String CAMINHOJASPER = ROOTDIR + "\\Boleto.jasper" ;

	private static final String RELATORIOSDEST = ROOTDIR + "\\relatorios\\" ;

	private static Cliente cliente = null ;
	private static List<NotaFiscal> notas = null ;
	private static Boleto boleto = null ;

	@SuppressWarnings(
	{ "unchecked", "rawtypes" } )
	public static void gerarRelatorioPDF( ) throws Exception
	{

		getDataFromXML( ) ;

		JRExporter exporter = null ;
		try
		{

			File jasper = new File( CAMINHOJASPER ) ;
			InputStream isJasper = new FileInputStream( jasper ) ;

			JRBeanCollectionDataSource bcd = new JRBeanCollectionDataSource( notas ) ;

			Map map = new HashMap( ) ;
			map.put( "codigo", cliente.getCodigo( ) ) ;
			map.put( "nome", cliente.getNome( ) ) ;
			map.put( "endereco", cliente.getEndereco( ) ) ;
			map.put( "cidade", cliente.getCidade( ) ) ;
			map.put( "estado", cliente.getEstado( ) ) ;
			map.put( "cnpj", cliente.getCnpj( ) ) ;

			map.put( "codigoBarra", boleto.getCodigoBarra( ) ) ;
			map.put( "nomeBanco", boleto.getNomeBanco( ) ) ;
			map.put( "observacao", boleto.getObservacao( ) ) ;
			map.put( "dataDocumento", boleto.getDataDocumento( ) ) ;
			map.put( "dataVencimento", boleto.getDataVencimento( ) ) ;
			map.put( "valorDocumento", boleto.getValorDocumento( ) ) ;
			map.put( "multa", boleto.getMulta( ) ) ;
			map.put( "valorCobrado", boleto.getValorCobrado( ) ) ;

			map.put( "deps", bcd ) ;

			JasperPrint print = JasperFillManager.fillReport( isJasper, map,
					new JREmptyDataSource( ) ) ;

			exporter = new JRPdfExporter( ) ;

			SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMMdd_HHmmssSS" ) ;

			String pdfName = RELATORIOSDEST + "relatorio_" + sdf.format( new Date( ) ) + ".pdf" ;

			exporter.setParameter( JRExporterParameter.OUTPUT_FILE_NAME, pdfName ) ;
			exporter.setParameter( JRExporterParameter.JASPER_PRINT, print ) ;
			exporter.exportReport( ) ;
		}
		catch (Exception e)
		{
			throw e ;
		}

	}

	private static void getDataFromXML( ) throws Exception
	{
		Element element = null ;
		BaseXPath base = null ;

		try
		{

			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance( )
					.newDocumentBuilder( ) ;
			Document document = documentBuilder.parse( new File( CAMINHOXML ) ) ;

			// elemento root - report
			element = document.getDocumentElement( ) ;

			// Cliente
			cliente = new Cliente( ) ;
			// cliente.setCodigo(new
			// DOMXPath("data/file/cliente/codigo").stringValueOf(element));
			cliente.setCodigo( new DOMXPath( "data/file/cliente/codigo" ).numberValueOf( element )
					.intValue( ) ) ;
			cliente.setNome( new DOMXPath( "data/file/cliente/nome" ).stringValueOf( element ) ) ;
			cliente.setEndereco( new DOMXPath( "data/file/cliente/endereco" )
					.stringValueOf( element ) ) ;
			cliente.setCidade( new DOMXPath( "data/file/cliente/cidade" ).stringValueOf( element ) ) ;
			cliente.setEstado( new DOMXPath( "data/file/cliente/estado" ).stringValueOf( element ) ) ;
			cliente.setCnpj( new DOMXPath( "data/file/cliente/cnpj" ).stringValueOf( element ) ) ;

			// Boleto
			boleto = new Boleto( ) ;
			boleto.setCodigoBarra( new DOMXPath( "data/file/boleto/codigoBarra" )
					.stringValueOf( element ) ) ;
			boleto.setNomeBanco( new DOMXPath( "data/file/boleto/nomeBanco" )
					.stringValueOf( element ) ) ;
			boleto.setObservacao( new DOMXPath( "data/file/boleto/observacao" )
					.stringValueOf( element ) ) ;
			boleto.setDataDocumento( new DOMXPath( "data/file/boleto/dataDocumento" )
					.stringValueOf( element ) ) ;
			boleto.setDataVencimento( new DOMXPath( "data/file/boleto/dataVencimento" )
					.stringValueOf( element ) ) ;
			boleto.setValorDocumento( new DOMXPath( "data/file/boleto/valorDocumento" )
					.stringValueOf( element ) ) ;
			boleto.setMulta( new DOMXPath( "data/file/boleto/multa" ).stringValueOf( element ) ) ;
			boleto.setValorCobrado( new DOMXPath( "data/file/boleto/valorCobrado" )
					.stringValueOf( element ) ) ;

			// Notas
			notas = new ArrayList<NotaFiscal>( ) ;

			base = new DOMXPath( "count(/report/data/file/notasfiscaisservico/nota)" ) ;
			Number n = base.numberValueOf( document ) ;
			for (int i = 1; i <= n.intValue( ); i++)
			{
				NotaFiscal nf = new NotaFiscal( ) ;
				nf.setNumero( new DOMXPath( "data/file/notasfiscaisservico/nota[" + i + "]/numero" )
						.numberValueOf( element ).intValue( ) ) ;
				nf.setDiscriminacaoGeral( new DOMXPath( "data/file/notasfiscaisservico/nota[" + i
						+ "]/discriminacaoGeral" ).stringValueOf( element ) ) ;
				nf.setData( new DOMXPath( "data/file/notasfiscaisservico/nota[" + i + "]/data" )
						.stringValueOf( element ) ) ;
				nf.setValor( new DOMXPath( "data/file/notasfiscaisservico/nota[" + i + "]/valor" )
						.stringValueOf( element ) ) ;

				notas.add( nf ) ;
			}

		}
		catch (Exception e)
		{
			throw e ;
		}
	}

}
