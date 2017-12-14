package com.fiap.clinicaweb.datatype;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name="Atendimento.findAll", query="SELECT a FROM Atendimento a")
public class Atendimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ATENDIMENTO")
	private int idAtendimento;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_ATENDIMENTO")
	private Date dataAtendimento;

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

	@ManyToOne
	@JoinColumn(name="ID_PACIENTE")
	private Paciente paciente;

	public Atendimento() {
	}

	public Atendimento(int idAtendimento, Date dataAtendimento,
			Date dtAlteracao, Date dtInclusao, String usuarioAlteracao,
			String usuarioInclusao, Paciente paciente) {
		super();
		this.idAtendimento = idAtendimento;
		this.dataAtendimento = dataAtendimento;
		this.dtAlteracao = dtAlteracao;
		this.dtInclusao = dtInclusao;
		this.usuarioAlteracao = usuarioAlteracao;
		this.usuarioInclusao = usuarioInclusao;
		this.paciente = paciente;
	}

	public int getIdAtendimento() {
		return this.idAtendimento;
	}

	public void setIdAtendimento(int idAtendimento) {
		this.idAtendimento = idAtendimento;
	}

	public Date getDataAtendimento() {
		return this.dataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
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

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "Atendimento [idAtendimento=" + idAtendimento
				+ ", dataAtendimento=" + dataAtendimento + ", dtAlteracao="
				+ dtAlteracao + ", dtInclusao=" + dtInclusao
				+ ", usuarioAlteracao=" + usuarioAlteracao
				+ ", usuarioInclusao=" + usuarioInclusao + "]";
	}

}