// Generated with g9.

package com.floreria.app.model.pedido;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity(name="pedido_estatus")
public class PedidoEstatus implements Serializable {

   

    @Id
    @Column(name="pds_id", unique=true, nullable=false, precision=10)
    private int pdsId;
    @Column(name="pds_nombre", nullable=false, length=75)
    private String pdsNombre;

    /** Default constructor. */
    public PedidoEstatus() {
        super();
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
     * Access method for pdsNombre.
     *
     * @return the current value of pdsNombre
     */
    public String getPdsNombre() {
        return pdsNombre;
    }

    /**
     * Setter method for pdsNombre.
     *
     * @param aPdsNombre the new value for pdsNombre
     */
    public void setPdsNombre(String aPdsNombre) {
        pdsNombre = aPdsNombre;
    }

    /**
     * Compares the key for this instance with another PedidoEstatus.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class PedidoEstatus and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof PedidoEstatus)) {
            return false;
        }
        PedidoEstatus that = (PedidoEstatus) other;
        if (this.getPdsId() != that.getPdsId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another PedidoEstatus.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PedidoEstatus)) return false;
        return this.equalKeys(other) && ((PedidoEstatus)other).equalKeys(this);
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
        i = getPdsId();
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
        StringBuffer sb = new StringBuffer("[PedidoEstatus |");
        sb.append(" pdsId=").append(getPdsId());
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
        ret.put("pdsId", Integer.valueOf(getPdsId()));
        return ret;
    }

}
