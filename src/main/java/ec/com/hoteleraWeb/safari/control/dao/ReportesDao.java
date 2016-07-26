package ec.com.hoteleraWeb.safari.control.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entityAux.HotelReservacionTO;
import ec.com.hoteleraWeb.safari.control.entityAux.ReporteClienteReservacionTO;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDao;

public interface ReportesDao extends GenericDao<HotelReservacionTO, Integer> {

	@Transactional
	public List<HotelReservacionTO> obtenerCantidadReservasPorHotel();
	@Transactional
	public List<ReporteClienteReservacionTO> obtenerClienteReservacionCanceladas(Integer codigoHotel);
	@Transactional
	public List<ReporteClienteReservacionTO> obtenerClienteReservacionEfectuadas(Integer codigoHotel);

}
