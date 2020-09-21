package com.floreria.app.model.producto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the hproducto database table.
 * 
 */
@Entity
@NamedQuery(name="Hproducto.findAll", query="SELECT h FROM Hproducto h")
public class Hproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hps_id")
	private int hpsId;

	@Column(name="hps_cant_anterior")
	private int hpsCantAnterior;

	@Column(name="hps_cantidad_movimiento")
	private int hpsCantidadMovimiento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="hps_fecha")
	private Date hpsFecha;

	@Column(name="prod_id")
	private int prodId;
	
	@Column
	private int hpsCantidadExi;

	@ManyToOne
	@JoinColumn(name="tmp_id")
	private TpoMovimientoProducto tmpId;

	private String usuario;

	public Hproducto() {
	}

	public int getHpsId() {
		return this.hpsId;
	}

	public void setHpsId(int hpsId) {
		this.hpsId = hpsId;
	}

	public int getHpsCantAnterior() {
		return this.hpsCantAnterior;
	}

	public void setHpsCantAnterior(int hpsCantAnterior) {
		this.hpsCantAnterior = hpsCantAnterior;
	}

	public int getHpsCantidadMovimiento() {
		return this.hpsCantidadMovimiento;
	}

	public void setHpsCantidadMovimiento(int hpsCantidadMovimiento) {
		this.hpsCantidadMovimiento = hpsCantidadMovimiento;
	}

	public Date getHpsFecha() {
		return this.hpsFecha;
	}

	public void setHpsFecha(Date hpsFecha) {
		this.hpsFecha = hpsFecha;
	}

	public int getProdId() {
		return this.prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public TpoMovimientoProducto getTmpId() {
		return this.tmpId;
	}

	public void setTmpId(TpoMovimientoProducto tmpId) {
		this.tmpId = tmpId;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the hpsCantidadExi
	 */
	public int getHpsCantidadExi() {
		return hpsCantidadExi;
	}

	/**
	 * @param hpsCantidadExi the hpsCantidadExi to set
	 */
	public void setHpsCantidadExi(int hpsCantidadExi) {
		this.hpsCantidadExi = hpsCantidadExi;
	}

}