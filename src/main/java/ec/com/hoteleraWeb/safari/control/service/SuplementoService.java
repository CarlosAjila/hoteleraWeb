package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Suplemento;

public interface SuplementoService {

	@Transactional
	public List<Suplemento> obtenerPorHotel(String codigoHotel);

	@Transactional
	public void insertar(Suplemento suplemento);

	@Transactional
	public void actualizar(Suplemento suplemento);

	@Transactional
	public void eliminar(Suplemento suplemento);
}