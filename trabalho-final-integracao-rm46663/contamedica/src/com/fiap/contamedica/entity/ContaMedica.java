/**
 * 
 */
package com.fiap.contamedica.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Java Bean que reflete uma conta m�dica do mundo real.
 * 
 * @author Luiz Fernando
 *
 */
@XmlRootElement
public class ContaMedica {

	private Integer codContaMedica;
	private String dscPrestador;
	private String emailPrestador;
	private Double valorInformado;
	private Double valorAcatado;
	private String descricaoContaMedica;
	private String tipoConta;
	
	public ContaMedica() {}
	
	public ContaMedica(Integer codContaMedica, String dscPrestador,
			String emailPrestador, Double valorInformado, Double valorAcatado,
			String descricaoContaMedica, String tipoConta) {
		super();
		this.codContaMedica = codContaMedica;
		this.dscPrestador = dscPrestador;
		this.emailPrestador = emailPrestador;
		this.valorInformado = valorInformado;
		this.valorAcatado = valorAcatado;
		this.descricaoContaMedica = descricaoContaMedica;
		this.tipoConta = tipoConta;
	}
	
	public Integer getCodContaMedica() {
		return codContaMedica;
	}
	
	@XmlElement
	public void setCodContaMedica(Integer codContaMedica) {
		this.codContaMedica = codContaMedica;
	}
	public String getDscPrestador() {
		return dscPrestador;
	}
	
	@XmlElement
	public void setDscPrestador(String dscPrestador) {
		this.dscPrestador = dscPrestador;
	}
	public String getEmailPrestador() {
		return emailPrestador;
	}
	
	@XmlElement
	public void setEmailPrestador(String emailPrestador) {
		this.emailPrestador = emailPrestador;
	}
	public Double getValorInformado() {
		return valorInformado;
	}
	
	@XmlElement
	public void setValorInformado(Double valorInformado) {
		this.valorInformado = valorInformado;
	}
	public Double getValorAcatado() {
		return valorAcatado;
	}
	
	@XmlElement
	public void setValorAcatado(Double valorAcatado) {
		this.valorAcatado = valorAcatado;
	}
	public String getDescricaoContaMedica() {
		return descricaoContaMedica;
	}
	
	@XmlElement
	public void setDescricaoContaMedica(String descricaoContaMedica) {
		this.descricaoContaMedica = descricaoContaMedica;
	}
	public String getTipoConta() {
		return tipoConta;
	}
	
	@XmlElement
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	@Override
	public String toString() {
		return "ContaMedica [codContaMedica=" + codContaMedica
				+ ", dscPrestador=" + dscPrestador + ", emailPrestador="
				+ emailPrestador + ", valorInformado=" + valorInformado
				+ ", valorAcatado=" + valorAcatado + ", descricaoContaMedica="
				+ descricaoContaMedica + ", tipoConta=" + tipoConta + "]";
	}
}
