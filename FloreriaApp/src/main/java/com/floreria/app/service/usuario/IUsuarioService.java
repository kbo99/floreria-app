package com.floreria.app.service.usuario;

import java.util.List;

import com.floreria.app.controller.utils.FloreriaBusinessException;
import com.floreria.app.model.usuario.Grupo;
import com.floreria.app.model.usuario.Menu;
import com.floreria.app.model.usuario.RegisterUsuario;
import com.floreria.app.model.usuario.Usuario;

public interface IUsuarioService {

	public Usuario findByUsuario (String usuUsuario);
	
	public void saveUser (Usuario usuario) throws FloreriaBusinessException;
	
	public List<Grupo> findAllGrups();
	
	public Usuario  findUsuarioById(Integer id);
	
	public List<Usuario> findAllUsuarios();
	
	/**
	 * Busca menu dependiendo los grupos del usuario
	 * @param grupos
	 * @return
	 */
	public List<Menu> getMenyByGroup(List<Grupo> grupos);
}
