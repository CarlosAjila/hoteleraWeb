package ec.com.hoteleraWeb.safari.control.controller;

import static ec.com.hoteleraWeb.safari.utils.UtilsAplicacion.presentaMensaje;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import ec.com.hoteleraWeb.safari.control.entity.Actividad;
import ec.com.hoteleraWeb.safari.control.entity.Empleado;
import ec.com.hoteleraWeb.safari.control.entity.Hotel;
import ec.com.hoteleraWeb.safari.control.service.ActividadService;
import ec.com.hoteleraWeb.safari.control.service.EmpleadoService;
import ec.com.hoteleraWeb.safari.control.service.HotelService;

@Controller
@Scope("session")
public class ActividadBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ActividadService actividadService;

	@Autowired
	private HotelService hotelService;

	@Autowired
	private EmpleadoService empleadoService;
	private List<Actividad> listaActividades;
	private List<Hotel> listaHoteles;
	private List<Empleado> listaEmpleados;
	private Actividad actividad;
	private String empleadoActividad;
	private Empleado empleado;
	private int codEmpleado;
	private Integer codigoHotel;
	private String empleadoString;
	private final BigDecimal ZERO = new BigDecimal("0.00");

	public ActividadBean() {
	}

	@PostConstruct
	public void init() {
		limpiarObjetos();
		obtenerHoteles();
	}

	public void cargarInsertar() {
		// actividad = new Actividad();
		// empleado.setHotel(new Hotel());
		// actividad.setEmpleado(new Empleado());
		// empleadoActividad = "";
		actividad = new Actividad();
		actividad.setActValor(ZERO);
		obtenerHoteles();

	}

	public void limpiarObjetos() {
		empleado = new Empleado();
		empleado.setHotel(new Hotel());
		actividad = new Actividad();
		actividad.setEmpleado(new Empleado());
		actividad.getEmpleado().setHotel(new Hotel());
		actividad.setActValor(ZERO);

		listaActividades = new ArrayList<Actividad>();
		listaHoteles = new ArrayList<Hotel>();

	}

	// public void obtenerActividades() {
	// listaActividades = actividadService.obtenerTodos();
	// // actividad.getEmpleado().getEmpNombre()
	// }

	public void obtenerHoteles() {
		System.out.println("sdfjsdlkjflkjsdkl");
		listaHoteles = hotelService
				.obtenerTodosPorUsuario(SecurityContextHolder.getContext().getAuthentication().getName());
	}

	public void obtenerActividadesPorHotel() {
		listaActividades = actividadService.obtenerActividadesPorHotel(codigoHotel);
	}

	public void insertar(ActionEvent actionEvent) {
		System.out.println("cedula   " + actividad.getEmpleado());
		actividadService.insertar(actividad);
		obtenerActividadesPorHotel();
		empleadoActividad = "";
	}

	public void actualizar(ActionEvent actionEvent) {
		if (actividad.getActNombre().isEmpty())
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar un Nombre");
		else
			actividadService.actualizar(actividad);
		obtenerActividadesPorHotel();

	}

	public void eliminar(ActionEvent actionEvent) {
		actividadService.eliminar(actividad);
	}

	public List<String> obtenerEmpleadoActividadPorBusqueda(String criterioEmpleadoBusqueda) {
		List<String> lista = empleadoService.obtenerListaEmpleadosAutoComplete(criterioEmpleadoBusqueda, codigoHotel);
		if (lista.size() == 1) {
			empleadoActividad = (lista.get(0));
			cargarEmpleadoActividad();
		}
		return lista;
	}

	public void cargarEmpleadoActividad() {
		System.out.println("===========================");
		System.out.println("empleadoActividad   " + empleadoActividad);
		actividad.setEmpleado(empleadoService.cargarEmpleado(empleadoActividad));
	}

	// public void cargarEmpleado(Empleado empleado) {
	// Empleado e =
	// empleadoService.obtenerPorEmpleadoId(empleado.getEmpCodigo());
	// actividad.setEmpleado(e);
	// System.out.println("cedula "+actividad.getEmpleado().getEmpCedula());
	//
	// empleadoString =
	// (e.getEmpCodigo().toString().concat("-").concat(e.getEmpCedula()).concat("-")
	// .concat(e.getEmpApellido()).concat(" ").concat(e.getEmpNombre()));
	// }

	public List<Actividad> getListaActividades() {
		return listaActividades;
	}

	public void setListaActividades(List<Actividad> listaActividades) {
		this.listaActividades = listaActividades;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public int getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(int codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public List<Hotel> getListaHoteles() {
		return listaHoteles;
	}

	public void setListaHoteles(List<Hotel> listaHoteles) {
		this.listaHoteles = listaHoteles;
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public Integer getCodigoHotel() {
		return codigoHotel;
	}

	public void setCodigoHotel(Integer codigoHotel) {
		this.codigoHotel = codigoHotel;
	}

	public String getEmpleadoActividad() {
		return empleadoActividad;
	}

	public void setEmpleadoActividad(String empleadoActividad) {
		this.empleadoActividad = empleadoActividad;
	}

	public String getEmpleadoString() {
		return empleadoString;
	}

	public void setEmpleadoString(String empleadoString) {
		this.empleadoString = empleadoString;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}
