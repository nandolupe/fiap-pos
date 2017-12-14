package reservaentity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reserva database table.
 * 
 */
@Entity
@Table(name="reserva")
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_RESERVA", unique=true, nullable=false, precision=10)
	private Long idReserva;

	@Column(name="COD_MESA", length=20)
	private String codMesa;

	@Column(length=13)
	private String contato;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_RESERVA")
	private Date dtReserva;

	@Column(name="NOME_CLIENTE", length=150)
	private String nomeCliente;

	//bi-directional many-to-one association to Estabelecimento
	@ManyToOne
	@JoinColumn(name="CNPJ_CPF")
	private Estabelecimento estabelecimento;

	public Reserva() {
	}

	public Long getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	public String getCodMesa() {
		return this.codMesa;
	}

	public void setCodMesa(String codMesa) {
		this.codMesa = codMesa;
	}

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Date getDtReserva() {
		return this.dtReserva;
	}

	public void setDtReserva(Date dtReserva) {
		this.dtReserva = dtReserva;
	}

	public String getNomeCliente() {
		return this.nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Estabelecimento getEstabelecimento() {
		return this.estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

}