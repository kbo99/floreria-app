package com.floreria.app.dao.persona;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.persona.Pais;

/**
 * 
 * @author kbo99
 *
 */
public interface IPaisDAO extends PagingAndSortingRepository<Pais, Integer> {
	
	List<Pais> findAll();

}
