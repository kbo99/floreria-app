/**
 * 
 */
package com.floreria.app.service.venta;

import java.util.List;

import com.floreria.app.controller.utils.FloreriaBusinessException;
import com.floreria.app.model.venta.Captacion;
import com.floreria.app.model.venta.HoraEntrega;
import com.floreria.app.model.venta.Orden;
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
public interface IVentaService {
	
	/**
	 * Obtiene los Tipo de Pago por estatus
	 * @param status AC = Activo, SU = Suspendido
	 * @return List<PagoTipo>
	 * @throws Exception
	 */
	List<PagoTipo> findByPtipEstatus(String status) throws Exception;
	
	/**
	 * Obtiene los Metodos de Pago por estatus
	 * @param status AC = Activo, SU = Suspendido
	 * @return List<PagoMetodo>
	 * @throws Exception
	 */
	List<PagoMetodo> findByPmetEstatus(String status) throws Exception;
	
	/**
	 * Obtiene los horarios de entrega
	 * @param estatus
	 * @return List<HoraEntrega>
	 * @throws Exception
	 */
	List<HoraEntrega> findByHrenEstatus(String estatus) throws Exception;
	
	/**
	 *  Obtiene el catalogo de tipo de captacion de un clienta
	 * @param status AC = Activo, SU = Suspendido
	 * @return List<Captacion>
	 * @throws Exception
	 */
	List<Captacion> findByCapEstatus(String estatus) throws Exception;
	
	/**
	 * Metodo que genera una orden
	 * @param orden
	 * @return Orden
	 */
	Orden saveOrden(Orden orden) throws FloreriaBusinessException;
	
	List<PedidoEstatus> findAllPedidoEstatus() throws Exception;
	
	List<MetodoPago> findAllMetodoPago() throws Exception;
	
	List<Intervalo> findAllIntervalo() throws Exception;
	
	List<Pedido> findAllPedido() throws Exception;
	
	List<PagoEstatus> findAllPagoEstatus() throws Exception;
}
