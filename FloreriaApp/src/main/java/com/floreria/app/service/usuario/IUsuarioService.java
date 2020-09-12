package com.floreria.app.service.usuario;

import com.floreria.app.controller.utils.FloreriaBusinessException;
import com.floreria.app.model.usuario.RegisterUsuario;
import com.floreria.app.model.usuario.Usuario;

public interface IUsuarioService {

	public Usuario findByUsuario (String usuUsuario);
	
	public void saveUser (RegisterUsuario regUsuario) throws FloreriaBusinessException;
}
