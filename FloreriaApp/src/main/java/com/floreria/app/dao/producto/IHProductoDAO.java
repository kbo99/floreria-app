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
	
	
	List<Hproducto> findByProductoProdId(Integer prodId);
	
	List<Hproducto> findByHpsFechaBetweenOrderByHpsFechaDesc(Date fechain, Date fechaFin);
	
	List<Hproducto> findByHpsFechaBetweenAndProductoProdNombreLikeOrderByHpsFechaDesc(Date fechain, Date fechaFin, 
			String prodNombre);
	
	List<Hproducto> findByHpsFechaBetweenAndProductoProdNombreLikeAndTmpIdTmpIdOrderByHpsFechaDesc(Date fechain, Date fechaFin, 
			String prodNombre, Integer tmpId);
	
	List<Hproducto> findByHpsFechaBetweenAndTmpIdTmpIdOrderByHpsFechaDesc(Date fechain, Date fechaFin, 
			Integer tmpId);

}
