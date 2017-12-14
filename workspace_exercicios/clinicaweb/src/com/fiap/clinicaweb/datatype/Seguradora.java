package com.fiap.clinicaweb.datatype;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name="Seguradora.findAll", query="SELECT s FROM Seguradora s")
public class Seguradora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_SEGURADORA")
	private String codSeguradora;

	private String cnpj;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_ALTERACAO")
	private Date dtAlteracao;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_INCLUSAO")
	private Date dtInclusao;

	@Column(name="FL_VIGENTE")
	private String flVigente;

	@Column(name="NOME_SEGURADORA")
	private String nomeSeguradora;

	@OneToMany(mappedBy="seguradora")
	private List<Paciente> pacientes;

	public Seguradora() {
	}

	public Seguradora(String codSeguradora, String cnpj, Date dtAlteracao,
			Date dtInclusao, String flVigente, String nomeSeguradora) {
		super();
		this.codSeguradora = codSeguradora;
		this.cnpj = cnpj;
		this.dtAlteracao = dtAlteracao;
		this.dtInclusao = dtInclusao;
		this.flVigente = flVigente;
		this.nomeSeguradora = nomeSeguradora;
	}

	public String getCodSeguradora() {
		return this.codSeguradora;
	}

	public void setCodSeguradora(String codSeguradora) {
		this.codSeguradora = codSeguradora;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public String getFlVigente() {
		return this.flVigente;
	}

	public void setFlVigente(String flVigente) {
		this.flVigente = flVigente;
	}

	public String getNomeSeguradora() {
		return this.nomeSeguradora;
	}

	public void setNomeSeguradora(String nomeSeguradora) {
		this.nomeSeguradora = nomeSeguradora;
	}

	public List<Paciente> getPacientes() {
		return this.pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Paciente addPaciente(Paciente paciente) {
		getPacientes().add(paciente);
		paciente.setSeguradora(this);

		return paciente;
	}

	public Paciente removePaciente(Paciente paciente) {
		getPacientes().remove(paciente);
		paciente.setSeguradora(null);

		return paciente;
	}

	@Override
	public String toString() {
		return "Seguradora [codSeguradora=" + codSeguradora + ", cnpj=" + cnpj
				+ ", dtAlteracao=" + dtAlteracao + ", dtInclusao=" + dtInclusao
				+ ", flVigente=" + flVigente + ", nomeSeguradora="
				+ nomeSeguradora + "]";
	}
}