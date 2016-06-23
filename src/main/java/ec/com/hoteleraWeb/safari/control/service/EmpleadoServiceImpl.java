package ec.com.hoteleraWeb.safari.control.service;

import static ec.com.hoteleraWeb.safari.utils.UtilsAplicacion.presentaMensaje;

import java.io.Serializable;
import java.util.ArrayList;
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

	public List<Empleado> obtenerEmpleadosHotel(int hotCodigo) {
		return empleadoDao.obtenerTodos();
	}

	public Empleado obtenerPorCedula(String cedula) {
		return empleadoDao.obtenerPorCedula(cedula);
	}

	public void insertar(Empleado empleado, Integer hotCodigo) {
		System.out.println(">>>>>>>> hotCodigo  " + hotCodigo);
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

	public Empleado obtenerPorCedula_Codigo(String cedula, Integer hotCodigo) {
		return empleadoDao.obtenerPorCedula_Codigo(cedula, hotCodigo);
	}

	public List<String> obtenerListaEmpleadosAutoComplete(String criterioEmpleadoBusqueda) {
		List<String> list = new ArrayList<String>();
		List<Empleado> lista = obtener(criterioEmpleadoBusqueda, 0);
		if (!lista.isEmpty())
			for (Empleado e : lista)
				list.add(e.getCiudad().getNombre() + " - " + e.getCedula() + " - " + e.getApellido() + " "
						+ e.getNombre());
		return list;
	}

	public Empleado cargarEstudiante(String estudiante) {
		return obtenerEmpleadoPorCedula(estudiante.split(" - ")[1]);
	}

	public List<Empleado> obtener(String criterioEmpleado) {
		List<Empleado> lista = new ArrayList<Empleado>();
		if ((criterioEmpleado == null || criterioEmpleado.compareToIgnoreCase("") == 0))
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "INGRESE UN CRITERIO DE BÚSQUEDA VALIDO");
		else if (criterioEmpleado != null && criterioEmpleado.length() >= 3)
			lista = empleadoDao.obtenerPorHql(
					"select e from Empleado e where (e.empCedula like ?1 or e.empNombre like ?1 or e.empApellido like ?1) and p.activo=true and e.empActivo=true",
					new Object[] { "%" + criterioEmpleado.toUpperCase() + "%" });

		if (lista.isEmpty())
			presentaMensaje(FacesMessage.SEVERITY_WARN, "NO SE ENCONTRO NINGUNA COINCIDENCIA");

		return lista;
	}

	public Empleado obtenerEmpleadoPorCedula(String cedula) {
		List<Empleado> lista = empleadoDao.obtenerPorHql(
				"select e from Empleado e where e.empCedula=?1 and p.empActivo=true", new Object[] { cedula });
		if (!lista.isEmpty())
			return lista.get(0);
		return null;
	}

}