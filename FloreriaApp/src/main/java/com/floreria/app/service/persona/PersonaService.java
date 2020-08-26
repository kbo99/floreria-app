/**
 * 
 */
package com.floreria.app.service.persona;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.floreria.app.dao.persona.IPersonaDao;
import com.floreria.app.model.persona.Persona;

/**
 * @author kbo99
 *
 */
@Service
public class PersonaService implements IPersonaService {

	@Autowired
	private IPersonaDao personaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Persona> findAllPersonas() {
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Persona findPersonaByIs(Integer id) {
		return personaDao.findById(id).orElse(null);
	}

}
