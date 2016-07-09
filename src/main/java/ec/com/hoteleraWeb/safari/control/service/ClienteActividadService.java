package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.ClienteActividad;

public interface ClienteActividadService {

	@Transactional
	public void insertar(List<ClienteActividad> listaClienteActividades);

	@Transactional
	public void actualizar(List<ClienteActividad> listaClienteActividades);

}