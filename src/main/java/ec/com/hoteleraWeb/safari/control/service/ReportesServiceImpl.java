package ec.com.hoteleraWeb.safari.control.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.control.dao.ReportesDao;
import ec.com.hoteleraWeb.safari.control.entityAux.HotelReservacionTO;
import ec.com.hoteleraWeb.safari.control.entityAux.ReporteClienteReservacionTO;

@Service
public class ReportesServiceImpl implements ReportesService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ReportesDao reportesDao;

	public List<HotelReservacionTO> obtenerCantidadReservasPorHotel() {
		return reportesDao.obtenerCantidadReservasPorHotel();
	}

	public List<ReporteClienteReservacionTO> obtenerClienteReservacionCanceladas(Integer codigoHotel) {
		return reportesDao.obtenerClienteReservacionCanceladas(codigoHotel);
	}
	
	public List<ReporteClienteReservacionTO> obtenerClienteReservacionEfectuadas(Integer codigoHotel) {
		return reportesDao.obtenerClienteReservacionEfectuadas(codigoHotel);
	}

}
