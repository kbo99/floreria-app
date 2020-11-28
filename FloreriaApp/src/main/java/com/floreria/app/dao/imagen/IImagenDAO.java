/**
 * 
 */
package com.floreria.app.dao.imagen;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.imagen.Imagen;

/**
 * @author macpro
 *
 */
public interface IImagenDAO extends PagingAndSortingRepository<Imagen, Long> {
	
}
