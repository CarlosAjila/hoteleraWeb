package ec.com.hoteleraWeb.safari.control.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Reservacion;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDao;

public interface ReservacionDao extends GenericDao<Reservacion, Integer> {

	@Transactional
	public List<Reservacion> obtenerTodos();

	@Transactional
	public List<Reservacion> obtenerTodosPorHotel(String codigoHotel);

}
