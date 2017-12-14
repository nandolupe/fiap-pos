package br.com.fiap.projetojpa.datatypes;

import java.io.Serializable;
import javax.persistence.*;

//Identifica ao JPA que essa classe será um Entity gerenciado por ele.
@Entity

//Identifica ao JPA o nome da tabela que deverá ser gerenciada.
@Table(name="pedido_item")

//Define uma query default e atribui um nome a ela.
@NamedQuery(name="PedidoItem.findAll", query="SELECT p FROM PedidoItem p")
public class PedidoItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idPedidoItem;
	private int qtdItem;
	private Item item;
	private Pedido pedido;

	public PedidoItem() {
	}

	// Identifica que esse atributo é um ID
	@Id
	
	// Identifica ao JPA que os ID serão gerados automaticamente.
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	// Identifica o nome da Coluna para o JPA
	@Column(name="ID_PEDIDO_ITEM", unique=true, nullable=false)
	public int getIdPedidoItem() {
		return this.idPedidoItem;
	}

	public void setIdPedidoItem(int idPedidoItem) {
		this.idPedidoItem = idPedidoItem;
	}

	// Identifica o nome da Coluna para o JPA
	@Column(name="QTD_ITEM")
	public int getQtdItem() {
		return this.qtdItem;
	}

	public void setQtdItem(int qtdItem) {
		this.qtdItem = qtdItem;
	}


	//bi-directional many-to-one association to Item
	// Identifica ao JPA que Item é de Peido Item e faz o mapeamento de uma classe a outra.
	@ManyToOne(fetch=FetchType.LAZY)
	
	// Identica qual é coluna que deverá ser feito o join.
	@JoinColumn(name="ID_ITEM")
	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	
	// Identica qual é coluna que deverá ser feito o join.
	@JoinColumn(name="ID_PEDIDO")
	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}