package br.com.fiap ;

import org.apache.commons.lang.SystemUtils ;

public class Util
{

	public String obterNomeSO( )
	{
		return SystemUtils.OS_NAME ;
	}

	public String obterVersaoSO( )
	{
		return SystemUtils.OS_VERSION ;
	}

}
