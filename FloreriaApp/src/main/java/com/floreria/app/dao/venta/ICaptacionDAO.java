/**
 * 
 */
package com.floreria.app.dao.venta;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.venta.Captacion;

/**
 * @author ocruz
 *
 */
public interface ICaptacionDAO extends PagingAndSortingRepository<Captacion, Long>{
	
	/**
	 * Obtiene el catalogo de tipo de captacion de un clienta
	 * @param status AC = Activo, SU = Suspendido
	 * @return List<Captacion>
	 */
	List<Captacion> findByCapEstatus(String status);

}
