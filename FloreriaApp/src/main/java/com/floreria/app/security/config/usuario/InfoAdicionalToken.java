package com.floreria.app.security.config.usuario;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.floreria.app.dao.usuario.IUsuarioDAO;
import com.floreria.app.model.persona.Persona;
import com.floreria.app.model.usuario.Usuario;

@Component
public class InfoAdicionalToken  implements TokenEnhancer {

	@Autowired
	private IUsuarioDAO usuarioDao;
	
//	@Autowired
	//private IPersonaDao personaDao;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Usuario usuario = usuarioDao.findByUsuUsuario(authentication.getName());
		Persona persona = usuario.getPersona();
		
		map.put("perId", persona.getPerId());
		map.put("nombre", persona.getPerNombre());
		map.put("apeM", persona.getPerApeMat());
		map.put("apeP", persona.getPerApePate());
		map.put("email", persona.getPerEmail());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(map);
		
		return accessToken;
	}
}
