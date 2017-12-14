package com.fiap.clinicaweb.datatype;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class AtendProcMatMedPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="COD_PROCEDIMENTO")
	private String codProcedimento;

	@Column(name="COD_MAT_MED")
	private String codMatMed;

	@Column(name="ID_ATENDIMENTO")
	private int idAtendimento;

	public AtendProcMatMedPK() {
	}
	
	public AtendProcMatMedPK(String codProcedimento, String codMatMed,
			int idAtendimento) {
		super();
		this.codProcedimento = codProcedimento;
		this.codMatMed = codMatMed;
		this.idAtendimento = idAtendimento;
	}


	public String getCodProcedimento() {
		return this.codProcedimento;
	}
	public void setCodProcedimento(String codProcedimento) {
		this.codProcedimento = codProcedimento;
	}
	public String getCodMatMed() {
		return this.codMatMed;
	}
	public void setCodMatMed(String codMatMed) {
		this.codMatMed = codMatMed;
	}
	public int getIdAtendimento() {
		return this.idAtendimento;
	}
	public void setIdAtendimento(int idAtendimento) {
		this.idAtendimento = idAtendimento;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AtendProcMatMedPK)) {
			return false;
		}
		AtendProcMatMedPK castOther = (AtendProcMatMedPK)other;
		return 
			this.codProcedimento.equals(castOther.codProcedimento)
			&& this.codMatMed.equals(castOther.codMatMed)
			&& (this.idAtendimento == castOther.idAtendimento);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codProcedimento.hashCode();
		hash = hash * prime + this.codMatMed.hashCode();
		hash = hash * prime + this.idAtendimento;
		
		return hash;
	}

	@Override
	public String toString() {
		return "AtendProcMatMedPK [codProcedimento=" + codProcedimento
				+ ", codMatMed=" + codMatMed + ", idAtendimento="
				+ idAtendimento + "]";
	}
}