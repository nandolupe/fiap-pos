package com.fiap.clinicaweb.datatype;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PACIENTE")
	private int idPaciente;

	private String bairro;

	private String celular;

	private String cep;

	private String cidade;

	private String cpf;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_NASC")
	private Date dataNasc;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_ALTERACAO")
	private Date dtAlteracao;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_INCLUSAO")
	private Date dtInclusao;

	private String endereco;

	@Column(name="ESTADO_CIVIL")
	private String estadoCivil;

	@Column(name="FL_VIGENTE")
	private String flVigente;

	@Column(name="NM_PACIENTE")
	private String nmPaciente;

	@Column(name="NOME_MAE")
	private String nomeMae;

	@Column(name="NOME_PAI")
	private String nomePai;

	private String rg;

	private String sexo;

	private String sobrenome;

	private String telefone;

	private String uf;

	@Column(name="USUARIO_ALTERACAO")
	private String usuarioAlteracao;

	@Column(name="USUARIO_INCLUSAO")
	private String usuarioInclusao;

	@OneToMany(mappedBy="paciente")
	private List<Atendimento> atendimentos;

	@ManyToOne
	@JoinColumn(name="COD_SEGURADORA")
	private Seguradora seguradora;

	public Paciente() {
	}

	public Paciente(int idPaciente, String bairro, String celular, String cep,
			String cidade, String cpf, Date dataNasc, Date dtAlteracao,
			Date dtInclusao, String endereco, String estadoCivil,
			String flVigente, String nmPaciente, String nomeMae,
			String nomePai, String rg, String sexo, String sobrenome,
			String telefone, String uf, String usuarioAlteracao,
			String usuarioInclusao, Seguradora seguradora) {
		super();
		this.idPaciente = idPaciente;
		this.bairro = bairro;
		this.celular = celular;
		this.cep = cep;
		this.cidade = cidade;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.dtAlteracao = dtAlteracao;
		this.dtInclusao = dtInclusao;
		this.endereco = endereco;
		this.estadoCivil = estadoCivil;
		this.flVigente = flVigente;
		this.nmPaciente = nmPaciente;
		this.nomeMae = nomeMae;
		this.nomePai = nomePai;
		this.rg = rg;
		this.sexo = sexo;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.uf = uf;
		this.usuarioAlteracao = usuarioAlteracao;
		this.usuarioInclusao = usuarioInclusao;
		this.seguradora = seguradora;
	}

	public int getIdPaciente() {
		return this.idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return this.dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
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

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getFlVigente() {
		return this.flVigente;
	}

	public void setFlVigente(String flVigente) {
		this.flVigente = flVigente;
	}

	public String getNmPaciente() {
		return this.nmPaciente;
	}

	public void setNmPaciente(String nmPaciente) {
		this.nmPaciente = nmPaciente;
	}

	public String getNomeMae() {
		return this.nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return this.nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSobrenome() {
		return this.sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
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

	public List<Atendimento> getAtendimentos() {
		return this.atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public Atendimento addAtendimento(Atendimento atendimento) {
		getAtendimentos().add(atendimento);
		atendimento.setPaciente(this);

		return atendimento;
	}

	public Atendimento removeAtendimento(Atendimento atendimento) {
		getAtendimentos().remove(atendimento);
		atendimento.setPaciente(null);

		return atendimento;
	}

	public Seguradora getSeguradora() {
		return this.seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	@Override
	public String toString() {
		return "Paciente [idPaciente=" + idPaciente + ", bairro=" + bairro
				+ ", celular=" + celular + ", cep=" + cep + ", cidade="
				+ cidade + ", cpf=" + cpf + ", dataNasc=" + dataNasc
				+ ", dtAlteracao=" + dtAlteracao + ", dtInclusao=" + dtInclusao
				+ ", endereco=" + endereco + ", estadoCivil=" + estadoCivil
				+ ", flVigente=" + flVigente + ", nmPaciente=" + nmPaciente
				+ ", nomeMae=" + nomeMae + ", nomePai=" + nomePai + ", rg="
				+ rg + ", sexo=" + sexo + ", sobrenome=" + sobrenome
				+ ", telefone=" + telefone + ", uf=" + uf
				+ ", usuarioAlteracao=" + usuarioAlteracao
				+ ", usuarioInclusao=" + usuarioInclusao + "]";
	}
}