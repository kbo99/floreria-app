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
}
