/**
 * 
 */
package com.floreria.app.dao.pedido;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.pedido.Pedido;

/**
 * @author macpro
 *
 */
public interface IPedidoDAO extends PagingAndSortingRepository<Pedido, Long> {

}
