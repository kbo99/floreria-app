/**
 * 
 */
package com.floreria.app.dao.producto;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.producto.ProdHijo;
import com.floreria.app.model.producto.Producto;

/**
 * @author macpro
 *
 */
public interface IProdHijoDAO extends PagingAndSortingRepository<ProdHijo, Long> {
	
	
	@Query("SELECT prod.producto FROM ProdHijo prod WHERE prod.prodIdPadre =?1 AND prod.prhEstatus = ?2")
	List<Producto> getChamacosActivosProd(Integer prodId, String estatus);
	
	ProdHijo findByProdIdPadreAndProductoProdId(Integer prodIdPadre, Integer prodId);

}
