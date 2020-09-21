/**
 * 
 */
package com.floreria.app.model.producto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author macpro
 *
 */
@Entity
public class ProdHijo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 971027241217420833L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer prhId;
	
	@Column
	private Integer prodIdPadre;
	
	@OneToOne
	@JoinColumn(name="prod_id")
	private Producto producto;
	
	@Column
	private String prhEstatus;
	
	@Column
	private Double prhCantidad;
	
	
	public ProdHijo() {
		
	}


	/**
	 * @return the prhId
	 */
	public Integer getPrhId() {
		return prhId;
	}


	/**
	 * @param prhId the prhId to set
	 */
	public void setPrhId(Integer prhId) {
		this.prhId = prhId;
	}


	/**
	 * @return the prodIdPadre
	 */
	public Integer getProdIdPadre() {
		return prodIdPadre;
	}


	/**
	 * @param prodIdPadre the prodIdPadre to set
	 */
	public void setProdIdPadre(Integer prodIdPadre) {
		this.prodIdPadre = prodIdPadre;
	}


	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}


	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	/**
	 * @return the prhEstatus
	 */
	public String getPrhEstatus() {
		return prhEstatus;
	}


	/**
	 * @param prhEstatus the prhEstatus to set
	 */
	public void setPrhEstatus(String prhEstatus) {
		this.prhEstatus = prhEstatus;
	}


	/**
	 * @return the prhCantidad
	 */
	public Double getPrhCantidad() {
		return prhCantidad;
	}


	/**
	 * @param prhCantidad the prhCantidad to set
	 */
	public void setPrhCantidad(Double prhCantidad) {
		this.prhCantidad = prhCantidad;
	}
	
	
	
	

}
