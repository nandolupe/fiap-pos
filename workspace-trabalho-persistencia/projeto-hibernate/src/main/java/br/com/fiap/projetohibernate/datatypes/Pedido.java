package br.com.fiap.projetohibernate.datatypes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idPedido;
	private Date dtPedido;
	private String statusPedido;
	private Cliente cliente;
	private List<PedidoItem> pedidoItems;
	
	// getters and setters...
	
	public Pedido() {
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDtPedido() {
		return this.dtPedido;
	}

	public void setDtPedido(Date dtPedido) {
		this.dtPedido = dtPedido;
	}

	public String getStatusPedido() {
		return this.statusPedido;
	}

	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

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