package com.fiap.clinicaweb.datatype;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="Especialista.findAll", query="SELECT e FROM Especialista e")
public class Especialista implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_ESPECIALISTA", insertable = true)
	private Long idEspecialista;

	private String contato;

	private String cpf;

	@Column(name="DESC_FUNCAO")
	private String descFuncao;

	@Column(name="NOME_ESPECIALISTA")
	private String nomeEspecialista;

	@Column(name="NOME_SUPERIOR")
	private String nomeSuperior;

	private String rg;

	private String sexo;

	private String sobrenome;

	@OneToMany(mappedBy="especialista")
	private List<AtendProcMatMed> atendProcMatMeds;

	@ManyToOne
	@JoinColumn(name="COD_TIPO_ESPEC")
	private TipoEspecialista tipoEspecialista;

	public Especialista() {
	}

	public Especialista(Long idEspecialista, String contato, String cpf,
			String descFuncao, String nomeEspecialista, String nomeSuperior,
			String rg, String sexo, String sobrenome,
			TipoEspecialista tipoEspecialista) {
		super();
		this.idEspecialista = idEspecialista;
		this.contato = contato;
		this.cpf = cpf;
		this.descFuncao = descFuncao;
		this.nomeEspecialista = nomeEspecialista;
		this.nomeSuperior = nomeSuperior;
		this.rg = rg;
		this.sexo = sexo;
		this.sobrenome = sobrenome;
		this.tipoEspecialista = tipoEspecialista;
	}


	public Long getIdEspecialista() {
		return this.idEspecialista;
	}

	public void setIdEspecialista(Long idEspecialista) {
		this.idEspecialista = idEspecialista;
	}

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDescFuncao() {
		return this.descFuncao;
	}

	public void setDescFuncao(String descFuncao) {
		this.descFuncao = descFuncao;
	}

	public String getNomeEspecialista() {
		return this.nomeEspecialista;
	}

	public void setNomeEspecialista(String nomeEspecialista) {
		this.nomeEspecialista = nomeEspecialista;
	}

	public String getNomeSuperior() {
		return this.nomeSuperior;
	}

	public void setNomeSuperior(String nomeSuperior) {
		this.nomeSuperior = nomeSuperior;
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

	public List<AtendProcMatMed> getAtendProcMatMeds() {
		return this.atendProcMatMeds;
	}

	public void setAtendProcMatMeds(List<AtendProcMatMed> atendProcMatMeds) {
		this.atendProcMatMeds = atendProcMatMeds;
	}

	public AtendProcMatMed addAtendProcMatMed(AtendProcMatMed atendProcMatMed) {
		getAtendProcMatMeds().add(atendProcMatMed);
		atendProcMatMed.setEspecialista(this);

		return atendProcMatMed;
	}

	public AtendProcMatMed removeAtendProcMatMed(AtendProcMatMed atendProcMatMed) {
		getAtendProcMatMeds().remove(atendProcMatMed);
		atendProcMatMed.setEspecialista(null);

		return atendProcMatMed;
	}

	public TipoEspecialista getTipoEspecialista() {
		return this.tipoEspecialista;
	}

	public void setTipoEspecialista(TipoEspecialista tipoEspecialista) {
		this.tipoEspecialista = tipoEspecialista;
	}

	@Override
	public String toString() {
		return "Especialista [idEspecialista=" + idEspecialista + ", contato="
				+ contato + ", cpf=" + cpf + ", descFuncao=" + descFuncao
				+ ", nomeEspecialista=" + nomeEspecialista + ", nomeSuperior="
				+ nomeSuperior + ", rg=" + rg + ", sexo=" + sexo
				+ ", sobrenome=" + sobrenome + ", atendProcMatMeds="
				+ atendProcMatMeds
				+ "]";
	}
}