/**
 * 
 */
package com.floreria.app.dao.producto;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.producto.Hproducto;

/**
 * @author macpro
 *
 */
public interface IHProductoDAO extends PagingAndSortingRepository<Hproducto, Long> {

}
