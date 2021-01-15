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

@Entity(name="metodo_pago")
public class MetodoPago implements Serializable {

   

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="mtp_id", unique=true, nullable=false, precision=10)
    private int mtpId;
    @Column(name="mtp_nombre", nullable=false, length=45)
    private String mtpNombre;

    /** Default constructor. */
    public MetodoPago() {
        super();
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
     * Access method for mtpNombre.
     *
     * @return the current value of mtpNombre
     */
    public String getMtpNombre() {
        return mtpNombre;
    }

    /**
     * Setter method for mtpNombre.
     *
     * @param aMtpNombre the new value for mtpNombre
     */
    public void setMtpNombre(String aMtpNombre) {
        mtpNombre = aMtpNombre;
    }

    /**
     * Compares the key for this instance with another MetodoPago.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class MetodoPago and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof MetodoPago)) {
            return false;
        }
        MetodoPago that = (MetodoPago) other;
        if (this.getMtpId() != that.getMtpId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another MetodoPago.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof MetodoPago)) return false;
        return this.equalKeys(other) && ((MetodoPago)other).equalKeys(this);
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
        i = getMtpId();
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
        StringBuffer sb = new StringBuffer("[MetodoPago |");
        sb.append(" mtpId=").append(getMtpId());
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
        ret.put("mtpId", Integer.valueOf(getMtpId()));
        return ret;
    }

}
