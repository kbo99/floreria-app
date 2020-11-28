/**
 * 
 */
package com.floreria.app.service.venta;

import java.util.List;

import com.floreria.app.model.venta.PagoMetodo;
import com.floreria.app.model.venta.PagoTipo;

/**
 * @author ocruz
 *
 */
public interface IVentaService {
	
	/**
	 * Obtiene los Tipo de Pago por estatus
	 * @param status AC = Activo, SU = Suspendido
	 * @return List<PagoTipo>
	 * @throws Exception
	 */
	List<PagoTipo> findByPtipEstatus(String status) throws Exception;
	
	/**
	 * Obtiene los Metodos de Pago por estatus
	 * @param status AC = Activo, SU = Suspendido
	 * @return List<PagoMetodo>
	 * @throws Exception
	 */
	List<PagoMetodo> findByPmetEstatus(String status) throws Exception;

}
