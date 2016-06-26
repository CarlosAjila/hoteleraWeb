package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.Habitacion;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;
import ec.com.hoteleraWeb.safari.utils.dao.GenericSQLDao;

@Repository
public class HabitacionDaoImpl extends GenericDaoImpl<Habitacion, Integer> implements HabitacionDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private GenericSQLDao genericSQLDao;

	public List<Habitacion> obtenerTodos() {
		String sql = "Select * FROM habitaciones";
		List<Habitacion> habitaciones = new ArrayList<Habitacion>();
		habitaciones = genericSQLDao.obtenerPorSql(sql, Habitacion.class);
		if (habitaciones != null)
			if (habitaciones.size() != 0)
				return habitaciones;
		return null;
	}

	public List<Habitacion> obtenerTodosPorHotel(String codigoHotel) {
		String sql = "Select * FROM habitacion where hot_codigo='" + codigoHotel + "' ORDER BY hab_codigo;";
		List<Habitacion> habitaciones = new ArrayList<Habitacion>();
		habitaciones = genericSQLDao.obtenerPorSql(sql, Habitacion.class);
		if (habitaciones != null)
			if (habitaciones.size() != 0)
				return habitaciones;
		return null;
	}

}