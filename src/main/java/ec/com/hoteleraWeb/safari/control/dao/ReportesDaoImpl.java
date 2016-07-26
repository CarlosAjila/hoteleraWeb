package ec.com.hoteleraWeb.safari.control.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entityAux.HotelReservacionTO;
import ec.com.hoteleraWeb.safari.control.entityAux.ReporteClienteReservacionTO;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;
import ec.com.hoteleraWeb.safari.utils.dao.GenericSQLDao;

@Repository
public class ReportesDaoImpl extends GenericDaoImpl<HotelReservacionTO, Integer> implements ReportesDao {

	@Autowired
	private GenericSQLDao genericSQLDao;

	public List<HotelReservacionTO> obtenerCantidadReservasPorHotel() {
		String sql = "SELECT * from fun_reporte_numero_reservacion_por_hotel();";
		return genericSQLDao.obtenerPorSql(sql, HotelReservacionTO.class);
	}

	public List<ReporteClienteReservacionTO> obtenerClienteReservacionCanceladas(Integer codigoHotel) {
		String sql = "SELECT * from fun_reporte_cliente_reservacion("+codigoHotel+", "+false+");";
		return genericSQLDao.obtenerPorSql(sql, ReporteClienteReservacionTO.class);
	}
	
	public List<ReporteClienteReservacionTO> obtenerClienteReservacionEfectuadas(Integer codigoHotel) {
		String sql = "SELECT * from fun_reporte_cliente_reservacion("+codigoHotel+", "+true+");";
		return genericSQLDao.obtenerPorSql(sql, ReporteClienteReservacionTO.class);
	}

}