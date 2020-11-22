/**
 * 
 */
package com.floreria.app.dao.persona;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.floreria.app.model.persona.Colonia;

/**
 * 
 * @author kbo99
 *
 */
@Repository
public interface IColoniaDAO extends PagingAndSortingRepository<Colonia, Integer> {

	List<Colonia> findByColCp(String colCp);
	
	List<Colonia> findByMunicipioMunIdOrderByColNomAsc(Integer munId);
	
	List<Colonia> findByColNomLike(String colNom);
	
	List<Colonia> findByColNomLikeAndMunicipioMunId(String colNom, String munId);
	
	Colonia findByColId(Integer colId);
}
