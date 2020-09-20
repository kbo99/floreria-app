package com.floreria.app.controller.usuario;

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
import com.floreria.app.model.usuario.RegisterUsuario;
import com.floreria.app.model.usuario.Usuario;
import com.floreria.app.service.usuario.IUsuarioService;

/**
 * @author kbo99
 *
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@PostMapping("/guardar")
	public ResponseEntity<Response> saveUser(@RequestBody RegisterUsuario regUsuario) {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			usuarioService.saveUser(regUsuario);
			response.setMessage("El Usuario  " + regUsuario.getUsuario().getUsuUsuario() + " se guardo correctamente");
			response.setTitle("Usuario Guardado");
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (FloreriaBusinessException e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError(e.getErrorMessage());
			response.setTitle("Error");
		} catch(Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al guardar usuario");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
	
}