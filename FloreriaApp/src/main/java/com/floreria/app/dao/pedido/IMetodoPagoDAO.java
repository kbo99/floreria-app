/**
 * 
 */
package com.floreria.app.dao.pedido;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.pedido.MetodoPago;

/**
 * @author macpro
 *
 */
public interface IMetodoPagoDAO extends PagingAndSortingRepository<MetodoPago, Long> {
	
	List<MetodoPago> findAll();
	
	MetodoPago findByMtpId(Integer mtpId);

}
