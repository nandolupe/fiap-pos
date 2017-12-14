package br.com.fiap.vo ;

public class Cliente
{

	private Integer codigo ;
	private String nome ;
	private String endereco ;
	private String cidade ;
	private String estado ;
	private String cnpj ;

	public Integer getCodigo( )
	{
		return codigo ;
	}

	public void setCodigo( Integer codigo )
	{
		this.codigo = codigo ;
	}

	public String getNome( )
	{
		return nome ;
	}

	public void setNome( String nome )
	{
		this.nome = nome ;
	}

	public String getEndereco( )
	{
		return endereco ;
	}

	public void setEndereco( String endereco )
	{
		this.endereco = endereco ;
	}

	public String getCidade( )
	{
		return cidade ;
	}

	public void setCidade( String cidade )
	{
		this.cidade = cidade ;
	}

	public String getEstado( )
	{
		return estado ;
	}

	public void setEstado( String estado )
	{
		this.estado = estado ;
	}

	public String getCnpj( )
	{
		return cnpj ;
	}

	public void setCnpj( String cnpj )
	{
		this.cnpj = cnpj ;
	}

}
