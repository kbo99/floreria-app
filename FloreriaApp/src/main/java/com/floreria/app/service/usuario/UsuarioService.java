/**
 * 
 */
package com.floreria.app.service.usuario;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.floreria.app.controller.utils.Const;
import com.floreria.app.controller.utils.FloreriaBusinessException;
import com.floreria.app.dao.persona.IPersonaDao;
import com.floreria.app.dao.usuario.IUsuarioDAO;
import com.floreria.app.model.persona.Persona;
import com.floreria.app.model.usuario.RegisterUsuario;
import com.floreria.app.model.usuario.Usuario;

/**
 * @author kbo99
 *
 */
@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuarioDAO usuarioDao;
	
	@Autowired
	private IPersonaDao personaDao; 
	
	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsuario(String usuUsuario) {
		Usuario usu = usuarioDao.findByUsuUsuario(usuUsuario);
		return usu;
	}

	@Override
	@Transactional
	public void saveUser(RegisterUsuario regUsuario) throws FloreriaBusinessException {
		
		if (Const.stringToNull(regUsuario.getUsuario().getUsuUsuario()) == null) {
			throw new FloreriaBusinessException("0001", "Se debe Capturar un usuario");
		} else if (this.findByUsuario(Const.stringToNull(regUsuario.getUsuario().getUsuUsuario())) != null) {
			throw new FloreriaBusinessException("0001", "El usuario " +
					regUsuario.getUsuario().getUsuUsuario() + " ya existe");
		} else {
			Persona persona = regUsuario.getPersona();
			persona.setPerFalta(new Date());
			persona = personaDao.save(persona);
			
			Usuario usuario = regUsuario.getUsuario();
			usuario.setUsuEstatus(Const.ESTATUS_ACTIVO);
			usuario.setPersona(persona);
			
			usuarioDao.save(usuario);
			
		}
		
	}

}
