package com.floreria.app.model.usuario;

import com.floreria.app.model.persona.Persona;

/**
 * 
 * @author kbo99
 *
 */
public class RegisterUsuario implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5105018814484426170L;


	private Usuario usuario;
	
	private Persona persona;

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
