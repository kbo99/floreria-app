/**
 * 
 */
package com.floreria.app.dao.producto;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.producto.TipoProducto;

/**
 * @author macpro
 *
 */
public interface ITipoProductoDAO extends PagingAndSortingRepository<TipoProducto, Long> {

	List<TipoProducto> findByTpoprodEstatus(String status);
}
