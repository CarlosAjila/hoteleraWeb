package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entityAux.HotelReservacionTO;

public interface ReporteService {

	@Transactional
	public List<HotelReservacionTO> obtenerCantidadReservasPorHotel();

}