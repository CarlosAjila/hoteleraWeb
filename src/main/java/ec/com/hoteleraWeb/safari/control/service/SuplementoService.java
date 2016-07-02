package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Actividad;

public interface SuplementoService {

	@Transactional
	public List<Actividad> obtenerPorHotel(Integer codigoHotel);

	@Transactional
	public void insertar(Actividad actividad);

	@Transactional
	public void actualizar(Actividad actividad);

	@Transactional
	public void eliminar(Actividad actividad);
}