/**
 * 
 */
package com.floreria.app.service.persona;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.floreria.app.controller.utils.Const;
import com.floreria.app.controller.utils.FloreriaBusinessException;
import com.floreria.app.dao.persona.IPersonaDao;
import com.floreria.app.model.persona.Direccion;
import com.floreria.app.model.persona.Persona;

/**
 * @author kbo99
 *
 */
@Service
public class PersonaService implements IPersonaService {

	@Autowired
	private IPersonaDao personaDao;
	
	@Autowired
	private IDireccionService direccionService;
	
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

	@Override
	@Transactional
	public Persona savePersona(Persona persona) throws FloreriaBusinessException {
		List<Direccion> direcciones = null;
		if (Const.getNullToZero(persona.getPerId()) == null) {
			persona.setPerId(null);
			persona.setPerFalta(new Date());
			direcciones = persona.getDireccions();
		}
		persona.setDireccions(null);
		persona = personaDao.save(persona);
		
		if (direcciones != null && !direcciones.isEmpty()) {
			persona.setDireccions(new ArrayList<Direccion>());
			for (Direccion direccion : direcciones) {
				direccion.setPersona(persona);
				persona.getDireccions().add(direccionService.saveDireccion(direccion));
			}
		}
		
		return persona;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Persona> findByRfc(String perRfc) {
		return personaDao.findByPerRfcLike(perRfc);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Persona> findByNombres(Persona persona) {
		List<Persona> result = new ArrayList<Persona>();
		String perNombre = persona.getPerNombre();
		String perApePate = persona.getPerApePate() ;
		if (Const.stringToNull(perNombre) != null && Const.stringToNull(perApePate) != null) {
			result = personaDao.findByPerNombreContainsOrPerApePateContains(perNombre, perApePate);
		} else if (Const.stringToNull(perNombre) != null) {
			result = personaDao.findByPerNombreContains(perNombre);
		}else if (Const.stringToNull(perApePate) != null) {
			result = personaDao.findByPerApePateContains(perApePate);
		}
		return result;
	}

}
