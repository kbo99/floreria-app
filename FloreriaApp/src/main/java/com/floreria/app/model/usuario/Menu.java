package com.floreria.app.model.usuario;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the menus database table.
 * 
 */
@Entity
@Table(name="menus")
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable, Comparable<Menu>{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="men_id")
	private Integer menId;

	@Column(name="active")
	private Boolean active;

	@Column(name="badgetype")
	private String badgeType;

	@Column(name="badgevalue")
	private String badgeValue;

	@Column(name="bookmark")
	private Boolean bookmark;

	@Column(name="grp_id")
	private int grpId;

	@Column(name="icon")
	private String icon;

	@Column(name="path")
	private String path;

	@Column(name="title")
	private String title;

	@Column(name="type")
	private String type;
	
	@Column(name="orden")
	private Integer orden;
	
	@Column(name="submenu")
	private Boolean subMenu;

	//bi-directional many-to-many association to Menu
//	@ManyToMany
//	@JoinTable(
//		name="sub_menus"
//		, joinColumns={
//			@JoinColumn(name="sub_men_id")
//			}
//		, inverseJoinColumns={
//			@JoinColumn(name="men_id")
//			}
//		)
	@Transient
	private List<Menu> children;

	public Menu() {
	}

	public Integer getMenId() {
		return this.menId;
	}

	public void setMenId(Integer menId) {
		this.menId = menId;
	}

	public String getBadgeType() {
		return this.badgeType;
	}

	public void setBadgeType(String badgeType) {
		this.badgeType = badgeType;
	}

	public String getBadgeValue() {
		return this.badgeValue;
	}

	public void setBadgeValue(String badgeValue) {
		this.badgeValue = badgeValue;
	}

	public int getGrpId() {
		return this.grpId;
	}

	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getBookmark() {
		return bookmark;
	}

	public void setBookmark(Boolean bookmark) {
		this.bookmark = bookmark;
	}

	public int compareTo(Menu o) {
		int order = 0;
		if (o.getOrden() != null && this.getOrden() != null) 
			order = o.getOrden() < this.getOrden() ? 1 : -1;
		
		return order;
	}

	public Boolean getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(Boolean subMenu) {
		this.subMenu = subMenu;
	}
}