/**
 * 
 */
package com.floreria.app.controller.persona;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.floreria.app.controller.utils.IconAlert;
import com.floreria.app.controller.utils.Response;
import com.floreria.app.model.persona.Colonia;
import com.floreria.app.model.persona.Direccion;
import com.floreria.app.model.persona.Entidad;
import com.floreria.app.model.persona.Municipio;
import com.floreria.app.model.persona.Pais;
import com.floreria.app.service.persona.IDireccionService;

/**
 * @author kbo99
 *
 */
@RestController
@RequestMapping("/direccion")
public class DireccionController {

	@Autowired
	private IDireccionService direccionService;

	@GetMapping("/coloniamun/{munId}")
	public List<Colonia> findColByMunId(@PathVariable Integer munId) {
		return direccionService.findColByMunicipio(munId);
	}

	@GetMapping("/coloniacp/{cp}")
	public List<Colonia> findColByCp(@PathVariable String cp) {
		return direccionService.findColByCp(cp);
	}

	/**
	 * Metodo que obtiene las entidades a partir de un pais Id
	 * 
	 * @param paisId
	 * @return
	 */
	@GetMapping("/entidad/{paisId}")
	public List<Entidad> findEntidadByPais(@PathVariable Integer paisId) {
		return direccionService.findEntidadByPais(paisId);
	}

	/**
	 * Metodo que obtiene todos los municipios a partir de un ent Id
	 * 
	 * @param entId
	 * @return
	 */
	@GetMapping("/municipio/{entId}")
	public List<Municipio> findMunicipioByEntId(@PathVariable String entId) {
		return direccionService.findMunicipioByEntId(entId);
	}
	
	
	@PostMapping("/saveDireccion")
	public ResponseEntity<Response> saveDireccion(@RequestBody Direccion direccion) {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(direccionService.saveDireccion(direccion));
			response.setMessage("La direccion se a Guardado Correctamente");
			response.setTitle("Direccion Guardada");
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al guardar Direccion");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
}
