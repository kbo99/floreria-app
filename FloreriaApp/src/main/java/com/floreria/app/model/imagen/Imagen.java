/**
 * 
 */
package com.floreria.app.model.imagen;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author macpro
 *
 */
@Entity
public class Imagen implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7296779460889654035L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer imgId;
	@Column
	private String imgUrl;
	@Column
	private String imgDesc;
	
	
	public Imagen() {
		
	}


	/**
	 * @return the imgId
	 */
	public Integer getImgId() {
		return imgId;
	}


	/**
	 * @param imgId the imgId to set
	 */
	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}


	/**
	 * @return the imgUrl
	 */
	public String getImgUrl() {
		return imgUrl;
	}


	/**
	 * @param imgUrl the imgUrl to set
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	/**
	 * @return the imgDesc
	 */
	public String getImgDesc() {
		return imgDesc;
	}


	/**
	 * @param imgDesc the imgDesc to set
	 */
	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
	}
	
	
	

}
