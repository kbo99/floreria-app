package com.floreria.app.model.persona;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.floreria.app.model.usuario.Usuario;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="per_id")
	private Integer perId;

	@Column(name="per_ape_mat")
	private String perApeMat;

	@Column(name="per_ape_pate")
	private String perApePate;

	@Column(name="per_email", updatable = false)
	private String perEmail;

	@Temporal(TemporalType.DATE)
	@Column(name="per_falta", updatable = false)
	private Date perFalta;

	@Temporal(TemporalType.DATE)
	@Column(name="per_fnacimiento")
	private Date perFnacimiento;

	@Column(name="per_nombre")
	private String perNombre;

	@Column(name="per_rfc")
	private String perRfc;

	@Column(name="per_telefono")
	private String perTelefono;

//	//bi-directional many-to-one association to Direccion
//	@ManyToOne
//	@JoinColumn(name="`dir_:id`")
//	private Direccion direccion;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="persona")
	@JsonBackReference
	private List<Usuario> usuarios;

	public Persona() {
	}

	public Integer getPerId() {
		return this.perId;
	}

	public void setPerId(Integer perId) {
		this.perId = perId;
	}

	public String getPerApeMat() {
		return this.perApeMat;
	}

	public void setPerApeMat(String perApeMat) {
		this.perApeMat = perApeMat;
	}

	public String getPerApePate() {
		return this.perApePate;
	}

	public void setPerApePate(String perApePate) {
		this.perApePate = perApePate;
	}

	public String getPerEmail() {
		return this.perEmail;
	}

	public void setPerEmail(String perEmail) {
		this.perEmail = perEmail;
	}

	public Date getPerFalta() {
		return this.perFalta;
	}

	public void setPerFalta(Date perFalta) {
		this.perFalta = perFalta;
	}

	public Date getPerFnacimiento() {
		return this.perFnacimiento;
	}

	public void setPerFnacimiento(Date perFnacimiento) {
		this.perFnacimiento = perFnacimiento;
	}

	public String getPerNombre() {
		return this.perNombre;
	}

	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}

	public String getPerRfc() {
		return this.perRfc;
	}

	public void setPerRfc(String perRfc) {
		this.perRfc = perRfc;
	}

	public String getPerTelefono() {
		return this.perTelefono;
	}

	public void setPerTelefono(String perTelefono) {
		this.perTelefono = perTelefono;
	}

//	public Direccion getDireccion() {
//		return this.direccion;
//	}
//
//	public void setDireccion(Direccion direccion) {
//		this.direccion = direccion;
//	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

//	public Usuario addUsuario(Usuario usuario) {
//		getUsuarios().add(usuario);
//		usuario.setPersona(this);
//
//		return usuario;
//	}
//
//	public Usuario removeUsuario(Usuario usuario) {
//		getUsuarios().remove(usuario);
//		usuario.setPersona(null);
//
//		return usuario;
//	}

}