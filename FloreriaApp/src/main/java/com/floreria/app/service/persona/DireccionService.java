package com.floreria.app.service.persona;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.floreria.app.controller.utils.Const;
import com.floreria.app.controller.utils.FloreriaBusinessException;
import com.floreria.app.dao.persona.IColoniaDAO;
import com.floreria.app.dao.persona.IDireccionDao;
import com.floreria.app.dao.persona.IEntidadDAO;
import com.floreria.app.dao.persona.IMunicipioDAO;
import com.floreria.app.model.persona.Colonia;
import com.floreria.app.model.persona.Direccion;
import com.floreria.app.model.persona.Entidad;
import com.floreria.app.model.persona.Municipio;

/**
 * 
 * @author kbo99
 *
 */
@Service
public class DireccionService implements IDireccionService {
	
	Logger logger = LoggerFactory.getLogger(DireccionService.class);

	@Autowired
	IColoniaDAO coloniaDAO;

	@Autowired
	IEntidadDAO entidadDAO;

	@Autowired
	IMunicipioDAO municipioDAO;

	@Autowired
	IDireccionDao direccionDAO;
	

	@Override
	public List<Colonia> findColByCp(String codPostal) {
		return coloniaDAO.findByColCp(codPostal);
	}

	@Override
	public List<Colonia> findColByMunicipio(Integer munId) {
		return	coloniaDAO.findByMunicipioMunIdOrderByColNomAsc(munId);
	}

	@Override
	public List<Entidad> findEntidadByPais(Integer paisId) {
		return entidadDAO.findByPaisPaiId(paisId);
	}

	@Override
	public List<Municipio> findMunicipioByEntId(String entId) {
		return municipioDAO.findByEntidadEntIdOrderByNomMunAsc(entId);
	}

	@Override
	public List<Entidad> fidAllEnt() {
		return (List<Entidad>) entidadDAO.findAll();
	}

	@Override
	@Transactional
	public Direccion saveDireccion(Direccion direccion) throws FloreriaBusinessException  {
		try {
			if (Const.getNullToZero(direccion.getDirId()) == null) {
				direccion.setDirFalta(new Date());
				direccion.setDirId(null);
			}
			direccion = direccionDAO.save(direccion);
			
		} catch (Exception e) {
			logger.error("Error al guardar direccion", e);
			throw new FloreriaBusinessException("0001", "Error al guardar direccion", e);
		}
		return direccion;
	}

}
