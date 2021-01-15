/**
 * 
 */
package com.floreria.app.model.venta;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.floreria.app.model.persona.Persona;
import com.floreria.app.model.producto.Producto;
import com.floreria.app.model.usuario.Usuario;

/**
 * @author ocruz
 *
 */
@Entity
public class Orden implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ord_id")
	private Integer ordId;
	
	//bi-directional many-to-one association to OrdenEstatus
	@ManyToOne
	@JoinColumn(name="oes_id")
	private OrdenEstatus ordenEstatus;
	
	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="per_id")
	private Persona perId;
	
	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usu_id")
	private Usuario usuId;
	
	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="prod_id")
	private Producto prodId;
	
	@Column(name="ord_catalogo")
	private String ordCatalogo;
	
	@Column(name="ord_fpedido")
	private Date ordFpedido;
	
	@Column(name="ord_fentrega")
	private Date ordFentrega;
	
	//bi-directional many-to-one association to HoraEntrega
	@ManyToOne
	@JoinColumn(name="hren_id_intervalo")
	private HoraEntrega hrenIdIntervalo;
	
	//bi-directional many-to-one association to HoraEntrega
	@ManyToOne
	@JoinColumn(name="hren_id_hora")
	private HoraEntrega hrenIdHora;
	
	@Column(name="ord_direccion")
	private String ordDireccion;
	
	@Column(name="ord_referencia")
	private String ordReferencia;
	
	@Column(name="ord_destinatario")
	private String ordDestinatario;
	
	@Column(name="ord_dtelefono")
	private String ordDtelefono;
	
	//bi-directional many-to-one association to Captacion
	@ManyToOne
	@JoinColumn(name="cap_id_captacion")
	private Captacion capIdCaptacion;
	
	//bi-directional many-to-one association to Captacion
	@ManyToOne
	@JoinColumn(name="cap_id_contacto")
	private Captacion capIdContacto;
	
	@Column(name="ord_precio_prod")
	private BigDecimal ordPrecioProd;
	
	@Column(name="ord_precio_envio")
	private BigDecimal ordPrecioEnvio;
	
	@Column(name="ord_precio_total")
	private BigDecimal ordPrecioTotal;
	
	//bi-directional many-to-one association to PagoTipo
	@ManyToOne
	@JoinColumn(name="ptip_id")
	private PagoTipo ptipId;
	
	//bi-directional many-to-one association to PagoMetodoPagoTipo
	@ManyToOne
	@JoinColumn(name="pmet_id")
	private PagoMetodo pmetId;
	
	@Column(name="ord_fcreacion")
	private Date ordFcreacion;
	
	@Column(name="ord_fmodifica")
	private Date ordFmodifica;

	/**
	 * @return the ordId
	 */
	public Integer getOrdId() {
		return ordId;
	}

	/**
	 * @return the ordenEstatus
	 */
	public OrdenEstatus getOrdenEstatus() {
		return ordenEstatus;
	}

	/**
	 * @return the perId
	 */
	public Persona getPerId() {
		return perId;
	}

	/**
	 * @return the usuId
	 */
	public Usuario getUsuId() {
		return usuId;
	}

	/**
	 * @return the prodId
	 */
	public Producto getProdId() {
		return prodId;
	}

	/**
	 * @return the ordCatalogo
	 */
	public String getOrdCatalogo() {
		return ordCatalogo;
	}

	/**
	 * @return the ordFpedido
	 */
	public Date getOrdFpedido() {
		return ordFpedido;
	}

	/**
	 * @return the ordFentrega
	 */
	public Date getOrdFentrega() {
		return ordFentrega;
	}

	/**
	 * @return the hrenIdIntervalo
	 */
	public HoraEntrega getHrenIdIntervalo() {
		return hrenIdIntervalo;
	}

	/**
	 * @return the hrenIdHora
	 */
	public HoraEntrega getHrenIdHora() {
		return hrenIdHora;
	}

	/**
	 * @return the ordDireccion
	 */
	public String getOrdDireccion() {
		return ordDireccion;
	}

	/**
	 * @return the ordReferencia
	 */
	public String getOrdReferencia() {
		return ordReferencia;
	}

	/**
	 * @return the ordDestinatario
	 */
	public String getOrdDestinatario() {
		return ordDestinatario;
	}

	/**
	 * @return the ordDtelefono
	 */
	public String getOrdDtelefono() {
		return ordDtelefono;
	}

	/**
	 * @return the capIdCaptacion
	 */
	public Captacion getCapIdCaptacion() {
		return capIdCaptacion;
	}

	/**
	 * @return the capIdContacto
	 */
	public Captacion getCapIdContacto() {
		return capIdContacto;
	}

	/**
	 * @return the ordPrecioProd
	 */
	public BigDecimal getOrdPrecioProd() {
		return ordPrecioProd;
	}

	/**
	 * @return the ordPrecioEnvio
	 */
	public BigDecimal getOrdPrecioEnvio() {
		return ordPrecioEnvio;
	}

	/**
	 * @return the ordPrecioTotal
	 */
	public BigDecimal getOrdPrecioTotal() {
		return ordPrecioTotal;
	}

	/**
	 * @return the ptipId
	 */
	public PagoTipo getPtipId() {
		return ptipId;
	}

	/**
	 * @return the pmetId
	 */
	public PagoMetodo getPmetId() {
		return pmetId;
	}

	/**
	 * @return the ordFcreacion
	 */
	public Date getOrdFcreacion() {
		return ordFcreacion;
	}

	/**
	 * @return the ordFmodifica
	 */
	public Date getOrdFmodifica() {
		return ordFmodifica;
	}

	/**
	 * @param ordId the ordId to set
	 */
	public void setOrdId(Integer ordId) {
		this.ordId = ordId;
	}

	/**
	 * @param ordenEstatus the ordenEstatus to set
	 */
	public void setOrdenEstatus(OrdenEstatus ordenEstatus) {
		this.ordenEstatus = ordenEstatus;
	}

	/**
	 * @param perId the perId to set
	 */
	public void setPerId(Persona perId) {
		this.perId = perId;
	}

	/**
	 * @param usuId the usuId to set
	 */
	public void setUsuId(Usuario usuId) {
		this.usuId = usuId;
	}

	/**
	 * @param prodId the prodId to set
	 */
	public void setProdId(Producto prodId) {
		this.prodId = prodId;
	}

	/**
	 * @param ordCatalogo the ordCatalogo to set
	 */
	public void setOrdCatalogo(String ordCatalogo) {
		this.ordCatalogo = ordCatalogo;
	}

	/**
	 * @param ordFpedido the ordFpedido to set
	 */
	public void setOrdFpedido(Date ordFpedido) {
		this.ordFpedido = ordFpedido;
	}

	/**
	 * @param ordFentrega the ordFentrega to set
	 */
	public void setOrdFentrega(Date ordFentrega) {
		this.ordFentrega = ordFentrega;
	}

	/**
	 * @param hrenIdIntervalo the hrenIdIntervalo to set
	 */
	public void setHrenIdIntervalo(HoraEntrega hrenIdIntervalo) {
		this.hrenIdIntervalo = hrenIdIntervalo;
	}

	/**
	 * @param hrenIdHora the hrenIdHora to set
	 */
	public void setHrenIdHora(HoraEntrega hrenIdHora) {
		this.hrenIdHora = hrenIdHora;
	}

	/**
	 * @param ordDireccion the ordDireccion to set
	 */
	public void setOrdDireccion(String ordDireccion) {
		this.ordDireccion = ordDireccion;
	}

	/**
	 * @param ordReferencia the ordReferencia to set
	 */
	public void setOrdReferencia(String ordReferencia) {
		this.ordReferencia = ordReferencia;
	}

	/**
	 * @param ordDestinatario the ordDestinatario to set
	 */
	public void setOrdDestinatario(String ordDestinatario) {
		this.ordDestinatario = ordDestinatario;
	}

	/**
	 * @param ordDtelefono the ordDtelefono to set
	 */
	public void setOrdDtelefono(String ordDtelefono) {
		this.ordDtelefono = ordDtelefono;
	}

	/**
	 * @param capIdCaptacion the capIdCaptacion to set
	 */
	public void setCapIdCaptacion(Captacion capIdCaptacion) {
		this.capIdCaptacion = capIdCaptacion;
	}

	/**
	 * @param capIdContacto the capIdContacto to set
	 */
	public void setCapIdContacto(Captacion capIdContacto) {
		this.capIdContacto = capIdContacto;
	}

	/**
	 * @param ordPrecioProd the ordPrecioProd to set
	 */
	public void setOrdPrecioProd(BigDecimal ordPrecioProd) {
		this.ordPrecioProd = ordPrecioProd;
	}

	/**
	 * @param ordPrecioEnvio the ordPrecioEnvio to set
	 */
	public void setOrdPrecioEnvio(BigDecimal ordPrecioEnvio) {
		this.ordPrecioEnvio = ordPrecioEnvio;
	}

	/**
	 * @param ordPrecioTotal the ordPrecioTotal to set
	 */
	public void setOrdPrecioTotal(BigDecimal ordPrecioTotal) {
		this.ordPrecioTotal = ordPrecioTotal;
	}

	/**
	 * @param ptipId the ptipId to set
	 */
	public void setPtipId(PagoTipo ptipId) {
		this.ptipId = ptipId;
	}

	/**
	 * @param pmetId the pmetId to set
	 */
	public void setPmetId(PagoMetodo pmetId) {
		this.pmetId = pmetId;
	}

	/**
	 * @param ordFcreacion the ordFcreacion to set
	 */
	public void setOrdFcreacion(Date ordFcreacion) {
		this.ordFcreacion = ordFcreacion;
	}

	/**
	 * @param ordFmodifica the ordFmodifica to set
	 */
	public void setOrdFmodifica(Date ordFmodifica) {
		this.ordFmodifica = ordFmodifica;
	}
}
