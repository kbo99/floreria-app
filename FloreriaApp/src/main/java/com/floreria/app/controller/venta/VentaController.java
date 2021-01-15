/**
 * 
 */
package com.floreria.app.controller.venta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.floreria.app.controller.utils.FloreriaBusinessException;
import com.floreria.app.controller.utils.IconAlert;
import com.floreria.app.controller.utils.Response;
import com.floreria.app.model.usuario.Usuario;
import com.floreria.app.model.venta.Orden;
import com.floreria.app.service.venta.IVentaService;

/**
 * @author ocruz
 *
 */
@RestController
@RequestMapping("/ventas")
public class VentaController {
	
	@Autowired
	private IVentaService ventaService;

	@PostMapping("/findByPtipEstatus")
	public ResponseEntity<Response> findByPtipEstatus(@RequestBody String status) {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(ventaService.findByPtipEstatus(status));
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al Buscar El tipo de pago");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
	
	@PostMapping("/findByPmetEstatus")
	public ResponseEntity<Response> findByPmetEstatus(@RequestBody String status) {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(ventaService.findByPmetEstatus(status));
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al Buscar El metodo de pago");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
	
	@PostMapping("/findByHrenEstatus")
	public ResponseEntity<Response> findByHrenEstatus(@RequestBody String status) {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(ventaService.findByHrenEstatus(status));
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al Buscar El metodo findByHrenEstatus");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
	
	@PostMapping("/findByCapEstatus")
	public ResponseEntity<Response> findByCapEstatus(@RequestBody String status) {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(ventaService.findByCapEstatus(status));
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al Buscar El metodo findByCapEstatus");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
	
	@PostMapping("/saveOrden")
	public ResponseEntity<Response> saveOrden(@RequestBody Orden orden) {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			ventaService.saveOrden(orden);
			response.setResponse(true);
			response.setMessage("Se genero la orden " + orden.getOrdId() + "");
			response.setTitle("Orden generada");
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (FloreriaBusinessException e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError(e.getErrorMessage());
			response.setTitle("Error");
		} catch(Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al generar la orden");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
	
	@PostMapping("/findPagoEstatus")
	public ResponseEntity<Response> findPagoEstatus() {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(ventaService.findAllPagoEstatus());
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al Buscar El metodo de pago");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
	
	@PostMapping("/findPedidoEstatus")
	public ResponseEntity<Response> findPedidoEstatus() {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(ventaService.findAllPedidoEstatus());
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al Buscar El metodo de pago");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
	
	@PostMapping("/findMetodoPago")
	public ResponseEntity<Response> findMetodoPago() {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(ventaService.findAllMetodoPago());
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al Buscar El metodo de pago");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
	
	@PostMapping("/findIntervalo")
	public ResponseEntity<Response> findIntervalo() {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(ventaService.findAllIntervalo());
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al Buscar El metodo de pago");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
}
