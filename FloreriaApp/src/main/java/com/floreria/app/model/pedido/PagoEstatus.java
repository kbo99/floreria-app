// Generated with g9.

package com.floreria.app.model.pedido;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity(name="pago_estatus")
public class PagoEstatus implements Serializable {

   

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pge_id", unique=true, nullable=false, precision=10)
    private int pgeId;
    @Column(name="pge_nombre", nullable=false, length=85)
    private String pgeNombre;

    /** Default constructor. */
    public PagoEstatus() {
        super();
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
     * Access method for pgeNombre.
     *
     * @return the current value of pgeNombre
     */
    public String getPgeNombre() {
        return pgeNombre;
    }

    /**
     * Setter method for pgeNombre.
     *
     * @param aPgeNombre the new value for pgeNombre
     */
    public void setPgeNombre(String aPgeNombre) {
        pgeNombre = aPgeNombre;
    }

    /**
     * Compares the key for this instance with another PagoEstatus.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class PagoEstatus and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof PagoEstatus)) {
            return false;
        }
        PagoEstatus that = (PagoEstatus) other;
        if (this.getPgeId() != that.getPgeId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another PagoEstatus.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PagoEstatus)) return false;
        return this.equalKeys(other) && ((PagoEstatus)other).equalKeys(this);
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
        i = getPgeId();
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
        StringBuffer sb = new StringBuffer("[PagoEstatus |");
        sb.append(" pgeId=").append(getPgeId());
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
        ret.put("pgeId", Integer.valueOf(getPgeId()));
        return ret;
    }

}
