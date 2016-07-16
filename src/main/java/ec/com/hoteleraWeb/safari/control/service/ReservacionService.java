package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Reservacion;

public interface ReservacionService {

	@Transactional
	public List<Reservacion> obtenerTodos();

	@Transactional
	public Reservacion obtenerPorId(Integer id);

	@Transactional
	public List<Reservacion> obtenerTodosPorHotel(String codigoHotel);

	@Transactional
	public void insertar(Reservacion reservacion);

	@Transactional
	public void actualizar(Reservacion reservacion);

	@Transactional
	public void eliminar(Reservacion reservacion);
}