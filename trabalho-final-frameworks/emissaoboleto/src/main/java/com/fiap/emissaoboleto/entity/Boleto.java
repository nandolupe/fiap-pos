package com.fiap.emissaoboleto.entity;

import java.io.Serializable;

public class Boleto implements Serializable {
	
	private Integer codigo;
	private String nomeCliente;
	private Double valorDocumento;
	private String descricaoDetalhe;
	
	public Boleto(Integer codigo, String nomeCliente, Double valorDocumento,
			String descricaoDetalhe) {
		super();
		this.codigo = codigo;
		this.nomeCliente = nomeCliente;
		this.valorDocumento = valorDocumento;
		this.descricaoDetalhe = descricaoDetalhe;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public Double getValorDocumento() {
		return valorDocumento;
	}
	public void setValorDocumento(Double valorDocumento) {
		this.valorDocumento = valorDocumento;
	}
	public String getDescricaoDetalhe() {
		return descricaoDetalhe;
	}
	public void setDescricaoDetalhe(String descricaoDetalhe) {
		this.descricaoDetalhe = descricaoDetalhe;
	}
}
