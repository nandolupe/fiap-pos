package br.com.fiap.projetojpa.datatypes;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="tipo_item")
@NamedQuery(name="TipoItem.findAll", query="SELECT t FROM TipoItem t")
// Identifica ao JPA que deverá ter o controle de cache.
@Cacheable
public class TipoItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idTipoItem;
	private String dscTipoItem;

	public TipoItem() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_TIPO_ITEM", unique=true, nullable=false)
	public int getIdTipoItem() {
		return this.idTipoItem;
	}

	public void setIdTipoItem(int idTipoItem) {
		this.idTipoItem = idTipoItem;
	}


	@Column(name="DSC_TIPO_ITEM", length=100)
	public String getDscTipoItem() {
		return this.dscTipoItem;
	}

	public void setDscTipoItem(String dscTipoItem) {
		this.dscTipoItem = dscTipoItem;
	}

}