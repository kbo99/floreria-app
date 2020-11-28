package com.floreria.app.model.producto;

import java.io.Serializable;
import javax.persistence.*;

import com.floreria.app.model.imagen.Imagen;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prod_id")
	private int prodId;

	@Column(name="prod_nombre")
	private String prodNombre;

	@Temporal(TemporalType.DATE)
	@Column(name="prod_fecha_registro")
	private java.util.Date prodFechaRegistro;

	@Column(name="prod_clave")
	private String prodClave;

	@Column(name="prod_costo_compra")
	private BigDecimal prodCostoCompra;

	@Column(name="prod_costo_venta")
	private BigDecimal prodCostoVenta;

	@Column(name="prod_desc")
	private BigDecimal prodDesc;

	@Column(name="prod_descrip")
	private String prodDescrip;

	@Column(name="prod_estatus")
	private String prodEstatus;

	@Column(name="prod_existencia_min")
	private int prodExistenciaMin;
	
	@Column(name="prod_esinsumo")
	private boolean prodEsInsumo;


	//bi-directional many-to-one association to TipoProducto
	@ManyToOne
	@JoinColumn(name="tpoprod_id")
	private TipoProducto tipoProducto;
	
	@Transient
	private List<Imagen> lstImg;
	
	@Transient
	private String imgDefault;
	
	@Transient
	private List<Producto> lstProdHijo;
	
	@Transient
	private String usuario;
	
	@Transient
	private Integer cantidadMov;
	
	@Transient
	private Integer tpoMov;
	
	@Transient
	private Integer cantProduccion;
	
	@Transient
	private Integer cantidadFaltante;

	public Producto() {
	}
	
	public Producto(int prodId) {
		this.prodId = prodId;
	}



	
	/**
	 * @return the prodId
	 */
	public int getProdId() {
		return prodId;
	}




	/**
	 * @param prodId the prodId to set
	 */
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}




	/**
	 * @return the prodNombre
	 */
	public String getProdNombre() {
		return prodNombre;
	}




	/**
	 * @param prodNombre the prodNombre to set
	 */
	public void setProdNombre(String prodNombre) {
		this.prodNombre = prodNombre;
	}




	/**
	 * @return the prodFechaRegistro
	 */
	public java.util.Date getProdFechaRegistro() {
		return prodFechaRegistro;
	}




	/**
	 * @param prodFechaRegistro the prodFechaRegistro to set
	 */
	public void setProdFechaRegistro(java.util.Date prodFechaRegistro) {
		this.prodFechaRegistro = prodFechaRegistro;
	}




	public String getProdClave() {
		return this.prodClave;
	}

	public void setProdClave(String prodClave) {
		this.prodClave = prodClave;
	}

	public BigDecimal getProdCostoCompra() {
		return this.prodCostoCompra;
	}

	public void setProdCostoCompra(BigDecimal prodCostoCompra) {
		this.prodCostoCompra = prodCostoCompra;
	}

	public BigDecimal getProdCostoVenta() {
		return this.prodCostoVenta;
	}

	public void setProdCostoVenta(BigDecimal prodCostoVenta) {
		this.prodCostoVenta = prodCostoVenta;
	}

	public BigDecimal getProdDesc() {
		return this.prodDesc;
	}

	public void setProdDesc(BigDecimal prodDesc) {
		this.prodDesc = prodDesc;
	}

	public String getProdDescrip() {
		return this.prodDescrip;
	}

	public void setProdDescrip(String prodDescrip) {
		this.prodDescrip = prodDescrip;
	}

	public String getProdEstatus() {
		return this.prodEstatus;
	}

	public void setProdEstatus(String prodEstatus) {
		this.prodEstatus = prodEstatus;
	}

	public int getProdExistenciaMin() {
		return this.prodExistenciaMin;
	}

	public void setProdExistenciaMin(int prodExistenciaMin) {
		this.prodExistenciaMin = prodExistenciaMin;
	}

	

	public TipoProducto getTipoProducto() {
		return this.tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}




	/**
	 * @return the lstImg
	 */
	public List<Imagen> getLstImg() {
		return lstImg;
	}




	/**
	 * @param lstImg the lstImg to set
	 */
	public void setLstImg(List<Imagen> lstImg) {
		this.lstImg = lstImg;
	}

	/**
	 * @return the imgDefault
	 */
	public String getImgDefault() {
		return imgDefault;
	}

	/**
	 * @param imgDefault the imgDefault to set
	 */
	public void setImgDefault(String imgDefault) {
		this.imgDefault = imgDefault;
	}

	/**
	 * @return the lstProdHijo
	 */
	public List<Producto> getLstProdHijo() {
		return lstProdHijo;
	}

	/**
	 * @param lstProdHijo the lstProdHijo to set
	 */
	public void setLstProdHijo(List<Producto> lstProdHijo) {
		this.lstProdHijo = lstProdHijo;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the cantidadMov
	 */
	public Integer getCantidadMov() {
		return cantidadMov;
	}

	/**
	 * @param cantidadMov the cantidadMov to set
	 */
	public void setCantidadMov(Integer cantidadMov) {
		this.cantidadMov = cantidadMov;
	}

	/**
	 * @return the tpoMov
	 */
	public Integer getTpoMov() {
		return tpoMov;
	}

	/**
	 * @param tpoMov the tpoMov to set
	 */
	public void setTpoMov(Integer tpoMov) {
		this.tpoMov = tpoMov;
	}

	/**
	 * @return the prodEsInsumo
	 */
	public boolean isProdEsInsumo() {
		return prodEsInsumo;
	}

	/**
	 * @param prodEsInsumo the prodEsInsumo to set
	 */
	public void setProdEsInsumo(boolean prodEsInsumo) {
		this.prodEsInsumo = prodEsInsumo;
	}
	
	
	
	

}