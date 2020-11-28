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
@Table(name="pago_tipo")
@NamedQuery(name="PagoTipo.findAll", query="SELECT p FROM PagoTipo p")
public class PagoTipo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ptip_id")
	private int ptipId;
	
	@Column(name="ptip_nombre")
	private String ptipNombre;
	
	@Column(name="ptip_decrip")
	private String ptipDecrip;
	
	@Column(name="ptip_estatus")
	private String ptipEstatus;
	
	public PagoTipo() {
		
	}

	/**
	 * @return the ptipId
	 */
	public int getPtipId() {
		return ptipId;
	}

	/**
	 * @return the ptipNombre
	 */
	public String getPtipNombre() {
		return ptipNombre;
	}

	/**
	 * @return the ptipDecrip
	 */
	public String getPtipDecrip() {
		return ptipDecrip;
	}

	/**
	 * @return the ptipEstatus
	 */
	public String getPtipEstatus() {
		return ptipEstatus;
	}

	/**
	 * @param ptipId the ptipId to set
	 */
	public void setPtipId(int ptipId) {
		this.ptipId = ptipId;
	}

	/**
	 * @param ptipNombre the ptipNombre to set
	 */
	public void setPtipNombre(String ptipNombre) {
		this.ptipNombre = ptipNombre;
	}

	/**
	 * @param ptipDecrip the ptipDecrip to set
	 */
	public void setPtipDecrip(String ptipDecrip) {
		this.ptipDecrip = ptipDecrip;
	}

	/**
	 * @param ptipEstatus the ptipEstatus to set
	 */
	public void setPtipEstatus(String ptipEstatus) {
		this.ptipEstatus = ptipEstatus;
	}

}
