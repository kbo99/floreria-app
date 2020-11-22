package com.floreria.app.controller.utils;

public class Const {

	public final static String ESTATUS_ACTIVO = "AC";
	
	/**
	 * Devuelve null si la cadena es nulla o no tiene caracteres 
	 * si no devuelve la cadena enviada sin espacios  
	 * @param cadena
	 * @return
	 */
	public static String stringToNull(String cadena) {
		String result = null;
		if (cadena != null && cadena.trim().length() > 0) {
			result = cadena.trim();
		}
		return result;
	}
	
	/**
     * Devuele un null si el id envido es menor a 0
     * @param id
     * @return
     */
    public static Integer getNullToZero (Integer id) {
    	return id != null && id > 0 ? id : null;
    }
}
