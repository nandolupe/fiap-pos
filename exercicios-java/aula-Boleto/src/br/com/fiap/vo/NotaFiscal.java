package br.com.fiap.vo ;

public class NotaFiscal
{

	private Integer numero ;
	private String discriminacaoGeral ;
	private String data ;
	private String valor ;

	public Integer getNumero( )
	{
		return numero ;
	}

	public void setNumero( Integer numero )
	{
		this.numero = numero ;
	}

	public String getDiscriminacaoGeral( )
	{
		return discriminacaoGeral ;
	}

	public void setDiscriminacaoGeral( String discriminacaoGeral )
	{
		this.discriminacaoGeral = discriminacaoGeral ;
	}

	public String getData( )
	{
		return data ;
	}

	public void setData( String data )
	{
		this.data = data ;
	}

	public String getValor( )
	{
		return valor ;
	}

	public void setValor( String valor )
	{
		this.valor = valor ;
	}

}
