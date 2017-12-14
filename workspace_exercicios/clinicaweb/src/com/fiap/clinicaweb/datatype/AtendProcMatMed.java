package com.fiap.clinicaweb.datatype;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name="atend_proc_mat_med")
@NamedQuery(name="AtendProcMatMed.findAll", query="SELECT a FROM AtendProcMatMed a")
public class AtendProcMatMed implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AtendProcMatMedPK id;

	@Column(name="DESCRICAO_ATENDIME")
	private String descricaoAtendime;

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
	@JoinColumn(name="ID_ESPECIALISTA")
	private Especialista especialista;

	public AtendProcMatMed() {
	}

	public AtendProcMatMed(AtendProcMatMedPK id, String descricaoAtendime,
			Date dtAlteracao, Date dtInclusao, String usuarioAlteracao,
			String usuarioInclusao, Especialista especialista) {
		super();
		this.id = id;
		this.descricaoAtendime = descricaoAtendime;
		this.dtAlteracao = dtAlteracao;
		this.dtInclusao = dtInclusao;
		this.usuarioAlteracao = usuarioAlteracao;
		this.usuarioInclusao = usuarioInclusao;
		this.especialista = especialista;
	}

	public AtendProcMatMedPK getId() {
		return this.id;
	}

	public void setId(AtendProcMatMedPK id) {
		this.id = id;
	}

	public String getDescricaoAtendime() {
		return this.descricaoAtendime;
	}

	public void setDescricaoAtendime(String descricaoAtendime) {
		this.descricaoAtendime = descricaoAtendime;
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

	public Especialista getEspecialista() {
		return this.especialista;
	}

	public void setEspecialista(Especialista especialista) {
		this.especialista = especialista;
	}

	@Override
	public String toString() {
		return "AtendProcMatMed [id=" + id + ", descricaoAtendime="
				+ descricaoAtendime + ", dtAlteracao=" + dtAlteracao
				+ ", dtInclusao=" + dtInclusao + ", usuarioAlteracao="
				+ usuarioAlteracao + ", usuarioInclusao=" + usuarioInclusao
				+ "]";
	}
}