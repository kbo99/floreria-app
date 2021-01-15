/**
 * 
 */
package com.floreria.app.dao.pedido;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.floreria.app.model.pedido.Intervalo;

/**
 * @author macpro
 *
 */
@Repository
public interface IntervaloDAO extends PagingAndSortingRepository<Intervalo, Long> {
	
	List<Intervalo> findAll();
	
	Intervalo findByIntId(Integer intId);

}
