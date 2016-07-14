package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entityAux.HotelReservacionTO;

public interface ReportesService {
	
	@Transactional
	public List<HotelReservacionTO> obtenerCantidadReservasPorHotel();

}