package ec.com.hoteleraWeb.safari.control.dao;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Habitacion;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDao;

public interface HabitacionDao extends GenericDao<Habitacion, Integer> {

	@Transactional
	public List<Habitacion> obtenerTodos();

	@Transactional
	public List<Habitacion> obtenerTodosPorHotel(String codigoHotel, Boolean disponibles);

	@Transactional
	public List<Habitacion> obtenerPorNumHabitacionYHotel(String numeroHabitacion, String codigoHotel);

	@Transactional
	public Integer obtenerUltimoNumeroHabitacion(String codigoHotel);

	@Transactional
	public List<Habitacion> obtenerPorSuplemento(Integer codigoSuplemento);

	@Transactional
	public List<Habitacion> obtenerPorReservacion(Integer codigoReservacion);

	@Transactional
	public List<Habitacion> obtenerHabitacionesDisponible(Integer codigoHotel, Date fechaIngreso, Date fechaSalida);

}
