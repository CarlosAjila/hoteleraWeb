package ec.com.hoteleraWeb.safari.control.service;

import static ec.com.hoteleraWeb.safari.utils.UtilsAplicacion.presentaMensaje;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.control.dao.HabitacionDao;
import ec.com.hoteleraWeb.safari.control.entity.Habitacion;

@Service
public class HabitacionServiceImpl implements HabitacionService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private HabitacionDao habitacionDao;

	public List<Habitacion> obtenerTodos() {
		return habitacionDao.obtenerTodos();
	}

	public List<Habitacion> obtenerTodosPorHotel(String codigoHotel, Boolean disponibles) {
		return habitacionDao.obtenerTodosPorHotel(codigoHotel, disponibles);
	}

	public void insertar(Habitacion habitacion) {
		habitacion.setHabActivo(true);
		habitacionDao.insertar(habitacion);
	}

	public void actualizar(Habitacion habitacion) {
		habitacionDao.actualizar(habitacion);
	}

	public void eliminar(Habitacion habitacion) {
		habitacion.setHabActivo(habitacion.getHabActivo() ? false : true);
		habitacionDao.actualizar(habitacion);

		if (habitacion.getHabActivo())
			presentaMensaje(FacesMessage.SEVERITY_INFO,
					"Se activo la Habitacion: " + habitacion.getHabCodigo() + " - de tipo: " + habitacion.getHabTipo());
		else
			presentaMensaje(FacesMessage.SEVERITY_INFO, "Se desactivo la Habitacion: " + habitacion.getHabCodigo()
					+ " - de tipo: " + habitacion.getHabTipo());

	}

	public boolean validarHabitacion(String numeroHabitacion, String codigoHotel) {
		Boolean retorno = false;
		if (habitacionDao.obtenerPorNumHabitacionYHotel(numeroHabitacion, codigoHotel) == null)
			retorno = true;
		return retorno;
	}

	public Integer obtenerUltimoNumeroHabitacion(String codigoHotel) {
		return habitacionDao.obtenerUltimoNumeroHabitacion(codigoHotel);
	}

	public List<Habitacion> obtenerPorSuplemento(Integer codigoSuplemento) {
		return habitacionDao.obtenerPorSuplemento(codigoSuplemento);
	}

}
