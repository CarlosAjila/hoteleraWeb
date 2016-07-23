package ec.com.hoteleraWeb.safari.control.dao;

import org.springframework.beans.factory.annotation.Autowired;

import ec.com.hoteleraWeb.safari.control.entityAux.FacturaTO;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDao;

public interface FacturaTODao extends GenericDao<FacturaTO, Integer> {

	@Autowired
	public FacturaTO obtenerTotalesFactura(Integer codigoHotel, Integer codigoReservacion);

}
