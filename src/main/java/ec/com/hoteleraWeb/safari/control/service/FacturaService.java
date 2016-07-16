package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Factura;
import ec.com.hoteleraWeb.safari.control.entityAux.FacturaTO;

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