import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;


/**
 * Classe <code>Codificador</code>.
 *
 *
 * @category Main.
 *
 * @author Luiz Pereira
 *
 *
 */
public class Codificador {

    /**
     * Metodo main.
     *
     * @param args
     *
     */
    public static void main(String[] args) {
    	
    	// RECEBE O TEXTO DE ENTRADA
        String texto = JOptionPane.showInputDialog("Entre com o texto: ");

        char[] textoArray = texto.toCharArray();
        StringBuilder builder = new StringBuilder();
        builder.setLength(texto.toCharArray().length);
        
        // GRAVA NO ARQUIVO A MENSAGEM DECODIFICADA
        gravarArquivo(texto, "mesagemDecodificada.txt");
        
        for (int i = 0; i < textoArray.length; i++) {
        	// CONVERTE O CÓDIGO ASCII + 1
            builder.setCharAt(i, (char) (textoArray[i] + 1));
        }
        
        // GRAVA NO ARQUIVO A MENSAGEM CODIFICADA.
        gravarArquivo(builder.toString(), "mensagemCodificada.txt");
        
    }
    
    /**
     * @param texto
     * @param fileName
     */
    private static void gravarArquivo(String texto, String fileName) {
    	
        try {
        	
        	FileOutputStream fileOutputStream = new FileOutputStream(fileName);
			fileOutputStream.write(texto.getBytes());
			fileOutputStream.flush();
	        fileOutputStream.close();
	        
		} catch (IOException e) {
			System.out.println("Erro ao gravar o arquivo.");
		}
	}
}
