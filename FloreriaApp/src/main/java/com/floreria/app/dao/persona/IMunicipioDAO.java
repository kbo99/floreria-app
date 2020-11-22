/**
 * 
 */
package com.floreria.app.dao.persona;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.persona.Municipio;

/**
 * 
 * @author kbo99
 *
 */
public interface IMunicipioDAO extends PagingAndSortingRepository<Municipio, Integer> {
	
	/**
	 * Recupera el municipio a partir de su id
	 * @param munId
	 * @return
	 */
	Municipio findByMunId(Integer munId);
	
	/**
	 * Recupera lista de municipio a partir del id estado
	 * @param entId
	 * @return
	 */
	List<Municipio> findByEntidadEntIdOrderByNomMunAsc(String entId);
	
	/**
	 * Recupera lista de municipio a partir de un nombre
	 * @param nomMun
	 * @return
	 */
	List<Municipio> findByNomMunLike(String nomMun);
	
	/**
	 * Recupera lista de municipio a partir de un nombre y id de estado
	 * @param nomMun
	 * @return
	 */
	List<Municipio> findByNomMunLikeAndEntidadEntId(String nomMun, Integer entId);
	
	

}
