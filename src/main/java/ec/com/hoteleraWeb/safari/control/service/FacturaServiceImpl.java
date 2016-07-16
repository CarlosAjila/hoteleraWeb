package ec.com.hoteleraWeb.safari.control.service;

import static ec.com.hoteleraWeb.safari.utils.UtilsAplicacion.presentaMensaje;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.control.dao.FacturaDao;
import ec.com.hoteleraWeb.safari.control.entity.Factura;
import ec.com.hoteleraWeb.safari.control.entityAux.FacturaTO;

@Service
public class FacturaServiceImpl implements FacturaService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private FacturaDao facturaDao;

	public List<Factura> obtenerTodos() {
		return facturaDao.obtenerTodos();
	}

	public List<Factura> obtenerPorHotel(Integer CodigoHotel) {
		return facturaDao.obtenerPorHotel(CodigoHotel);
	}

	public void insertar(Factura factura) {
		factura.setFacAnulada(false);
		facturaDao.insertar(factura);
		presentaMensaje(FacesMessage.SEVERITY_INFO,
				"Factura numero " + factura.getFacNumero() + " insertado correctamente", "cerrar", true);
	}

	public void actualizar(Factura factura) {
		facturaDao.actualizar(factura);
		presentaMensaje(FacesMessage.SEVERITY_INFO,
				"Factura numero " + factura.getFacNumero() + " modificado correctamente", "cerrar", true);
	}

	public void eliminar(Factura factura) {
		factura.setFacAnulada(factura.getFacAnulada() ? false : true);
		facturaDao.actualizar(factura);

		if (factura.getFacAnulada())
			presentaMensaje(FacesMessage.SEVERITY_INFO, "Se anulo la factura numero: " + factura.getFacNumero());
		else
			presentaMensaje(FacesMessage.SEVERITY_INFO, "Se restauro la factura numero : " + factura.getFacNumero());
	}

	public List<Factura> obtenerPorReservacion(Integer codigoReservacion) {
		return facturaDao.obtenerPorReservacion(codigoReservacion);
	}

}
