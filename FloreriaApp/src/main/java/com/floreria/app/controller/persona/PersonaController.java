/**
 * 
 */
package com.floreria.app.controller.persona;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/ver/{id}")
	public Persona detalle(@PathVariable Integer id) {
		return personaService.findPersonaByIs(id);
	}
	
}
