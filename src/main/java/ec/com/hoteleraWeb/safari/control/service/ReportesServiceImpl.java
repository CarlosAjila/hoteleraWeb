package ec.com.hoteleraWeb.safari.control.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.control.dao.ReportesDao;
import ec.com.hoteleraWeb.safari.control.entityAux.HotelReservacionTO;

@Service
public class ReportesServiceImpl implements ReportesService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ReportesDao reportesDao;

	public List<HotelReservacionTO> obtenerCantidadReservasPorHotel() {
		return reportesDao.obtenerCantidadReservasPorHotel();
	}

}
