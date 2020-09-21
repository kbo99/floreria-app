/**
 * 
 */
package com.floreria.app.service.imagen;

import java.util.List;

import com.floreria.app.model.imagen.Imagen;
import com.floreria.app.model.imagen.ProdImg;

/**
 * @author macpro
 *
 */
public interface IIMagen {
	
	Imagen save(Imagen img) throws Exception;
	
	List<Imagen> getLstImagByProd(Integer prodId) throws Exception;
	
	ProdImg save(ProdImg save) throws Exception;
	
	List<Imagen> saveImgByProdId(List<Imagen> lstImg, Integer proId) throws Exception;

}
