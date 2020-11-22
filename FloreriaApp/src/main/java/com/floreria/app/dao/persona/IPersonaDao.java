package com.floreria.app.dao.persona;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.persona.Persona;

/**
 * @author kbo99
 *
 */
public interface IPersonaDao extends PagingAndSortingRepository<Persona, Integer> {

	public List<Persona> findByPerNombreContainsOrPerApePateContains(String perNombre, String perApePate); 

	public List<Persona> findByPerNombreContains(String perNombre);
	
	public List<Persona> findByPerApePateContains(String perApePate);
	
	public List<Persona> findByPerRfcLike(String perRfc);
}
