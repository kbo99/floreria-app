/**
 * 
 */
package com.floreria.app.dao.pedido;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.pedido.PedidoEstatus;

/**
 * @author macpro
 *
 */
public interface IPedidoEstatusDAO extends PagingAndSortingRepository<PedidoEstatus, Long> {
	
	PedidoEstatus findByPdsId(Integer pdsId);

}
