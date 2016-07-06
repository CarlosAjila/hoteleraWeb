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
		String sql = "Select * FROM habitacion where hot_codigo='" + codigoHotel + "' ORDER BY hab_numero;";
		List<Habitacion> habitaciones = new ArrayList<Habitacion>();
		habitaciones = genericSQLDao.obtenerPorSql(sql, Habitacion.class);
		if (habitaciones != null)
			if (habitaciones.size() != 0)
				return habitaciones;
		return null;
	}

	public List<Habitacion> obtenerPorNumHabitacionYHotel(String numeroHabitacion, String codigoHotel) {
		String sql = "select * from habitacion h where h.hab_numero='" + numeroHabitacion + "' and h.hot_codigo='"
				+ codigoHotel + "';";
		List<Habitacion> habitaciones = new ArrayList<Habitacion>();
		habitaciones = genericSQLDao.obtenerPorSql(sql, Habitacion.class);
		if (habitaciones != null)
			if (habitaciones.size() != 0)
				return habitaciones;
		return null;
	}

	public Integer obtenerUltimoNumeroHabitacion(String codigoHotel) {
		String sql = "select cast(count(hab_numero)as integer) from habitacion where hot_codigo='" + codigoHotel + "';";
		Integer ultimoNumero = (Integer) genericSQLDao.obtenerPorSql(sql).get(0);
		if (ultimoNumero != null)
			return ultimoNumero;
		return 0;
	}

	public List<Habitacion> obtenerPorSuplemento(Integer codigoSuplemento) {
		String sql = "select distinct h.* from habitacion h "
				+ "inner join habitacion_suplemento hs on hs.hab_codigo=h.hab_codigo " + "where sup_codigo='"
				+ codigoSuplemento + "' order by h.hab_codigo";
		List<Habitacion> habitaciones = new ArrayList<Habitacion>();
		habitaciones = genericSQLDao.obtenerPorSql(sql, Habitacion.class);
		if (habitaciones != null)
			if (habitaciones.size() != 0)
				return habitaciones;
		return null;
	}

}