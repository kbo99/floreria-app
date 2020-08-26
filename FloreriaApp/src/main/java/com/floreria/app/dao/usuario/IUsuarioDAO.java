/**
 * 
 */
package com.floreria.app.dao.usuario;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.usuario.Usuario;

/**
 * @author kbo99
 *
 */
public interface IUsuarioDAO  extends PagingAndSortingRepository<Usuario, Integer> {
	public Usuario findByUsuUsuario (String usuUsuario);
} 
