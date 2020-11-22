package com.floreria.app.model.persona;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;


/**
 * The persistent class for the pais database table.
 * 
 */
@Entity
@Table(name="pais")
@NamedQuery(name="Pais.findAll", query="SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pai_id")
	private Integer paiId;

	@Column(name="pai_abre")
	private String paiAbre;

	@Column(name="pai_nombre")
	private String paiNombre;

	//bi-directional many-to-one association to Entidad
	@OneToMany(mappedBy="pais")
	@JsonBackReference
	private List<Entidad> entidads;

	//bi-directional many-to-one association to RegionPai
	@ManyToOne
	@JoinColumn(name="rep_id")
	private RegionPai regionPai;

	public Pais() {
	}

	public Integer getPaiId() {
		return this.paiId;
	}

	public void setPaiId(Integer paiId) {
		this.paiId = paiId;
	}

	public String getPaiAbre() {
		return this.paiAbre;
	}

	public void setPaiAbre(String paiAbre) {
		this.paiAbre = paiAbre;
	}

	public String getPaiNombre() {
		return this.paiNombre;
	}

	public void setPaiNombre(String paiNombre) {
		this.paiNombre = paiNombre;
	}

	public List<Entidad> getEntidads() {
		return this.entidads;
	}

	public void setEntidads(List<Entidad> entidads) {
		this.entidads = entidads;
	}


}