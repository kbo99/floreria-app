package com.floreria.app.dao.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.usuario.Menu;

public interface IMenusDao extends PagingAndSortingRepository<Menu, Integer>{

	@Query("SELECT m from Menu m where m.subMenu = false and m.grpId in (Select g.grpId from Grupo g where g.grpNombre in (?1))")
	List<Menu> findMenus (List<String> grupos);
	
	@Query("SELECT m from Menu m where m.subMenu = true and m.menId in (Select sub.subMenId from SubMenus sub where sub.menId = ?2) "
			+ "and m.grpId in (Select g.grpId from Grupo g where g.grpNombre in (?1))")
	List<Menu> findSubMenus (List<String> grupos, Integer menId);
}
