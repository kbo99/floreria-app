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

@Entity(name="intervalo")
public class Intervalo implements Serializable {

   

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="int_id", unique=true, nullable=false, precision=10)
    private int intId;
    @Column(name="int_intervalo", nullable=false, length=95)
    private String intIntervalo;
    @Column(name="int_desc", length=250)
    private String intDesc;

    /** Default constructor. */
    public Intervalo() {
        super();
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
     * Access method for intIntervalo.
     *
     * @return the current value of intIntervalo
     */
    public String getIntIntervalo() {
        return intIntervalo;
    }

    /**
     * Setter method for intIntervalo.
     *
     * @param aIntIntervalo the new value for intIntervalo
     */
    public void setIntIntervalo(String aIntIntervalo) {
        intIntervalo = aIntIntervalo;
    }

    /**
     * Access method for intDesc.
     *
     * @return the current value of intDesc
     */
    public String getIntDesc() {
        return intDesc;
    }

    /**
     * Setter method for intDesc.
     *
     * @param aIntDesc the new value for intDesc
     */
    public void setIntDesc(String aIntDesc) {
        intDesc = aIntDesc;
    }

    /**
     * Compares the key for this instance with another Intervalo.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Intervalo and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Intervalo)) {
            return false;
        }
        Intervalo that = (Intervalo) other;
        if (this.getIntId() != that.getIntId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Intervalo.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Intervalo)) return false;
        return this.equalKeys(other) && ((Intervalo)other).equalKeys(this);
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
        i = getIntId();
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
        StringBuffer sb = new StringBuffer("[Intervalo |");
        sb.append(" intId=").append(getIntId());
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
        ret.put("intId", Integer.valueOf(getIntId()));
        return ret;
    }

}
