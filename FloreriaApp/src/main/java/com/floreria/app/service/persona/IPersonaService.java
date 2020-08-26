package com.floreria.app.service.persona;

import java.util.List;

import com.floreria.app.model.persona.Persona;

public interface IPersonaService {

	public List<Persona> findAllPersonas();
	public Persona findPersonaByIs (Integer id);
}
