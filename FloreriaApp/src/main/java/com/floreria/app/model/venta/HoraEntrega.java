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
@Table(name="hora_entrega")
@NamedQuery(name="HoraEntrega.findAll", query="SELECT h FROM HoraEntrega h")
public class HoraEntrega implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hren_id")
	private Integer hrenId;
	
	@Column(name="hren_id_padre")
	private Integer hrenIdPadre;
	
	@Column(name="hren_hora")
	private String hrenHora;
	
	@Column(name="hren_isintervalo")
	private boolean isIntervalo;
	
	@Column(name="hren_estatus")
	private String hrenEstatus;

	/**
	 * @return the hrenId
	 */
	public int getHrenId() {
		return hrenId;
	}

	/**
	 * @param hrenId the hrenId to set
	 */
	public void setHrenId(int hrenId) {
		this.hrenId = hrenId;
	}

	/**
	 * @return the hrenIdPadre
	 */
	public Integer getHrenIdPadre() {
		return hrenIdPadre;
	}

	/**
	 * @param hrenIdPadre the hrenIdPadre to set
	 */
	public void setHrenIdPadre(Integer hrenIdPadre) {
		this.hrenIdPadre = hrenIdPadre;
	}

	/**
	 * @return the hrenHora
	 */
	public String getHrenHora() {
		return hrenHora;
	}

	/**
	 * @param hrenHora the hrenHora to set
	 */
	public void setHrenHora(String hrenHora) {
		this.hrenHora = hrenHora;
	}

	/**
	 * @return the isIntervalo
	 */
	public boolean isIntervalo() {
		return isIntervalo;
	}

	/**
	 * @param isIntervalo the isIntervalo to set
	 */
	public void setIntervalo(boolean isIntervalo) {
		this.isIntervalo = isIntervalo;
	}

	/**
	 * @return the hrenEstatus
	 */
	public String getHrenEstatus() {
		return hrenEstatus;
	}

	/**
	 * @param hrenEstatus the hrenEstatus to set
	 */
	public void setHrenEstatus(String hrenEstatus) {
		this.hrenEstatus = hrenEstatus;
	}	

}
