package ec.com.hoteleraWeb.safari.control.service;

import static ec.com.hoteleraWeb.safari.utils.UtilsAplicacion.presentaMensaje;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.control.dao.EmpleadoDao;
import ec.com.hoteleraWeb.safari.control.dao.HotelDao;
import ec.com.hoteleraWeb.safari.control.entity.Empleado;
import ec.com.hoteleraWeb.safari.control.entity.Hotel;

@Service
public class EmpleadoServiceImpl implements EmpleadoService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private EmpleadoDao empleadoDao;
	@Autowired
	private HotelDao hotelDao;

	public List<Empleado> obtenerTodos() {
		return empleadoDao.obtenerTodos();
	}

	public Empleado obtenerPorCedula(String cedula) {
		return empleadoDao.obtenerPorCedula(cedula);
	}

	public void insertar(Empleado empleado, Integer hotCodigo) {
		System.out.println(">>>>>>>> hotCodigo  "+hotCodigo);
		Hotel hotel = hotelDao.obtenerPorId(Hotel.class, hotCodigo);
		empleado.setHotel(hotel);
		empleado.setEmpActivo(true);
		empleadoDao.insertar(empleado);
		presentaMensaje(FacesMessage.SEVERITY_INFO, "Empleado insertado correctamente", "cerrar", true);
	}

	public void actualizar(Empleado empleado) {
		empleado.setEmpActivo(true);
		empleadoDao.actualizar(empleado);
		presentaMensaje(FacesMessage.SEVERITY_INFO, "Empleado modificado correctamente", "cerrar", true);
	}

	public void eliminar(Empleado empleado) {
		empleado.setEmpActivo(empleado.getEmpActivo() ? false : true);
		empleadoDao.actualizar(empleado);

		if (empleado.getEmpActivo())
			presentaMensaje(FacesMessage.SEVERITY_INFO,
					"Se activo el Empleado: " + empleado.getEmpCedula() + " - " + empleado.getEmpNombre());
		else
			presentaMensaje(FacesMessage.SEVERITY_INFO,
					"Se desactivo al Hotel: " + empleado.getEmpCedula() + " - " + empleado.getEmpNombre());
	}

	public Empleado obtenerPorCedula_Codigo(String cedula, Integer codigo) {
		return empleadoDao.obtenerPorCedula_Codigo(cedula, codigo);
	}

}
