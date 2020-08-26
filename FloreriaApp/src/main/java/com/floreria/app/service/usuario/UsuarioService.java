/**
 * 
 */
package com.floreria.app.service.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.floreria.app.dao.usuario.IUsuarioDAO;
import com.floreria.app.model.usuario.Usuario;

/**
 * @author kbo99
 *
 */
@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuarioDAO usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsuario(String usuUsuario) {
		Usuario usu = usuarioDao.findByUsuUsuario(usuUsuario);
		return usu;
	}

}
