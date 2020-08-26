package com.floreria.app.dao.persona;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.persona.Persona;

/**
 * @author kbo99
 *
 */
public interface IPersonaDao extends PagingAndSortingRepository<Persona, Integer> {

	@Query("select p from  Persona p where perPombre =?1")
	public Persona findByPerNombreAndPerApeMaterno(String perNombre); 

}
