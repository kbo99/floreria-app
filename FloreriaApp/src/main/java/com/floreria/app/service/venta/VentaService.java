/**
 * 
 */
package com.floreria.app.service.venta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.floreria.app.dao.pedido.IMetodoPagoDAO;
import com.floreria.app.dao.pedido.IPagoEstatusDAO;
import com.floreria.app.dao.pedido.IPedidoEstatusDAO;
import com.floreria.app.dao.pedido.IntervaloDAO;
import com.floreria.app.dao.venta.IPagoMetodo;
import com.floreria.app.dao.venta.IPagoTipoDAO;
import com.floreria.app.model.pedido.Intervalo;
import com.floreria.app.model.pedido.MetodoPago;
import com.floreria.app.model.pedido.PagoEstatus;
import com.floreria.app.model.pedido.Pedido;
import com.floreria.app.model.pedido.PedidoEstatus;
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
	IPedidoEstatusDAO pedidoEstatusDAO;
	
	@Autowired
	IMetodoPagoDAO metodoPagoDAO;
	
	@Autowired
	IntervaloDAO intervaloDAO;
	
	@Autowired
	IPagoEstatusDAO pagoEstatusDAO;

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
	public List<PedidoEstatus> findAllPedidoEstatus() throws Exception {
		return (List<PedidoEstatus>) pedidoEstatusDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<MetodoPago> findAllMetodoPago() throws Exception {
		return metodoPagoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Intervalo> findAllIntervalo() throws Exception {
		return intervaloDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pedido> findAllPedido() throws Exception {
		return null;
	}

	@Override
	public List<PagoEstatus> findAllPagoEstatus() throws Exception {
		return (List<PagoEstatus>) pagoEstatusDAO.findAll();
	}
	
}
