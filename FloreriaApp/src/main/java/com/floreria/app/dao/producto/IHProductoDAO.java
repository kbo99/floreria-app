/**
 * 
 */
package com.floreria.app.dao.producto;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.producto.Hproducto;

/**
 * @author macpro
 *
 */
public interface IHProductoDAO extends PagingAndSortingRepository<Hproducto, Long> {
	
	
	List<Hproducto> findByProdId(Integer prodId);
	
	List<Hproducto> findByHpsFechaBetweenOrderByHpsFechaDesc(Date fechain, Date fechaFin);

}
