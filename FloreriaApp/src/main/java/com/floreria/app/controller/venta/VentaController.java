/**
 * 
 */
package com.floreria.app.controller.venta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.floreria.app.controller.utils.IconAlert;
import com.floreria.app.controller.utils.Response;
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
}
