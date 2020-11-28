/**
 * 
 */
package com.floreria.app.model.venta;

import java.io.Serializable;
import javax.persistence.*;

/**
* The persistent class for the tipo_producto database table.
* 
*/
@Entity
@Table(name="pago_metodo")
@NamedQuery(name="PagoMetodo.findAll", query="SELECT p FROM PagoMetodo p")
public class PagoMetodo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pmet_id")
	private int pmetId;
	
	@Column(name="pmet_nombre")
	private String pmetNombre;
	
	@Column(name="pmet_decrip")
	private String pmetDecrip;
	
	@Column(name="pmet_estatus")
	private String pmetEstatus;
	
	public PagoMetodo() {
		
	}

	/**
	 * @return the pmetId
	 */
	public int getPmetId() {
		return pmetId;
	}

	/**
	 * @return the pmetNombre
	 */
	public String getPmetNombre() {
		return pmetNombre;
	}

	/**
	 * @return the pmetDecrip
	 */
	public String getPmetDecrip() {
		return pmetDecrip;
	}

	/**
	 * @return the pmetEstatus
	 */
	public String getPmetEstatus() {
		return pmetEstatus;
	}

	/**
	 * @param pmetId the pmetId to set
	 */
	public void setPmetId(int pmetId) {
		this.pmetId = pmetId;
	}

	/**
	 * @param pmetNombre the pmetNombre to set
	 */
	public void setPmetNombre(String pmetNombre) {
		this.pmetNombre = pmetNombre;
	}

	/**
	 * @param pmetDecrip the pmetDecrip to set
	 */
	public void setPmetDecrip(String pmetDecrip) {
		this.pmetDecrip = pmetDecrip;
	}

	/**
	 * @param pmetEstatus the pmetEstatus to set
	 */
	public void setPmetEstatus(String pmetEstatus) {
		this.pmetEstatus = pmetEstatus;
	}
	
}
