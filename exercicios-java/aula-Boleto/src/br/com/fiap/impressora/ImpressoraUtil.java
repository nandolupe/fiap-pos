package br.com.fiap.impressora ;

import java.io.File ;
import java.io.FileOutputStream ;
import java.text.SimpleDateFormat ;
import java.util.ArrayList ;
import java.util.Date ;
import java.util.Iterator ;
import java.util.List ;

import org.apache.commons.io.FileUtils ;
import org.apache.commons.lang.ArrayUtils ;

import com.lowagie.text.pdf.PdfCopyFields ;
import com.lowagie.text.pdf.PdfReader ;

public class ImpressoraUtil
{

	private static final String POSTSCRIPT_STAPLE_TAG = "<</Staple ?>> setpagedevice" ;
	private static final String LINE_SEPARATOR = "line.separator" ;
	private static final String RELATORIOSDEST = "E:\\REPOSITORIO_JASPER\\notasFiscais\\relatorios\\" ;
	private static final String POSTSCRIPTSDEST = "E:\\REPOSITORIO_JASPER\\notasFiscais\\postScripts\\" ;

	public static void gerarPostScript( ) throws Exception
	{

		String lineContent = null ;
		int counter = 0 ;
		char postScriptFileClampFlag = '5' ;
		List<Integer> pageNumberList = new ArrayList<Integer>( ) ;
		int startLine = 0 ;
		int position = 0 ;
		Integer pageNumber = null ;

		long tmpini = System.currentTimeMillis( ) ;

		File dirRelatorios = new File( RELATORIOSDEST ) ;
		File fList[] = dirRelatorios.listFiles( ) ;

		System.out.println( "Quantidade de relatórios a imprimir: " + fList.length ) ;

		// geracao PDF Master
		PdfCopyFields copy = new PdfCopyFields( new FileOutputStream( POSTSCRIPTSDEST
				+ "Master.pdf" ) ) ;

		for (int i = 0; i < fList.length; i++)
		{
			PdfReader reader = new PdfReader( RELATORIOSDEST + fList[ i ].getName( ) ) ;
			pageNumberList.add( new Integer( reader.getNumberOfPages( ) ) ) ;
			copy.addDocument( reader ) ;
		}
		copy.close( ) ;

		// conversao para Post Script
		// String commandPDF2PS =
		// "rundll32 SHELL32.DLL,ShellExec_RunDLL c://xpdf//pdftops.exe -paper A4";
		String commandPDF2PS = "E:\\REPOSITORIO_JASPER\\notasFiscais\\pdftops32.exe -paper A4" ;
		Runtime.getRuntime( ).exec(
				commandPDF2PS.concat( " " ).concat( POSTSCRIPTSDEST + "Master.pdf" ) ) ;

		// rotina para verificar se o arquivo PS já foi criado.
		File PSFile = new File( POSTSCRIPTSDEST + "Master.ps" ) ;
		while (!PSFile.exists( ))
		{
			System.out.println( "Aguardando arquivo Master.ps ser criado..." ) ;
		}
		Thread.sleep( 2000 ) ;

		// adicao tags impressora
		System.out.println( "Lendo arquivo Master.pdf" ) ;

		File file = new File( POSTSCRIPTSDEST + "Master.ps" ) ;
		List fileLines = FileUtils.readLines( file ) ;

		// Percorre cada PDF
		for (Iterator iter = pageNumberList.iterator( ); iter.hasNext( );)
		{

			// Quantidade de páginas do PDF
			pageNumber = ( Integer ) iter.next( ) ;

			// Percorre cada página do PDF
			for (counter = 1; counter <= pageNumber.intValue( ); counter++)
			{
				position = ArrayUtils.indexOf( ( String[ ] ) fileLines.toArray( new String[ 0 ] ),
						"pdfEndPage", startLine + 1 ) ;
				startLine = position ;
			}

			System.out.println( "Adicionando tag 'staple' na linha " + ( position - 1 ) ) ;
			lineContent = ( String ) fileLines.get( position - 2 ) ;
			lineContent += System.getProperty( LINE_SEPARATOR )
					+ POSTSCRIPT_STAPLE_TAG.replace( '?', postScriptFileClampFlag ) ;
			fileLines.set( position - 2, lineContent ) ;
			System.out.println( "Tag 'staple' adicionada com sucesso" ) ;
			if (postScriptFileClampFlag == '5')
			{
				postScriptFileClampFlag = '0' ;
			}
			else
			{
				postScriptFileClampFlag = '5' ;
			}
		}

		// grava novo arquivo PS com tags 'staple' inclusas
		System.out.println( "Gravando novo arquivo MasterFinal.ps" ) ;
		FileUtils.writeLines( new File( POSTSCRIPTSDEST + "MasterFinal.ps" ), fileLines ) ;
		System.out.println( "Arquivo gerado com sucesso" ) ;

		System.out.println( "Tempo total execução: " + ( System.currentTimeMillis( ) - tmpini ) ) ;

	}

	public static void simulaImpressao( ) throws Exception
	{

		PdfReader reader = new PdfReader( POSTSCRIPTSDEST + "Master.pdf" ) ;

		Integer numPages = reader.getNumberOfPages( ) ;

		SimpleDateFormat sdf = new SimpleDateFormat( "[dd/MM/yyyy HH:mm:ss]" ) ;

		System.out.println( "Imprimindo " + numPages + " páginas" ) ;

		for (int i = 1; i <= numPages; i++)
		{
			System.out.println( sdf.format( new Date( ) ) + " Imprimindo página: " + i ) ;
			Thread.sleep( 2000 ) ;
		}
	}

}
