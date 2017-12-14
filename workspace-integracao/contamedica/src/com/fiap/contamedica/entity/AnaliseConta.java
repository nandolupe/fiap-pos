/**
 * 
 */
package com.fiap.contamedica.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Java Bean que reflete uma conta médica do mundo real.
 * 
 * @author Luiz Fernando
 *
 */
@XmlRootElement
public class AnaliseConta {

	private Integer numProtocolo;
	private String resultadoAnalise;
	
	public Integer getNumProtocolo() {
		return numProtocolo;
	}
	
	@XmlElement
	public void setNumProtocolo(Integer numProtocolo) {
		this.numProtocolo = numProtocolo;
	}
	public String getResultadoAnalise() {
		return resultadoAnalise;
	}
	@XmlElement
	public void setResultadoAnalise(String resultadoAnalise) {
		this.resultadoAnalise = resultadoAnalise;
	}
}
