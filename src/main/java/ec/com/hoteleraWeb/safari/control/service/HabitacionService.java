package ec.com.hoteleraWeb.safari.control.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Habitacion;

public interface HabitacionService {

	@Transactional
	public List<Habitacion> obtenerTodos();

	@Transactional
	public List<Habitacion> obtenerTodosPorHotel(String codigoHotel, Boolean disponibles);

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

	@Transactional
	public List<Habitacion> obtenerPorSuplemento(Integer codigoSuplemento);

	@Transactional
	public List<Habitacion> obtenerPorReservacion(Integer codigoReservacion);

	@Transactional

	public List<Habitacion> obtenerHabitacionesDisponiblre(Integer codigoHotel, Date fechaIngreso,
			Date fechaSalida);

}