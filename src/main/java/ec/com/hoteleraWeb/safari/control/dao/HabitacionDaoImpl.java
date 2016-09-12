package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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

	public Habitacion obtenerPorCodigo(Integer codigo) {
		String sql = "Select * FROM habitaciones where hab_codigo='" + codigo + "'";
		Habitacion habitacion = new Habitacion();
		habitacion = genericSQLDao.obtenerPorSql(sql, Habitacion.class).get(0);
		if (habitacion != null)
			return habitacion;
		return null;
	}

	public List<Habitacion> obtenerTodosPorHotel(String codigoHotel, Boolean disponibles) {
		String sql = "Select * FROM habitacion where hot_codigo='" + codigoHotel + "' ORDER BY hab_numero;";
		if (disponibles)
			sql = "Select * FROM habitacion where hot_codigo='" + codigoHotel
					+ "' and hab_disponible=true ORDER BY hab_numero;";
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
				+ "inner join habitacion_suplemento hd on hd.hab_codigo=h.hab_codigo " + "where sup_codigo='"
				+ codigoSuplemento + "' order by h.hab_codigo";
		List<Habitacion> habitaciones = new ArrayList<Habitacion>();
		habitaciones = genericSQLDao.obtenerPorSql(sql, Habitacion.class);
		if (habitaciones != null)
			if (habitaciones.size() != 0)
				return habitaciones;
		return null;
	}

	public List<Habitacion> obtenerPorReservacion(Integer codigoReservacion) {
		String sql = "select distinct h.* from habitacion h "
				+ "inner join habitacion_detalle hd on hd.hab_codigo=h.hab_codigo "
				+ "inner join reservacion r on r.res_codigo=hd.res_codigo " + "where r.res_codigo='" + codigoReservacion
				+ "' order by h.hab_codigo;";
		List<Habitacion> habitaciones = new ArrayList<Habitacion>();
		habitaciones = genericSQLDao.obtenerPorSql(sql, Habitacion.class);
		if (habitaciones != null)
			if (habitaciones.size() != 0)
				return habitaciones;
		return null;
	}

	public List<Habitacion> obtenerHabitacionesDisponible(Integer codigoHotel, Date fechaIngreso, Date fechaSalida) {
		String sql = "select * from habitacion as h1 " + "WHERE h1.hot_codigo = " + codigoHotel
				+ " and h1.hab_disponible=true and h1.hab_codigo "
				+ "NOT IN (Select distinct h.hab_codigo FROM habitacion as h "
				+ "INNER JOIN habitacion_detalle as hd ON h.hab_codigo = hd.hab_codigo "
				+ "INNER JOIN reservacion as r ON hd.res_codigo = r.res_codigo " + "WHERE h.hot_codigo = " + codigoHotel
				+ " AND r.res_fecha_ingreso > '" + fechaIngreso + "' AND r.res_fecha_salido < '" + fechaSalida + "')";
		List<Habitacion> habitaciones = new ArrayList<Habitacion>();
		habitaciones = genericSQLDao.obtenerPorSql(sql, Habitacion.class);
		if (habitaciones != null)
			if (habitaciones.size() != 0)
				return habitaciones;
		return null;
	}

}