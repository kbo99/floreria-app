/**
 * 
 */
package com.floreria.app.dao.venta;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.venta.PagoTipo;

/**
 * @author ocruz
 *
 */
public interface IPagoTipoDAO extends PagingAndSortingRepository<PagoTipo, Long>{
	
	/**
	 * Obtiene los Tipo de Pago por estatus
	 * @param status AC = Activo, SU = Suspendido
	 * @return List<PagoTipo>
	 */
	List<PagoTipo> findByPtipEstatus(String status);
}
