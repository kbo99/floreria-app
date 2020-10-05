/**
 * 
 */
package com.floreria.app.util;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author macpro
 *
 */
public class RequestPerson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 790882750437362071L;
	
	private Date fechaIni;
	
	private Date fechaFin;
	
	private String fechaIniStr;
	
	private String fechaFinStr;
	
	private Map<String, Object> extraParamMap;

	/**
	 * 
	 */
	public RequestPerson() {
		
	}

	/**
	 * @return the fechaIni
	 */
	public Date getFechaIni() {
		return fechaIni;
	}

	/**
	 * @param fechaIni the fechaIni to set
	 */
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the extraParamMap
	 */
	public Map<String, Object> getExtraParamMap() {
		return extraParamMap;
	}

	/**
	 * @param extraParamMap the extraParamMap to set
	 */
	public void setExtraParamMap(Map<String, Object> extraParamMap) {
		this.extraParamMap = extraParamMap;
	}

	/**
	 * @return the fechaIniStr
	 */
	public String getFechaIniStr() {
		return fechaIniStr;
	}

	/**
	 * @param fechaIniStr the fechaIniStr to set
	 */
	public void setFechaIniStr(String fechaIniStr) {
		this.fechaIniStr = fechaIniStr;
	}

	/**
	 * @return the fechaFinStr
	 */
	public String getFechaFinStr() {
		return fechaFinStr;
	}

	/**
	 * @param fechaFinStr the fechaFinStr to set
	 */
	public void setFechaFinStr(String fechaFinStr) {
		this.fechaFinStr = fechaFinStr;
	}
	
	

}
