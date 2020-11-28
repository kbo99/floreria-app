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
import com.floreria.app.model.persona.Persona;
import com.floreria.app.service.persona.IPersonaService;

/**
 * @author kbo99
 *
 */
@RestController
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private IPersonaService personaService;
	
	@GetMapping("/listar")
	public List<Persona> listar(){
		return personaService.findAllPersonas();
	}

	@GetMapping("/busca/id/{id}")
	public ResponseEntity<Response> findId(@PathVariable Integer id) {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			Persona per = personaService.findPersonaByIs(id);
			response.setResponse(per);
			response.setMessage(per == null ? "No hay coincidencias": null );
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("No hay coincidencias");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus); 
	}
	
	@GetMapping("/busca/rfc/{rfc}")
	public ResponseEntity<Response> findRfc(@PathVariable String rfc) {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			List<Persona> result = personaService.findByRfc(rfc);
			response.setResponse(result);
			response.setMessage(result.isEmpty() ? "No hay coincidencias": null );
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("No hay coincidencias");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
	
	@PostMapping("/busca/nombre")
	public ResponseEntity<Response> detalle(@RequestBody Persona persona) {
		HttpStatus estatus = HttpStatus.OK;
			Response response = new Response();
			try {
				List<Persona> result = personaService.findByNombres(persona);
				response.setResponse(result);
				response.setTypeMessage(IconAlert.SUCCESS);
				response.setMessage(result.isEmpty() ? "No hay coincidencias": null );
			} catch (Exception e) {
				estatus = HttpStatus.INTERNAL_SERVER_ERROR;
				response.setTypeMessage(IconAlert.ERROR);
				response.setMsError("No hay coincidencias");
				response.setTitle("Error");
			}
			return new ResponseEntity<Response>(response, estatus);
	}
	
	@PostMapping("/savePersona")
	public ResponseEntity<Response> savePersona(@RequestBody Persona persona) {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(personaService.savePersona(persona));
			response.setMessage("El cliente fue guardado correctamente");
			response.setTitle("Cliente Guardado");
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al guardar Persona");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
	
}
