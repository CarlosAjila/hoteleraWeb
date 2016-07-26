package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entityAux.HotelReservacionTO;
import ec.com.hoteleraWeb.safari.control.entityAux.ReporteClienteReservacionTO;

public interface ReportesService {
	
	@Transactional
	public List<HotelReservacionTO> obtenerCantidadReservasPorHotel();
	@Transactional
	public List<ReporteClienteReservacionTO> obtenerClienteReservacionCanceladas(Integer codigoHotel);
	@Transactional
	public List<ReporteClienteReservacionTO> obtenerClienteReservacionEfectuadas(Integer codigoHotel);

}