package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Habitacion;

public interface HabitacionService {

	@Transactional
	public List<Habitacion> obtenerTodos();

	@Transactional
	public List<Habitacion> obtenerTodosPorHotel(String codigoHotel);

	@Transactional
	public void insertar(Habitacion habitacion);

	@Transactional
	public void actualizar(Habitacion habitacion);

	@Transactional
	public void eliminar(Habitacion habitacion);

	@Transactional
	public boolean validarHabitacion(String numeroHabitacion, String codigoHotel);

	@Transactional
	public Integer obtenerUltimoNumeroHabitacion(String codigoHotel);

}