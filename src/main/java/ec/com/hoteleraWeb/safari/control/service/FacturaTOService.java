package ec.com.hoteleraWeb.safari.control.service;

import org.springframework.beans.factory.annotation.Autowired;

import ec.com.hoteleraWeb.safari.control.entityAux.FacturaTO;

public interface FacturaTOService {

	@Autowired
	public FacturaTO obtenerTotalesFactura(Integer codigoHotel, Integer codigoReservacion);

}