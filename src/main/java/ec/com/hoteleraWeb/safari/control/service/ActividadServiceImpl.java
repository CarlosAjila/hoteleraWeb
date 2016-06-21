package ec.com.hoteleraWeb.safari.control.service;

import static ec.com.hoteleraWeb.safari.utils.UtilsAplicacion.presentaMensaje;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.control.dao.ActividadDao;
import ec.com.hoteleraWeb.safari.control.dao.EmpleadoDao;
import ec.com.hoteleraWeb.safari.control.entity.Actividad;
import ec.com.hoteleraWeb.safari.control.entity.Empleado;

@Service
public class ActividadServiceImpl implements ActividadService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ActividadDao actividadDao;
	@Autowired
	private EmpleadoDao empleadoDao;

	public List<Actividad> obtenerTodos() {
		return actividadDao.obtenerTodos();
	}

	public void insertar(Actividad actividad, Integer empCodigo) {
		System.out.println(">>>>>>>> empCodigo  " + empCodigo);
		Empleado empleado = empleadoDao.obtenerPorId(Empleado.class, empCodigo);
		actividad.setEmpleado(empleado);
		actividad.setActActivo(true);
		actividadDao.insertar(actividad);
		presentaMensaje(FacesMessage.SEVERITY_INFO, "Empleado insertado correctamente", "cerrar", true);
	}

}
