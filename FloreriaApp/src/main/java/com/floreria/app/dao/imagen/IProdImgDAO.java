/**
 * 
 */
package com.floreria.app.dao.imagen;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.imagen.Imagen;
import com.floreria.app.model.imagen.ProdImg;

/**
 * @author macpro
 *
 */
public interface IProdImgDAO extends PagingAndSortingRepository<ProdImg, Long> {
	
	@Query("SELECT img.imagen FROM ProdImg img WHERE img.producto.prodId = ?1 ")
	List<Imagen> getLstImagenByProdId(Integer prodId);

}
