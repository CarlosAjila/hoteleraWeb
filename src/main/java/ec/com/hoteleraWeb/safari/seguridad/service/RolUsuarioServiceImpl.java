package ec.com.hoteleraWeb.safari.seguridad.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.seguridad.dao.RolUsuarioDao;
import ec.com.hoteleraWeb.safari.seguridad.entity.RolUsuario;

@Service
public class RolUsuarioServiceImpl implements RolUsuarioService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RolUsuarioDao rolUsuarioDao;

	public Boolean insertar(RolUsuario rolUsuario) {
		rolUsuarioDao.insertar(rolUsuario);
		return true;
	}

}