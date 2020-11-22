/**
 * 
 */
package com.floreria.app.service.persona;

import java.util.List;

import com.floreria.app.controller.utils.FloreriaBusinessException;
import com.floreria.app.model.persona.Colonia;
import com.floreria.app.model.persona.Direccion;
import com.floreria.app.model.persona.Entidad;
import com.floreria.app.model.persona.Municipio;

/**
 * 
 * @author kbo99
 *
 */
public interface IDireccionService {

	/**
	 * Recupera lista de colonias a partir del codigo postal
	 * @param codPostal
	 * @return
	 */
	List<Colonia> findColByCp(String codPostal);
	
	
	/**
	 * Recupera lista de colonias a partir del municipio
	 * @param codPostal
	 * @return
	 */
	List<Colonia> findColByMunicipio(Integer munId);
	
	
	/**
	 * Metodo que obtiene todos los estados
	 * @return
	 */
	List<Entidad> fidAllEnt();
	
	
	/**
	 * Metodo que obtiene las entidades a partir de un pais Id
	 * @param paisId
	 * @return
	 */
	List<Entidad> findEntidadByPais(Integer paisId);
	
	/**
	 * Metodo que obtiene todos los municipios a partir de un ent Id
	 * @param entId
	 * @return
	 */
	List<Municipio> findMunicipioByEntId(String entId);
	
	/**
	 * Metodo encargado de guardar una direccion No usar para el alta de clientes, solo es para empleados
	 * @param direccion
	 * @return
	 */
	Direccion saveDireccion(Direccion direccion) throws FloreriaBusinessException;
	
}
