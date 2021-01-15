/**
 * 
 */
package com.floreria.app.dao.venta;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.venta.HoraEntrega;

/**
 * @author ocruz
 *
 */
public interface IHoraEntregaDAO extends PagingAndSortingRepository<HoraEntrega, Long>{

	/**
	 * Obtiene las horas de entrega e intervalos
	 * @param status AC = Activo, SU = Suspendido
	 * @return List<HoraEntrega>
	 */
	List<HoraEntrega> findByHrenEstatus(String status);
}
