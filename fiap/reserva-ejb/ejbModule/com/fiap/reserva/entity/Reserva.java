package com.fiap.reserva.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reserva database table.
 * 
 */
@Entity
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_RESERVA")
	private int idReserva;

	private String status;

	//bi-directional many-to-one association to Assento
	@ManyToOne
	@JoinColumn(name="ID_ASSENTO")
	private Assento assento;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;

	//bi-directional many-to-one association to Trecho
	@ManyToOne
	@JoinColumn(name="ID_TRECHO")
	private Trecho trecho;

	public Reserva() {
	}

	public int getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Assento getAssento() {
		return this.assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Trecho getTrecho() {
		return this.trecho;
	}

	public void setTrecho(Trecho trecho) {
		this.trecho = trecho;
	}

}