package com.fiap.reserva.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the assento database table.
 * 
 */
@Entity
@NamedQuery(name="Assento.findAll", query="SELECT a FROM Assento a")
public class Assento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_ASSENTO")
	private int idAssento;

	private String status;

	@Column(name="TIPO_CLASSE")
	private String tipoClasse;

	//bi-directional many-to-one association to Trecho
	@ManyToOne
	@JoinColumn(name="ID_TRECHO")
	private Trecho trecho;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="assento")
	private List<Reserva> reservas;

	public Assento() {
	}

	public int getIdAssento() {
		return this.idAssento;
	}

	public void setIdAssento(int idAssento) {
		this.idAssento = idAssento;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipoClasse() {
		return this.tipoClasse;
	}

	public void setTipoClasse(String tipoClasse) {
		this.tipoClasse = tipoClasse;
	}

	public Trecho getTrecho() {
		return this.trecho;
	}

	public void setTrecho(Trecho trecho) {
		this.trecho = trecho;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setAssento(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setAssento(null);

		return reserva;
	}

}