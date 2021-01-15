/**
 * 
 */
package com.floreria.app.dao.venta;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.floreria.app.model.venta.Orden;

/**
 * @author ocruz
 *
 */
@Repository
public interface IOrdenDAO  extends PagingAndSortingRepository<Orden, Long> {
	
	Orden findByOrdId(Integer ordId);
	
	List<Orden> findAll();

}
