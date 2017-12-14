package br.com.fiap.projetojpa.datatypes;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

// Identifica ao JPA que essa classe será um Entity gerenciado por ele.
@Entity

// Identifica ao JPA o nome da tabela que deverá ser gerenciada.
@Table(name="pedido")

// Define uma query default e atribui um nome a ela.
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idPedido;
	private Date dtPedido;
	private String statusPedido;
	private Cliente cliente;
	private List<PedidoItem> pedidoItems;

	public Pedido() {
	}

	
	// Identifica que esse atributo é um ID
	@Id
	
	// Identifica ao JPA que os ID serão gerados automaticamente.
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	// Identifica o nome da Coluna para o JPA
	@Column(name="ID_PEDIDO", unique=true, nullable=false)
	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	// Identifica o tipo do campo ao JPA
	@Temporal(TemporalType.DATE)
	
	// Identifica o nome da Coluna para o JPA
	@Column(name="DT_PEDIDO")
	public Date getDtPedido() {
		return this.dtPedido;
	}

	public void setDtPedido(Date dtPedido) {
		this.dtPedido = dtPedido;
	}


	// Identifica o nome da Coluna para o JPA e configura o tamanho dela para 1
	@Column(name="STATUS_PEDIDO", length=1)
	public String getStatusPedido() {
		return this.statusPedido;
	}

	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}

	// Identifica ao JPA que Pedido é de um Cliente e faz o mapeamento de uma classe a outra.
	@ManyToOne(fetch=FetchType.LAZY)
	
	// Identica qual é coluna que deverá ser feito o join.
	@JoinColumn(name="ID_CLIENTE")
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	// Cria uma lista de pedidoItems
	@OneToMany(mappedBy="pedido")
	public List<PedidoItem> getPedidoItems() {
		return this.pedidoItems;
	}

	public void setPedidoItems(List<PedidoItem> pedidoItems) {
		this.pedidoItems = pedidoItems;
	}

	public PedidoItem addPedidoItem(PedidoItem pedidoItem) {
		getPedidoItems().add(pedidoItem);
		pedidoItem.setPedido(this);

		return pedidoItem;
	}

	public PedidoItem removePedidoItem(PedidoItem pedidoItem) {
		getPedidoItems().remove(pedidoItem);
		pedidoItem.setPedido(null);

		return pedidoItem;
	}

}