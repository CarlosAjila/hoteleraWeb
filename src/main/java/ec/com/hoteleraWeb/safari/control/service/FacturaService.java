package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Factura;

public interface FacturaService {

	@Transactional
	public List<Factura> obtenerTodos();

	@Transactional
	public List<Factura> obtenerPorHotel(Integer codigoHotel);

	@Transactional
	public List<Factura> obtenerPorReservacion(Integer codigoReservacion);

	@Transactional
	public void insertar(Factura actividad);

	@Transactional
	public void actualizar(Factura actividad);

	@Transactional
	public void eliminar(Factura actividad);
}