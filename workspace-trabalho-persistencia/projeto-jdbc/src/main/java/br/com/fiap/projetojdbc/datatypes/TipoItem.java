package br.com.fiap.projetojdbc.datatypes;

import java.io.Serializable;

public class TipoItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idTipoItem;
	private String dscTipoItem;

	public TipoItem() {
	}

	public int getIdTipoItem() {
		return this.idTipoItem;
	}

	public void setIdTipoItem(int idTipoItem) {
		this.idTipoItem = idTipoItem;
	}

	public String getDscTipoItem() {
		return this.dscTipoItem;
	}

	public void setDscTipoItem(String dscTipoItem) {
		this.dscTipoItem = dscTipoItem;
	}
}