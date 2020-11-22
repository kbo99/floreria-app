package com.floreria.app.dao.persona;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.persona.Direccion;
import com.floreria.app.model.persona.Entidad;

/**
 * 
 * @author kbo99
 *
 */
public interface IDireccionDao extends PagingAndSortingRepository<Direccion, Integer> {

	//Direccion save(Direccion direccion);
	
	@Query("select d from  Direccion d where d.persona.perId = ?1")
	List<Direccion> findByPersonaId(Integer perId);
	
	@Query("select e from  Entidad e where e.pais.paiId = ?1")
	List<Entidad> findEntidadesByPais(Integer paiId);
	
	@Query("select e from  Entidad e where e.pais.paiId = ?1")
	List<Entidad> findMunicipioByEntidad(Integer paiId);
}
