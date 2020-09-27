package com.floreria.app.model.usuario;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.floreria.app.model.persona.Persona;

import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usu_id")
	private int usuId;

	@Column(name="usu_estatus")
	private String usuEstatus;

	@Column(name="usu_password", updatable = false)
	private String usuPassword;

	@Column(name="usu_usuario", updatable = false)
	private String usuUsuario;

	//bi-directional many-to-many association to Grupo
	@ManyToMany(mappedBy="usuarios", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Grupo> grupos;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="per_id")
	private Persona persona;

	public Usuario() {
	}

	public int getUsuId() {
		return this.usuId;
	}

	public void setUsuId(int usuId) {
		this.usuId = usuId;
	}

	public String getUsuEstatus() {
		return this.usuEstatus;
	}

	public void setUsuEstatus(String usuEstatus) {
		this.usuEstatus = usuEstatus;
	}

	public String getUsuPassword() {
		return this.usuPassword;
	}

	public void setUsuPassword(String usuPassword) {
		this.usuPassword = usuPassword;
	}

	public String getUsuUsuario() {
		return this.usuUsuario;
	}

	public void setUsuUsuario(String usuUsuario) {
		this.usuUsuario = usuUsuario;
	}

	public List<Grupo> getGrupos() {
		return this.grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}