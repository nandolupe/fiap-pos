package br.com.fiap.projetojdbc.datatypes;

import java.io.Serializable;

public class PedidoItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idPedidoItem;
	private int qtdItem;
	private Item item;
	private Pedido pedido;
	
	// getters and setters...
	
	public PedidoItem() {
	}

	public int getIdPedidoItem() {
		return this.idPedidoItem;
	}

	public void setIdPedidoItem(int idPedidoItem) {
		this.idPedidoItem = idPedidoItem;
	}

	public int getQtdItem() {
		return this.qtdItem;
	}

	public void setQtdItem(int qtdItem) {
		this.qtdItem = qtdItem;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}