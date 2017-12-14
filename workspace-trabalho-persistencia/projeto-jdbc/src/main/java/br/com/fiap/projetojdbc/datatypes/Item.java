package br.com.fiap.projetojdbc.datatypes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idItem;
	private String dscItem;
	private String status;
	private BigDecimal valorItem;
	private TipoItem tipoItem;
	private List<PedidoItem> pedidoItems;

	public Item() {
	}

	public int getIdItem() {
		return this.idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getDscItem() {
		return this.dscItem;
	}

	public void setDscItem(String dscItem) {
		this.dscItem = dscItem;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getValorItem() {
		return this.valorItem;
	}

	public void setValorItem(BigDecimal valorItem) {
		this.valorItem = valorItem;
	}

	public TipoItem getTipoItem() {
		return this.tipoItem;
	}

	public void setTipoItem(TipoItem tipoItem) {
		this.tipoItem = tipoItem;
	}

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