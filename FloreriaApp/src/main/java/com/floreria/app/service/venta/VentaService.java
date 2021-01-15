/**
 * 
 */
package com.floreria.app.service.venta;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.floreria.app.controller.utils.FloreriaBusinessException;
import com.floreria.app.dao.venta.ICaptacionDAO;
import com.floreria.app.dao.venta.IHoraEntregaDAO;
import com.floreria.app.dao.venta.IOrdenDAO;
import com.floreria.app.dao.venta.IPagoMetodo;
import com.floreria.app.dao.venta.IPagoTipoDAO;
import com.floreria.app.model.venta.Captacion;
import com.floreria.app.model.venta.HoraEntrega;
import com.floreria.app.model.venta.Orden;
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
	
	@Autowired
	IHoraEntregaDAO horaEntregaDAO;
	
	@Autowired
	ICaptacionDAO captacionDAO;
	
	@Autowired
	IOrdenDAO ordenDAO;

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
	
	@Override
	@Transactional(readOnly = true)
	public List<HoraEntrega> findByHrenEstatus(String estatus) {
		return (List<HoraEntrega>) horaEntregaDAO.findByHrenEstatus(estatus);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Captacion> findByCapEstatus(String estatus) {
		return (List<Captacion>) captacionDAO.findByCapEstatus(estatus);
	}
	
	@Override
	@Transactional
	public Orden saveOrden(Orden orden) throws FloreriaBusinessException {
		if (orden.getProdId() == null) {
			throw new FloreriaBusinessException("0001", "Se debe Capturar un producto");
		} 
		
		try {
			
			orden.setOrdId(null);
			orden.setOrdFcreacion(new Date());
			orden.setOrdFmodifica(new Date());
			orden = ordenDAO.save(orden);
				
		} catch (Exception e) {
			throw new FloreriaBusinessException("0001", "Error la orden del cliente " +
					orden.getPerId().getPerNombre() + "");
		}
		
		return orden;
		
	}
	
}
