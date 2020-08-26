/**
 * 
 */
package com.floreria.app.security.config.usuario;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.floreria.app.model.usuario.Usuario;
import com.floreria.app.service.usuario.IUsuarioService;

/**
 * @author kbo99
 *
 */
@Service
public class UsuarioDetailService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(UsuarioDetailService.class);

	@Autowired
	private IUsuarioService usuarioService;
	
//	@Autowired
//	private Tracer tracer;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Usuario usuario = usuarioService.findByUsuario(username);

			List<GrantedAuthority> authorities = usuario.getGrupos().stream()
					.map(grupo -> new SimpleGrantedAuthority(grupo.getGrpNombre()))
					.peek(autority -> logger.info("Role: ".concat(autority.getAuthority())))
					.collect(Collectors.toList());

			return new User(usuario.getUsuUsuario(), usuario.getUsuPassword(), usuario.getUsuEstatus().equals("AC"),
					true, true, true, authorities);

		} catch (Exception e) {
			String mns = "Error en el Login: no existe el usuario '" + username + "' en el sistema!";
			logger.error(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			logger.error(mns);
			logger.error("Error::::::::::", e);
			
//			tracer.currentSpan().tag("error login", mns + ": " + e.getMessage());
			
			throw new UsernameNotFoundException(mns);
		}

	}
}
