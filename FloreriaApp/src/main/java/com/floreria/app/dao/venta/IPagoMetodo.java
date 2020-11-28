/**
 * 
 */
package com.floreria.app.dao.venta;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.venta.PagoMetodo;

/**
 * @author ocruz
 *
 */
public interface IPagoMetodo extends PagingAndSortingRepository<PagoMetodo, Long>{

	/**
	 * Obtiene los Metodos de Pago por estatus
	 * @param status AC = Activo, SU = Suspendido
	 * @return List<PagoMetodo>
	 */
	List<PagoMetodo> findByPmetEstatus(String status);
}
