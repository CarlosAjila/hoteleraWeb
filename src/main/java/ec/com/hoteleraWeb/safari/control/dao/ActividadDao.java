package ec.com.hoteleraWeb.safari.control.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Actividad;
import ec.com.hoteleraWeb.safari.control.entity.Empleado;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDao;

public interface ActividadDao extends GenericDao<Actividad, Integer> {
	@Transactional
	public List<Actividad> obtenerTodos();
	
	@Transactional
	public List<Actividad> obtenerActividadesPorHotel(Integer codigoHotel);
}
