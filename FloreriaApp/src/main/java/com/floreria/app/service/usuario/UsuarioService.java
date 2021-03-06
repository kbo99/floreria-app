/**
 * 
 */
package com.floreria.app.service.usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.floreria.app.controller.utils.Const;
import com.floreria.app.controller.utils.FloreriaBusinessException;
import com.floreria.app.dao.persona.IPersonaDao;
import com.floreria.app.dao.usuario.IGrupoDao;
import com.floreria.app.dao.usuario.IMenusDao;
import com.floreria.app.dao.usuario.IUsuGrupoDAO;
import com.floreria.app.dao.usuario.IUsuarioDAO;
import com.floreria.app.model.persona.Persona;
import com.floreria.app.model.usuario.Grupo;
import com.floreria.app.model.usuario.Menu;
import com.floreria.app.model.usuario.UsuGrupo;
import com.floreria.app.model.usuario.UsuGrupoEmbededId;
import com.floreria.app.model.usuario.Usuario;

/**
 * @author kbo99
 *
 */
@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuarioDAO usuarioDao;
	
	@Autowired
	private IPersonaDao personaDao; 
	
	@Autowired
	private IGrupoDao grupoDao;

	@Autowired
	private IUsuGrupoDAO usuGrupoDAO;
	
	@Autowired
	private IMenusDao menuDao;
	
	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsuario(String usuUsuario) {
		Usuario usu = usuarioDao.findByUsuUsuario(usuUsuario);
		return usu;
	}

	@Override
	@Transactional
	public void saveUser(Usuario usuario) throws FloreriaBusinessException {
		if (Const.stringToNull(usuario.getUsuUsuario()) == null) {
			throw new FloreriaBusinessException("0001", "Se debe Capturar un usuario");
		} else if (this.findByUsuario(Const.stringToNull(usuario.getUsuUsuario())) != null) {
			throw new FloreriaBusinessException("0001", "El usuario " +
					usuario.getUsuUsuario() + " ya existe");
		} 
		try {
				Persona persona = usuario.getPersona();
				persona.setPerId(null);
				persona.setPerFalta(new Date());
				Persona newPersona = personaDao.save(persona);
				
				usuario.setUsuEstatus(Const.ESTATUS_ACTIVO);
				usuario.setPersona(newPersona);
				List<Grupo> grupos = usuario.getGrupos();
				usuario.setGrupos(null);
				PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
				usuario.setUsuPassword(passwordEncoder.encode(usuario.getUsuPassword()));
				
				Usuario user = usuarioDao.save(usuario);
				
				for( Grupo grupo : grupos) {
					UsuGrupo usuGrp = new UsuGrupo();
					usuGrp.setId(new UsuGrupoEmbededId());
					usuGrp.getId().setUsuId(user.getUsuId());
					usuGrp.getId().setGrpId(grupo.getGrpId());
					usuGrupoDAO.save(usuGrp);
				}
				
		} catch (Exception e) {
			throw new FloreriaBusinessException("0001", "Error al guardar Usuario " +
					usuario.getUsuUsuario() + " ya existe");
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Grupo> findAllGrups() {
		return (List<Grupo>) grupoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findUsuarioById(Integer id) {
		return usuarioDao.findById(id).get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAllUsuarios() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	public List<Menu> getMenyByGroup(List<Grupo> grupos) { 
		List<String> listGrupos = new ArrayList<String>();
		grupos.stream().forEach(g -> listGrupos.add(g.getGrpNombre()));
		
		List<Menu> menu = menuDao.findMenus(listGrupos);
		
		menu.forEach(m -> {
			m.setChildren(getSubmenu(m.getMenId(), listGrupos));
		});
		Collections.sort(menu);
		return menu;
	}

	@Transactional(readOnly = true)
	private List<Menu> getSubmenu (Integer menId, List<String> grupos) {
		List<Menu> subMenus = menuDao.findSubMenus(grupos, menId);
		subMenus.forEach(sub -> {
			if (sub.getType().equals("sub")) {
				sub.setChildren(getSubmenu(sub.getMenId(), grupos));
				if (sub.getChildren() != null && sub.getChildren().size() > 0) {
					sub.getChildren().forEach(sub1-> {
						if (sub1.getType().equals("sub")) {
							sub1.setChildren(getSubmenu(sub1.getMenId(), grupos));
						}
					});
				}
				Collections.sort(sub.getChildren());
			}
		});
		return subMenus;
	}
}
