package com.floreria.app.model.persona;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;


/**
 * The persistent class for the direccion database table.
 * 
 */
@Entity
@NamedQuery(name="Direccion.findAll", query="SELECT d FROM Direccion d")
public class Direccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dir_id")
	private Integer dirId;

	@Column(name="dir_calle")
	private String dirCalle;

	@Column(name="dir_entre_calle_dos")
	private String dirEntreCalleDos;

	@Column(name="dir_entre_calle_uno")
	private String dirEntreCalleUno;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dir_falta")
	private Date dirFalta;

	@Column(name="dir_num_ext")
	private String dirNumExt;

	@Column(name="dir_num_int")
	private String dirNumInt;

	@Column(name="dir_referencias")
	private String dirReferencias;

	//bi-directional many-to-one association to Colonia
	@ManyToOne
	@JoinColumn(name="col_id")
	private Colonia colonia;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="per_id")
	private Persona persona;

	public Direccion() {
	}

	public Integer getDirId() {
		return this.dirId;
	}

	public void setDirId(Integer dirId) {
		this.dirId = dirId;
	}

	public String getDirCalle() {
		return this.dirCalle;
	}

	public void setDirCalle(String dirCalle) {
		this.dirCalle = dirCalle;
	}

	public String getDirEntreCalleDos() {
		return this.dirEntreCalleDos;
	}

	public void setDirEntreCalleDos(String dirEntreCalleDos) {
		this.dirEntreCalleDos = dirEntreCalleDos;
	}

	public String getDirEntreCalleUno() {
		return this.dirEntreCalleUno;
	}

	public void setDirEntreCalleUno(String dirEntreCalleUno) {
		this.dirEntreCalleUno = dirEntreCalleUno;
	}

	public Date getDirFalta() {
		return this.dirFalta;
	}

	public void setDirFalta(Date dirFalta) {
		this.dirFalta = dirFalta;
	}

	public String getDirNumExt() {
		return this.dirNumExt;
	}

	public void setDirNumExt(String dirNumExt) {
		this.dirNumExt = dirNumExt;
	}

	public String getDirNumInt() {
		return this.dirNumInt;
	}

	public void setDirNumInt(String dirNumInt) {
		this.dirNumInt = dirNumInt;
	}

	public String getDirReferencias() {
		return this.dirReferencias;
	}

	public void setDirReferencias(String dirReferencias) {
		this.dirReferencias = dirReferencias;
	}

	public Colonia getColonia() {
		return this.colonia;
	}

	public void setColonia(Colonia colonia) {
		this.colonia = colonia;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}