package com.fiap.clinicaweb.datatype;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name="Procedimento.findAll", query="SELECT p FROM Procedimento p")
public class Procedimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_PROCEDIMENTO")
	private String codProcedimento;

	@Column(name="DESC_PROCEDIMENTO")
	private String descProcedimento;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_ALTERACAO")
	private Date dtAlteracao;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_INCLUSAO")
	private Date dtInclusao;

	@Column(name="USUARIO_ALTERACAO")
	private String usuarioAlteracao;

	@Column(name="USUARIO_INCLUSAO")
	private String usuarioInclusao;

	@Column(name="VALOR_PROCEDIMENTO")
	private double valorProcedimento;

	public Procedimento() {
	}

	public Procedimento(String codProcedimento, Date dtAlteracao,
			Date dtInclusao, String usuarioAlteracao, String usuarioInclusao,
			double valorProcedimento, String descProcedimento) {
		super();
		this.codProcedimento = codProcedimento;
		this.dtAlteracao = dtAlteracao;
		this.dtInclusao = dtInclusao;
		this.usuarioAlteracao = usuarioAlteracao;
		this.usuarioInclusao = usuarioInclusao;
		this.valorProcedimento = valorProcedimento;
		this.descProcedimento = descProcedimento;
	}

	public String getCodProcedimento() {
		return this.codProcedimento;
	}

	public void setCodProcedimento(String codProcedimento) {
		this.codProcedimento = codProcedimento;
	}

	public Date getDtAlteracao() {
		return this.dtAlteracao;
	}

	public void setDtAlteracao(Date dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

	public Date getDtInclusao() {
		return this.dtInclusao;
	}

	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	public String getUsuarioAlteracao() {
		return this.usuarioAlteracao;
	}

	public void setUsuarioAlteracao(String usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

	public String getUsuarioInclusao() {
		return this.usuarioInclusao;
	}

	public void setUsuarioInclusao(String usuarioInclusao) {
		this.usuarioInclusao = usuarioInclusao;
	}

	public double getValorProcedimento() {
		return this.valorProcedimento;
	}

	public void setValorProcedimento(double valorProcedimento) {
		this.valorProcedimento = valorProcedimento;
	}

	public String getDescProcedimento() {
		return descProcedimento;
	}

	public void setDescProcedimento(String descProcedimento) {
		this.descProcedimento = descProcedimento;
	}

	@Override
	public String toString() {
		return "Procedimento [codProcedimento=" + codProcedimento
				+ ", descProcedimento=" + descProcedimento + ", dtAlteracao="
				+ dtAlteracao + ", dtInclusao=" + dtInclusao
				+ ", usuarioAlteracao=" + usuarioAlteracao
				+ ", usuarioInclusao=" + usuarioInclusao
				+ ", valorProcedimento=" + valorProcedimento + "]";
	}
}