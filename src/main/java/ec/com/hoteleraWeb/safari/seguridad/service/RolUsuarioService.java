package ec.com.hoteleraWeb.safari.seguridad.service;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.seguridad.entity.RolUsuario;

public interface RolUsuarioService {
	@Transactional
	public Boolean insertar(RolUsuario rolUsuario);

}