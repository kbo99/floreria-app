/**
 * 
 */
package com.floreria.app.dao.usuario;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.usuario.UsuGrupo;

/**
 * @author kbo99
 *
 */
public interface IUsuGrupoDAO extends PagingAndSortingRepository<UsuGrupo, Integer> {

}
