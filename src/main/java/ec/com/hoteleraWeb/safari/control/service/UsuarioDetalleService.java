package ec.com.hoteleraWeb.safari.control.service;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.UsuarioDetalle;

public interface UsuarioDetalleService {

	@Transactional
	public boolean insertar(UsuarioDetalle usuarioDetalle);

	@Transactional
	public boolean comprobarExistencia(UsuarioDetalle usuarioDetalle);

}