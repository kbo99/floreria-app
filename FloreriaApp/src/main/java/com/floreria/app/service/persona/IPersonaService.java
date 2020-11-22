package com.floreria.app.service.persona;

import java.util.List;

import com.floreria.app.controller.utils.FloreriaBusinessException;
import com.floreria.app.model.persona.Persona;

public interface IPersonaService {

	public List<Persona> findAllPersonas();
	public Persona findPersonaByIs (Integer id);
	public Persona savePersona(Persona persona) throws FloreriaBusinessException;
	
	public List<Persona> findByRfc(String perRfc);
	
	public List<Persona> findByNombres(Persona persona);
}
