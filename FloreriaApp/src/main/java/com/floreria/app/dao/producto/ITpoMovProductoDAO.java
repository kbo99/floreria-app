/**
 * 
 */
package com.floreria.app.dao.producto;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.floreria.app.model.producto.TpoMovimientoProducto;


/**
 * @author rgarciaq
 *
 */
@Repository
public interface ITpoMovProductoDAO extends PagingAndSortingRepository<TpoMovimientoProducto, Long> {

	TpoMovimientoProducto save(TpoMovimientoProducto tpoMov);
	
	List<TpoMovimientoProducto> findAll();
	
	TpoMovimientoProducto findByTmpId(Integer tmpId);
	
	
}
