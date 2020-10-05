package com.floreria.app.model.usuario;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sub_menus database table.
 * 
 */
@Entity
@Table(name="sub_menus")
@NamedQuery(name="SubMenus.findAll", query="SELECT s FROM SubMenus s")
public class SubMenus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sum_id")
	private Integer sumId;
	
	@Column(name="men_id")
	private int menId;

	@Column(name="sub_men_id")
	private int subMenId;

	public SubMenus() {
	}

	public int getMenId() {
		return this.menId;
	}

	public void setMenId(int menId) {
		this.menId = menId;
	}

	public int getSubMenId() {
		return this.subMenId;
	}

	public void setSubMenId(int subMenId) {
		this.subMenId = subMenId;
	}

}