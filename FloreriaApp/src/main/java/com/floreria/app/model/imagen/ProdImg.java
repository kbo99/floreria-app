/**
 * 
 */
package com.floreria.app.model.imagen;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.floreria.app.model.producto.Producto;

/**
 * @author macpro
 *
 */
@Entity
public class ProdImg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4950784120548704350L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer prmId;
	
	@OneToOne
	@JoinColumn(name="prod_id")
	private Producto producto;
	
	@OneToOne
	@JoinColumn(name="img_id")
	private Imagen imagen;
	
	

	public ProdImg() {
		
	}

	/**
	 * @return the prmId
	 */
	public Integer getPrmId() {
		return prmId;
	}

	/**
	 * @param prmId the prmId to set
	 */
	public void setPrmId(Integer prmId) {
		this.prmId = prmId;
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
	 * @return the imagen
	 */
	public Imagen getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}
	
	

}
