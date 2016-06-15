package ec.com.hoteleraWeb.safari.seguridad.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.seguridad.entity.Bitacora;

public interface BitacoraService {
	@Transactional
	public List<Bitacora> obtener(Integer usuarioId, Date fechaInicio);
}