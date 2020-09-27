package com.floreria.app.dao.usuario;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.floreria.app.model.usuario.Grupo;

public interface IGrupoDao  extends PagingAndSortingRepository<Grupo, Integer>{

}
