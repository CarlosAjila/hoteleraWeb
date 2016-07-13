package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.Reservacion;
import ec.com.hoteleraWeb.safari.control.entityAux.HotelReservacionTO;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;
import ec.com.hoteleraWeb.safari.utils.dao.GenericSQLDao;

@Repository
public class ReservacionDaoImpl extends GenericDaoImpl<Reservacion, Integer> implements ReservacionDao, Serializable {

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
		String sql = "select distinct r.* from reservacion r "
				+ "inner join habitacion_detalle hd on r.res_codigo=hd.res_codigo "
				+ "inner join habitacion h on hd.hab_codigo=h.hab_codigo " + "where h.hot_codigo='" + codigoHotel + "'";
		List<Reservacion> reservaciones = new ArrayList<Reservacion>();
		reservaciones = genericSQLDao.obtenerPorSql(sql, Reservacion.class);
		if (reservaciones != null)
			if (reservaciones.size() != 0)
				return reservaciones;
		return null;
	}

	public List<HotelReservacionTO> obtenerCantidadReservasPorHotel() {
		String sql = "SELECT * from fun_reporte_numero_reservacion_por_hotel();";
		return genericSQLDao.obtenerPorSql(sql, HotelReservacionTO.class);
	}

}