package com.fiap.reserva.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the trecho database table.
 * 
 */
@Entity
@NamedQuery(name="Trecho.findAll", query="SELECT t FROM Trecho t")
public class Trecho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_TRECHO")
	private int idTrecho;

	private String destino;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_CHEGADA")
	private Date dtChegada;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_SAIDA")
	private Date dtSaida;

	@Column(name="EMPRESA_AEREA")
	private String empresaAerea;

	private String origem;

	@Column(name="QT_ASSENTO_ECONOMICA")
	private BigDecimal qtAssentoEconomica;

	@Column(name="QT_ASSENTO_EXECUTIVA")
	private String qtAssentoExecutiva;

	private BigDecimal valor;

	//bi-directional many-to-one association to Assento
	@OneToMany(mappedBy="trecho")
	private List<Assento> assentos;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="trecho")
	private List<Reserva> reservas;

	public Trecho() {
	}

	public int getIdTrecho() {
		return this.idTrecho;
	}

	public void setIdTrecho(int idTrecho) {
		this.idTrecho = idTrecho;
	}

	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Date getDtChegada() {
		return this.dtChegada;
	}

	public void setDtChegada(Date dtChegada) {
		this.dtChegada = dtChegada;
	}

	public Date getDtSaida() {
		return this.dtSaida;
	}

	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}

	public String getEmpresaAerea() {
		return this.empresaAerea;
	}

	public void setEmpresaAerea(String empresaAerea) {
		this.empresaAerea = empresaAerea;
	}

	public String getOrigem() {
		return this.origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public BigDecimal getQtAssentoEconomica() {
		return this.qtAssentoEconomica;
	}

	public void setQtAssentoEconomica(BigDecimal qtAssentoEconomica) {
		this.qtAssentoEconomica = qtAssentoEconomica;
	}

	public String getQtAssentoExecutiva() {
		return this.qtAssentoExecutiva;
	}

	public void setQtAssentoExecutiva(String qtAssentoExecutiva) {
		this.qtAssentoExecutiva = qtAssentoExecutiva;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<Assento> getAssentos() {
		return this.assentos;
	}

	public void setAssentos(List<Assento> assentos) {
		this.assentos = assentos;
	}

	public Assento addAssento(Assento assento) {
		getAssentos().add(assento);
		assento.setTrecho(this);

		return assento;
	}

	public Assento removeAssento(Assento assento) {
		getAssentos().remove(assento);
		assento.setTrecho(null);

		return assento;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setTrecho(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setTrecho(null);

		return reserva;
	}

}