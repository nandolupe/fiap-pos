package com.fiap.clinicaweb.datatype;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="mat_med")
@NamedQuery(name="MatMed.findAll", query="SELECT m FROM MatMed m")
public class MatMed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_MAT_MED")
	private String codMatMed;

	@Column(name="DESC_MAT_MED")
	private String descMatMed;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_ALTERACAO")
	private Date dtAlteracao;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_INCLUSAO")
	private Date dtInclusao;

	@Column(name="FL_TIPO_MAT_MED")
	private String flTipoMatMed;

	@Column(name="QTD_MAT_MED")
	private int qtdMatMed;

	@Column(name="USUARIO_ALTERACAO")
	private String usuarioAlteracao;

	@Column(name="USUARIO_INCLUSAO")
	private String usuarioInclusao;

	@Column(name="VALOR_MAT_MED")
	private BigDecimal valorMatMed;

	public MatMed() {
	}

	public MatMed(String codMatMed, String descMatMed, Date dtAlteracao,
			Date dtInclusao, String flTipoMatMed, int qtdMatMed,
			String usuarioAlteracao, String usuarioInclusao,
			BigDecimal valorMatMed) {
		super();
		this.codMatMed = codMatMed;
		this.descMatMed = descMatMed;
		this.dtAlteracao = dtAlteracao;
		this.dtInclusao = dtInclusao;
		this.flTipoMatMed = flTipoMatMed;
		this.qtdMatMed = qtdMatMed;
		this.usuarioAlteracao = usuarioAlteracao;
		this.usuarioInclusao = usuarioInclusao;
		this.valorMatMed = valorMatMed;
	}

	public String getCodMatMed() {
		return this.codMatMed;
	}

	public void setCodMatMed(String codMatMed) {
		this.codMatMed = codMatMed;
	}

	public String getDescMatMed() {
		return this.descMatMed;
	}

	public void setDescMatMed(String descMatMed) {
		this.descMatMed = descMatMed;
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

	public String getFlTipoMatMed() {
		return this.flTipoMatMed;
	}

	public void setFlTipoMatMed(String flTipoMatMed) {
		this.flTipoMatMed = flTipoMatMed;
	}

	public int getQtdMatMed() {
		return this.qtdMatMed;
	}

	public void setQtdMatMed(int qtdMatMed) {
		this.qtdMatMed = qtdMatMed;
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

	public BigDecimal getValorMatMed() {
		return this.valorMatMed;
	}

	public void setValorMatMed(BigDecimal valorMatMed) {
		this.valorMatMed = valorMatMed;
	}

	@Override
	public String toString() {
		return "MatMed [codMatMed=" + codMatMed + ", descMatMed=" + descMatMed
				+ ", dtAlteracao=" + dtAlteracao + ", dtInclusao=" + dtInclusao
				+ ", flTipoMatMed=" + flTipoMatMed + ", qtdMatMed=" + qtdMatMed
				+ ", usuarioAlteracao=" + usuarioAlteracao
				+ ", usuarioInclusao=" + usuarioInclusao + ", valorMatMed="
				+ valorMatMed + "]";
	}
}