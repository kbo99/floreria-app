/**
 * 
 */
package com.floreria.app.dao.pedido;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.pedido.PagoEstatus;

/**
 * @author macpro
 *
 */
public interface IPagoEstatusDAO extends PagingAndSortingRepository<PagoEstatus, Long> {
	
	PagoEstatus findByPgeId(Integer pgsId);

}
