// Generated with g9.

package com.floreria.app.model.pedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity(name="pedido")
public class Pedido implements Serializable {

    

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ped_id", unique=true, nullable=false, precision=10)
    private int pedId;
    @Column(name="ped_fecha", nullable=false)
    private LocalDateTime pedFecha;
    @Column(name="ped_precio_total", nullable=false, precision=4, scale=4)
    private BigDecimal pedPrecioTotal;
    @Column(name="ped_fecha_entrega", nullable=false)
    private LocalDateTime pedFechaEntrega;
    @Column(name="ped_referencia", length=250)
    private String pedReferencia;
    @Column(name="ped_hora_preferente", length=45)
    private String pedHoraPreferente;
    @Column(name="ped_folio", nullable=false, length=45)
    private String pedFolio;
    @Column(name="ped_nota", length=250)
    private String pedNota;
    @Column(name="ped_detalle", length=250)
    private String pedDetalle;
    @Column(name="ped_resumen", length=250)
    private String pedResumen;
    @Column(name="cli_id", precision=10)
    private int cliId;
    @Column(name="dir_id", precision=10)
    private int dirId;
    @Column(name="ped_destinatario", length=85)
    private String pedDestinatario;
    @Column(name="ped_destinatario_tel", length=15)
    private String pedDestinatarioTel;
    @Column(name="prod_id", precision=10)
    private int prodId;
    @Column(precision=10)
    private int vendedor;
    @Column(name="ped_nombre_cata", length=150)
    private String pedNombreCata;
    @Column(name="mtp_id", precision=10)
    private int mtpId;
    @Column(name="pge_id", precision=10)
    private int pgeId;
    @Column(name="pds_id", precision=10)
    private int pdsId;
    @Column(name="int_id", precision=10)
    private int intId;

    /** Default constructor. */
    public Pedido() {
        super();
    }

    /**
     * Access method for pedId.
     *
     * @return the current value of pedId
     */
    public int getPedId() {
        return pedId;
    }

    /**
     * Setter method for pedId.
     *
     * @param aPedId the new value for pedId
     */
    public void setPedId(int aPedId) {
        pedId = aPedId;
    }

    /**
     * Access method for pedFecha.
     *
     * @return the current value of pedFecha
     */
    public LocalDateTime getPedFecha() {
        return pedFecha;
    }

    /**
     * Setter method for pedFecha.
     *
     * @param aPedFecha the new value for pedFecha
     */
    public void setPedFecha(LocalDateTime aPedFecha) {
        pedFecha = aPedFecha;
    }

    /**
     * Access method for pedPrecioTotal.
     *
     * @return the current value of pedPrecioTotal
     */
    public BigDecimal getPedPrecioTotal() {
        return pedPrecioTotal;
    }

    /**
     * Setter method for pedPrecioTotal.
     *
     * @param aPedPrecioTotal the new value for pedPrecioTotal
     */
    public void setPedPrecioTotal(BigDecimal aPedPrecioTotal) {
        pedPrecioTotal = aPedPrecioTotal;
    }

    /**
     * Access method for pedFechaEntrega.
     *
     * @return the current value of pedFechaEntrega
     */
    public LocalDateTime getPedFechaEntrega() {
        return pedFechaEntrega;
    }

    /**
     * Setter method for pedFechaEntrega.
     *
     * @param aPedFechaEntrega the new value for pedFechaEntrega
     */
    public void setPedFechaEntrega(LocalDateTime aPedFechaEntrega) {
        pedFechaEntrega = aPedFechaEntrega;
    }

    /**
     * Access method for pedReferencia.
     *
     * @return the current value of pedReferencia
     */
    public String getPedReferencia() {
        return pedReferencia;
    }

    /**
     * Setter method for pedReferencia.
     *
     * @param aPedReferencia the new value for pedReferencia
     */
    public void setPedReferencia(String aPedReferencia) {
        pedReferencia = aPedReferencia;
    }

    /**
     * Access method for pedHoraPreferente.
     *
     * @return the current value of pedHoraPreferente
     */
    public String getPedHoraPreferente() {
        return pedHoraPreferente;
    }

    /**
     * Setter method for pedHoraPreferente.
     *
     * @param aPedHoraPreferente the new value for pedHoraPreferente
     */
    public void setPedHoraPreferente(String aPedHoraPreferente) {
        pedHoraPreferente = aPedHoraPreferente;
    }

    /**
     * Access method for pedFolio.
     *
     * @return the current value of pedFolio
     */
    public String getPedFolio() {
        return pedFolio;
    }

    /**
     * Setter method for pedFolio.
     *
     * @param aPedFolio the new value for pedFolio
     */
    public void setPedFolio(String aPedFolio) {
        pedFolio = aPedFolio;
    }

    /**
     * Access method for pedNota.
     *
     * @return the current value of pedNota
     */
    public String getPedNota() {
        return pedNota;
    }

    /**
     * Setter method for pedNota.
     *
     * @param aPedNota the new value for pedNota
     */
    public void setPedNota(String aPedNota) {
        pedNota = aPedNota;
    }

