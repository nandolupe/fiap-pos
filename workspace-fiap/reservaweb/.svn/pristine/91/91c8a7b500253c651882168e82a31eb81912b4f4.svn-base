package br.com.fiap.reservaweb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="estabelecimento")
@NamedQuery(name="Estabelecimento.findAll", query="SELECT e FROM Estabelecimento e")
public class Estabelecimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CNPJ_CPF", unique=true, nullable=false, length=18)
	private String cnpjCpf;

	@Column(length=150)
	private String email;

	@Column(length=100)
	private String login;

	@Column(length=100)
	private String nome;

	@Column(name="RAZAO_SOCIAL", length=100)
	private String razaoSocial;

	@Column(length=100)
	private String senha;

	@OneToMany(mappedBy="estabelecimento")
	private List<Reserva> reservas;

	public Estabelecimento() {
	}

	public String getCnpjCpf() {
		return this.cnpjCpf;
	}

	public void setCnpjCpf(String cnpjCpf) {
		this.cnpjCpf = cnpjCpf;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setEstabelecimento(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setEstabelecimento(null);

		return reserva;
	}

}