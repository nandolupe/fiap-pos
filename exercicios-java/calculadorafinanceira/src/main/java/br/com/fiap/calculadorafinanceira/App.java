package br.com.fiap.calculadorafinanceira;

import com.thoughtworks.xstream.XStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( CalculadoraFinanceira.pmt(0.1, 10.0) );
        
        Funcionario fun = new Funcionario();
        fun.setNome("Teste");
        
        XStream st = new XStream();
        st.alias("funcionario", Funcionario.class);
        System.out.println(st.toXML(fun));
        
    }
}