    /**
     * Access method for pedDetalle.
     *
     * @return the current value of pedDetalle
     */
    public String getPedDetalle() {
        return pedDetalle;
    }

    /**
     * Setter method for pedDetalle.
     *
     * @param aPedDetalle the new value for pedDetalle
     */
    public void setPedDetalle(String aPedDetalle) {
        pedDetalle = aPedDetalle;
    }

    /**
     * Access method for pedResumen.
     *
     * @return the current value of pedResumen
     */
    public String getPedResumen() {
        return pedResumen;
    }

    /**
     * Setter method for pedResumen.
     *
     * @param aPedResumen the new value for pedResumen
     */
    public void setPedResumen(String aPedResumen) {
        pedResumen = aPedResumen;
    }

    /**
     * Access method for cliId.
     *
     * @return the current value of cliId
     */
    public int getCliId() {
        return cliId;
    }

    /**
     * Setter method for cliId.
     *
     * @param aCliId the new value for cliId
     */
    public void setCliId(int aCliId) {
        cliId = aCliId;
    }

    /**
     * Access method for dirId.
     *
     * @return the current value of dirId
     */
    public int getDirId() {
        return dirId;
    }

    /**
     * Setter method for dirId.
     *
     * @param aDirId the new value for dirId
     */
    public void setDirId(int aDirId) {
        dirId = aDirId;
    }

    /**
     * Access method for pedDestinatario.
     *
     * @return the current value of pedDestinatario
     */
    public String getPedDestinatario() {
        return pedDestinatario;
    }

    /**
     * Setter method for pedDestinatario.
     *
     * @param aPedDestinatario the new value for pedDestinatario
     */
    public void setPedDestinatario(String aPedDestinatario) {
        pedDestinatario = aPedDestinatario;
    }

    /**
     * Access method for pedDestinatarioTel.
     *
     * @return the current value of pedDestinatarioTel
     */
    public String getPedDestinatarioTel() {
        return pedDestinatarioTel;
    }

    /**
     * Setter method for pedDestinatarioTel.
     *
     * @param aPedDestinatarioTel the new value for pedDestinatarioTel
     */
    public void setPedDestinatarioTel(String aPedDestinatarioTel) {
        pedDestinatarioTel = aPedDestinatarioTel;
    }

    /**
     * Access method for prodId.
     *
     * @return the current value of prodId
     */
    public int getProdId() {
        return prodId;
    }

    /**
     * Setter method for prodId.
     *
     * @param aProdId the new value for prodId
     */
    public void setProdId(int aProdId) {
        prodId = aProdId;
    }

    /**
     * Access method for vendedor.
     *
     * @return the current value of vendedor
     */
    public int getVendedor() {
        return vendedor;
    }

    /**
     * Setter method for vendedor.
     *
     * @param aVendedor the new value for vendedor
     */
    public void setVendedor(int aVendedor) {
        vendedor = aVendedor;
    }

    /**
     * Access method for pedNombreCata.
     *
     * @return the current value of pedNombreCata
     */
    public String getPedNombreCata() {
        return pedNombreCata;
    }

    /**
     * Setter method for pedNombreCata.
     *
     * @param aPedNombreCata the new value for pedNombreCata
     */
    public void setPedNombreCata(String aPedNombreCata) {
        pedNombreCata = aPedNombreCata;
    }

    /**
     * Access method for mtpId.
     *
     * @return the current value of mtpId
     */
    public int getMtpId() {
        return mtpId;
    }

    /**
     * Setter method for mtpId.
     *
     * @param aMtpId the new value for mtpId
     */
    public void setMtpId(int aMtpId) {
        mtpId = aMtpId;
    }

    /**
     * Access method for pgeId.
     *
     * @return the current value of pgeId
     */
    public int getPgeId() {
        return pgeId;
    }

    /**
     * Setter method for pgeId.
     *
     * @param aPgeId the new value for pgeId
     */
    public void setPgeId(int aPgeId) {
        pgeId = aPgeId;
    }

    /**
     * Access method for pdsId.
     *
     * @return the current value of pdsId
     */
    public int getPdsId() {
        return pdsId;
    }

    /**
     * Setter method for pdsId.
     *
     * @param aPdsId the new value for pdsId
     */
    public void setPdsId(int aPdsId) {
        pdsId = aPdsId;
    }

    /**
     * Access method for intId.
     *
     * @return the current value of intId
     */
    public int getIntId() {
        return intId;
    }

    /**
     * Setter method for intId.
     *
     * @param aIntId the new value for intId
     */
    public void setIntId(int aIntId) {
        intId = aIntId;
    }

    /**
     * Compares the key for this instance with another Pedido.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Pedido and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Pedido)) {
            return false;
        }
        Pedido that = (Pedido) other;
        if (this.getPedId() != that.getPedId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Pedido.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Pedido)) return false;
        return this.equalKeys(other) && ((Pedido)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getPedId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Pedido |");
        sb.append(" pedId=").append(getPedId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("pedId", Integer.valueOf(getPedId()));
        return ret;
    }

}
