package br.com.fiap.projetojpa.datatypes;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the item database table.
 * 
 */
@Entity
@Table(name="item")
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Version
	private long version;
	
	private int idItem;
	private String dscItem;
	private String status;
	private BigDecimal valorItem;
	private TipoItem tipoItem;
	private List<PedidoItem> pedidoItems;

	public Item() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_ITEM", unique=true, nullable=false)
	public int getIdItem() {
		return this.idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}


	@Column(name="DSC_ITEM", length=100)
	public String getDscItem() {
		return this.dscItem;
	}

	public void setDscItem(String dscItem) {
		this.dscItem = dscItem;
	}


	@Column(length=1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Column(name="VALOR_ITEM", precision=10, scale=2)
	public BigDecimal getValorItem() {
		return this.valorItem;
	}

	public void setValorItem(BigDecimal valorItem) {
		this.valorItem = valorItem;
	}


	//bi-directional many-to-one association to TipoItem
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_TIPO_ITEM")
	public TipoItem getTipoItem() {
		return this.tipoItem;
	}

	public void setTipoItem(TipoItem tipoItem) {
		this.tipoItem = tipoItem;
	}


	//bi-directional many-to-one association to PedidoItem
	@OneToMany(mappedBy="item")
	public List<PedidoItem> getPedidoItems() {
		return this.pedidoItems;
	}

	public void setPedidoItems(List<PedidoItem> pedidoItems) {
		this.pedidoItems = pedidoItems;
	}

	public PedidoItem addPedidoItem(PedidoItem pedidoItem) {
		getPedidoItems().add(pedidoItem);
		pedidoItem.setItem(this);

		return pedidoItem;
	}

	public PedidoItem removePedidoItem(PedidoItem pedidoItem) {
		getPedidoItems().remove(pedidoItem);
		pedidoItem.setItem(null);

		return pedidoItem;
	}

}