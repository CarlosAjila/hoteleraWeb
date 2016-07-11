package ec.com.hoteleraWeb.safari.control.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ec.com.hoteleraWeb.safari.control.entity.Factura;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDao;

public interface FacturaDao extends GenericDao<Factura, Integer> {

	@Autowired
	public List<Factura> obtenerTodos();

	@Autowired
	public List<Factura> obtenerPorHotel(Integer codigoHotel);

	@Autowired
	public List<Factura> obtenerPorReservacion(Integer codigoReservacion);

}
