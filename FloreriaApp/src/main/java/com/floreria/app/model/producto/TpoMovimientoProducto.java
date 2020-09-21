package com.floreria.app.model.producto;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tpo_movimiento_producto database table.
 * 
 */
@Entity
@Table(name="tipo_movimiento_prod")
@NamedQuery(name="TpoMovimientoProducto.findAll", query="SELECT t FROM TpoMovimientoProducto t")
public class TpoMovimientoProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tmp_id")
	private int tmpId;

	@Column(name="tmp_desc")
	private String tmpDesc;

	@Column(name="tmp_suma")
	private String tmpSuma;

	public TpoMovimientoProducto() {
	}

	public int getTmpId() {
		return this.tmpId;
	}

	public void setTmpId(int tmpId) {
		this.tmpId = tmpId;
	}

	public String getTmpDesc() {
		return this.tmpDesc;
	}

	public void setTmpDesc(String tmpDesc) {
		this.tmpDesc = tmpDesc;
	}

	

	public String getTmpSuma() {
		return this.tmpSuma;
	}

	public void setTmpSuma(String tmpSuma) {
		this.tmpSuma = tmpSuma;
	}

}