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

	public Habitacion obtenerPorRuc(String ruc) {
		return habitacionDao.obtenerPorRuc(ruc);
	}

	public Habitacion obtenerPorRuc_Codigo(String ruc, Integer codigo) {
		return habitacionDao.obtenerPorRuc_Codigo(ruc, codigo);
	}

	public void insertar(Habitacion habitacion) {
		habitacion.setHabActivo(true);
		habitacionDao.insertar(habitacion);
		presentaMensaje(FacesMessage.SEVERITY_INFO, "Hotel insertado correctamente", "cerrar", true);
	}

	public void actualizar(Habitacion habitacion) {
		habitacion.setHabActivo(true);
		habitacionDao.actualizar(habitacion);
		presentaMensaje(FacesMessage.SEVERITY_INFO, "Hotel modificado correctamente", "cerrar", true);
	}

	public void eliminar(Habitacion habitacion) {
		habitacion.setHabActivo(habitacion.getHabActivo() ? false : true);
		habitacionDao.actualizar(habitacion);

		if (habitacion.getHabActivo())
			presentaMensaje(FacesMessage.SEVERITY_INFO, "Se activo al Hotel: " + habitacion.getHabActivo());
		else
			presentaMensaje(FacesMessage.SEVERITY_INFO, "Se desactivo al Hotel: " + habitacion.getHabActivo());
	}

}
