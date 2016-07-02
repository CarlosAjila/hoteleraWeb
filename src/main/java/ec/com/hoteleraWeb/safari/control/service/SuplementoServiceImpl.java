package ec.com.hoteleraWeb.safari.control.service;

import static ec.com.hoteleraWeb.safari.utils.UtilsAplicacion.presentaMensaje;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.control.dao.EmpleadoDao;
import ec.com.hoteleraWeb.safari.control.dao.SuplementoDao;
import ec.com.hoteleraWeb.safari.control.entity.Actividad;
import ec.com.hoteleraWeb.safari.control.entity.Empleado;
import ec.com.hoteleraWeb.safari.control.entity.Suplemento;

@Service
public class SuplementoServiceImpl implements SuplementoService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SuplementoDao suplementoDao;
	@Autowired
	private EmpleadoDao empleadoDao;

	public List<Suplemento> obtenerPorHotel(Integer CodigoHotel) {
		return actividadDao.obtenerActividadesPorHotel(CodigoHotel);
	}

	public void insertar(Actividad actividad) {
		actividad.setActActivo(true);
		actividadDao.insertar(actividad);
		presentaMensaje(FacesMessage.SEVERITY_INFO, "Empleado insertado correctamente", "cerrar", true);
	}

	public void actualizar(Actividad actividad) {
		Empleado empleado = empleadoDao.obtenerPorId(Empleado.class, 1);
		actividad.setEmpleado(empleado);
		actividad.setActActivo(true);
		actividadDao.actualizar(actividad);
		presentaMensaje(FacesMessage.SEVERITY_INFO, "Empleado modificado correctamente", "cerrar", true);
	}

	public void eliminar(Actividad actividad) {
		actividad.setActActivo(actividad.getActActivo() ? false : true);
		actividadDao.actualizar(actividad);

		if (actividad.getActActivo())
			presentaMensaje(FacesMessage.SEVERITY_INFO, "Se activo el Empleado: " + actividad.getActNombre());
		else
			presentaMensaje(FacesMessage.SEVERITY_INFO, "Se desactivo al Hotel: " + actividad.getActNombre());
	}

}
