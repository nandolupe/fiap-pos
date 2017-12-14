package br.com.fiap.vo ;

public class Boleto
{

	private String codigoBarra ;
	private String nomeBanco ;
	private String observacao ;
	private String dataDocumento ;
	private String dataVencimento ;
	private String valorDocumento ;
	private String multa ;
	private String valorCobrado ;

	public String getCodigoBarra( )
	{
		return codigoBarra ;
	}

	public void setCodigoBarra( String codigoBarra )
	{
		this.codigoBarra = codigoBarra ;
	}

	public String getNomeBanco( )
	{
		return nomeBanco ;
	}

	public void setNomeBanco( String nomeBanco )
	{
		this.nomeBanco = nomeBanco ;
	}

	public String getObservacao( )
	{
		return observacao ;
	}

	public void setObservacao( String observacao )
	{
		this.observacao = observacao ;
	}

	public String getDataDocumento( )
	{
		return dataDocumento ;
	}

	public void setDataDocumento( String dataDocumento )
	{
		this.dataDocumento = dataDocumento ;
	}

	public String getDataVencimento( )
	{
		return dataVencimento ;
	}

	public void setDataVencimento( String dataVencimento )
	{
		this.dataVencimento = dataVencimento ;
	}

	public String getValorDocumento( )
	{
		return valorDocumento ;
	}

	public void setValorDocumento( String valorDocumento )
	{
		this.valorDocumento = valorDocumento ;
	}

	public String getMulta( )
	{
		return multa ;
	}

	public void setMulta( String multa )
	{
		this.multa = multa ;
	}

	public String getValorCobrado( )
	{
		return valorCobrado ;
	}

	public void setValorCobrado( String valorCobrado )
	{
		this.valorCobrado = valorCobrado ;
	}

}
