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

/**
 * @author ocruz
 *
 */
@Entity
public class OrdenEstatus implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="oes_id")
	private Integer oesId;
	
	@Column(name="oes_nombre")
	private String oesNombre;
	
	@Column(name="oes_descripcion")
	private String oesDescripcion;
	
	@Column(name="oes_estatus")
	private String oesEstatus;

	/**
	 * @return the oesId
	 */
	public Integer getOesId() {
		return oesId;
	}

	/**
	 * @return the oesNombre
	 */
	public String getOesNombre() {
		return oesNombre;
	}

	/**
	 * @return the oesDescripcion
	 */
	public String getOesDescripcion() {
		return oesDescripcion;
	}

	/**
	 * @return the oesEstatus
	 */
	public String getOesEstatus() {
		return oesEstatus;
	}

	/**
	 * @param oesId the oesId to set
	 */
	public void setOesId(Integer oesId) {
		this.oesId = oesId;
	}

	/**
	 * @param oesNombre the oesNombre to set
	 */
	public void setOesNombre(String oesNombre) {
		this.oesNombre = oesNombre;
	}

	/**
	 * @param oesDescripcion the oesDescripcion to set
	 */
	public void setOesDescripcion(String oesDescripcion) {
		this.oesDescripcion = oesDescripcion;
	}

	/**
	 * @param oesEstatus the oesEstatus to set
	 */
	public void setOesEstatus(String oesEstatus) {
		this.oesEstatus = oesEstatus;
	}

}
