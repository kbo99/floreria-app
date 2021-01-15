/**
 * 
 */
package com.floreria.app.model.venta;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author ocruz
 *
 */
@Entity
public class Captacion implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cap_id")
	private Integer capId;
	
	@Column(name="cap_nombre")
	private String capNombre;
	
	@Column(name="cap_decrip")
	private String capDecrip;
	
	@Column(name="cap_estatus")
	private String capEstatus;
	
	public Captacion() {
		
	}

	/**
	 * @return the capId
	 */
	public Integer getCapId() {
		return capId;
	}

	/**
	 * @return the capNombre
	 */
	public String getCapNombre() {
		return capNombre;
	}

	/**
	 * @return the capDecrip
	 */
	public String getCapDecrip() {
		return capDecrip;
	}

	/**
	 * @return the capEstatus
	 */
	public String getCapEstatus() {
		return capEstatus;
	}

	/**
	 * @param capId the capId to set
	 */
	public void setCapId(Integer capId) {
		this.capId = capId;
	}

	/**
	 * @param capNombre the capNombre to set
	 */
	public void setCapNombre(String capNombre) {
		this.capNombre = capNombre;
	}

	/**
	 * @param capDecrip the capDecrip to set
	 */
	public void setCapDecrip(String capDecrip) {
		this.capDecrip = capDecrip;
	}

	/**
	 * @param capEstatus the capEstatus to set
	 */
	public void setCapEstatus(String capEstatus) {
		this.capEstatus = capEstatus;
	}
	
}
