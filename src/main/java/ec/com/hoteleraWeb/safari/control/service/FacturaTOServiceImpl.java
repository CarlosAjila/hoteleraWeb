package ec.com.hoteleraWeb.safari.control.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.control.dao.FacturaTODao;
import ec.com.hoteleraWeb.safari.control.entityAux.FacturaTO;

@Service
public class FacturaTOServiceImpl implements FacturaTOService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private FacturaTODao facturaTODao;

	public FacturaTO obtenerTotalesFactura(Integer codigoHotel, Integer codigoReservacion) {
		return facturaTODao.obtenerTotalesFactura(codigoHotel, codigoReservacion);
	}

}
