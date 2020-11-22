/**
 * 
 */
package com.floreria.app.dao.persona;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.floreria.app.model.persona.Entidad;

/**
 * 
 * @author kbo99
 *
 */
@Repository
public interface IEntidadDAO extends PagingAndSortingRepository<Entidad, Integer> {

	List<Entidad> findByPaisPaiId(Integer paiId);
	
	List<Entidad> findByEntNomLike(String entNom);
	
	Entidad findByEntId(Integer entId);
}
