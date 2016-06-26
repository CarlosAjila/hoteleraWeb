package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.Reservacion;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;
import ec.com.hoteleraWeb.safari.utils.dao.GenericSQLDao;

@Repository
public class ReservacionDaoImpl extends GenericDaoImpl<Reservacion, Integer>
		implements ReservacionDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private GenericSQLDao genericSQLDao;

	public List<Reservacion> obtenerTodos() {
		String sql = "Select * FROM reservacion";
		List<Reservacion> reservaciones = new ArrayList<Reservacion>();
		reservaciones = genericSQLDao.obtenerPorSql(sql, Reservacion.class);
		if (reservaciones != null)
			if (reservaciones.size() != 0)
				return reservaciones;
		return null;
	}

	public List<Reservacion> obtenerTodosPorHotel(String codigoHotel) {
		String sql = "select r.* from reservacion r "
				+ "inner join empleado on r.emp_codigo=empleado.emp_codigo "
				+ "inner join hotel on empleado.hot_codigo=hotel.hot_codigo "
				+ "where hotel.hot_codigo='"+ codigoHotel + "';";
		List<Reservacion> reservaciones = new ArrayList<Reservacion>();
		reservaciones = genericSQLDao.obtenerPorSql(sql, Reservacion.class);
		if (reservaciones != null)
			if (reservaciones.size() != 0)
				return reservaciones;
		return null;
	}

}