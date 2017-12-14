package com.fiap.clinicaweb.datatype;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tipo_especialista")
@NamedQuery(name="TipoEspecialista.findAll", query="SELECT t FROM TipoEspecialista t")
public class TipoEspecialista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_TIPO_ESPEC")
	private String codTipoEspec;

	@Column(name="DESC_TIPO_ESPEC")
	private String descTipoEspec;

	public TipoEspecialista() {
	}

	public TipoEspecialista(String codTipoEspec, String descTipoEspec) {
		super();
		this.codTipoEspec = codTipoEspec;
		this.descTipoEspec = descTipoEspec;
	}

	public String getCodTipoEspec() {
		return this.codTipoEspec;
	}

	public void setCodTipoEspec(String codTipoEspec) {
		this.codTipoEspec = codTipoEspec;
	}

	public String getDescTipoEspec() {
		return this.descTipoEspec;
	}

	public void setDescTipoEspec(String descTipoEspec) {
		this.descTipoEspec = descTipoEspec;
	}

	@Override
	public String toString() {
		return "TipoEspecialista [codTipoEspec=" + codTipoEspec
				+ ", descTipoEspec=" + descTipoEspec + "]";
	}
}