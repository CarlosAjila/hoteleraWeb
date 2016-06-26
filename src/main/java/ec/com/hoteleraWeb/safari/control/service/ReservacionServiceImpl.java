package ec.com.hoteleraWeb.safari.control.service;

import static ec.com.hoteleraWeb.safari.utils.UtilsAplicacion.presentaMensaje;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.control.dao.ReservacionDao;
import ec.com.hoteleraWeb.safari.control.entity.Reservacion;

@Service
public class ReservacionServiceImpl implements ReservacionService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ReservacionDao reservacionDao;

	public List<Reservacion> obtenerTodos() {
		return reservacionDao.obtenerTodos();
	}

	public List<Reservacion> obtenerTodosPorHotel(String codigoHotel) {
		return reservacionDao.obtenerTodosPorHotel(codigoHotel);
	}

	public void insertar(Reservacion reservacion) {
		reservacion.setResCancelada(true);
		reservacionDao.insertar(reservacion);
	}

	public void actualizar(Reservacion reservacion) {
		reservacionDao.actualizar(reservacion);
	}

	public void eliminar(Reservacion reservacion) {
		reservacion.setResCancelada(reservacion.getResCancelada() ? false : true);
		reservacionDao.actualizar(reservacion);

		if (reservacion.getResCancelada())
			presentaMensaje(FacesMessage.SEVERITY_INFO,
					"Se cancelo la Reservacion Numero:" + reservacion.getResCodigo());
		else
			presentaMensaje(FacesMessage.SEVERITY_INFO,
					"Se activo la Reservacion Numero:" + reservacion.getResCodigo());

	}

}
