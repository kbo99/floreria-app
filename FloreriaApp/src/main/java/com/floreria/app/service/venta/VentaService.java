/**
 * 
 */
package com.floreria.app.service.venta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.floreria.app.dao.venta.IPagoMetodo;
import com.floreria.app.dao.venta.IPagoTipoDAO;
import com.floreria.app.model.venta.PagoMetodo;
import com.floreria.app.model.venta.PagoTipo;

/**
 * @author ocruz
 *
 */
@Service
public class VentaService implements IVentaService{
	
	@Autowired
	IPagoTipoDAO pagoTipoDAO;
	
	@Autowired
	IPagoMetodo pagoMetodoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<PagoTipo> findByPtipEstatus(String estatus) {
		return (List<PagoTipo>) pagoTipoDAO.findByPtipEstatus(estatus);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<PagoMetodo> findByPmetEstatus(String estatus) {
		return (List<PagoMetodo>) pagoMetodoDAO.findByPmetEstatus(estatus);
	}
	
}
