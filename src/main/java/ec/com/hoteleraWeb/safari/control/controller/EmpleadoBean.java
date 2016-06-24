package ec.com.hoteleraWeb.safari.control.controller;

import static ec.com.hoteleraWeb.safari.utils.UtilsAplicacion.presentaMensaje;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import ec.com.hoteleraWeb.safari.control.entity.Empleado;
import ec.com.hoteleraWeb.safari.control.entity.Hotel;
import ec.com.hoteleraWeb.safari.control.service.EmpleadoService;
import ec.com.hoteleraWeb.safari.control.service.HotelService;
import ec.com.hoteleraWeb.safari.utils.enums.TipoEmpleado;
import ec.com.hoteleraWeb.safari.utils.enums.Titulo;

@Controller
@Scope("session")
public class EmpleadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private EmpleadoService empleadoService;

	private List<Empleado> listaEmpleados;

	private List<Hotel> listaHoteles;

	@Autowired
	private HotelService hotelService;

	private Empleado empleado;

	private Integer codigoHotel;

	public EmpleadoBean() {
	}

	@PostConstruct
	public void init() {
		limpiarObjetos();
		listaEmpleados = new ArrayList<Empleado>();
		listaHoteles = new ArrayList<Hotel>();
		obtenerHoteles();
		// obtenerEmpleados();

	}

	public void cargarInsertar() {
		limpiarObjetos();

	}

	public void limpiarObjetos() {
		empleado = new Empleado();
		empleado.setHotel(new Hotel());
	}

	public void obtenerEmpleadosPorHotel() {
		listaEmpleados = empleadoService.obtenerEmpleadosPorHotel(codigoHotel.toString());
	}



	public void obtenerHoteles() {
		listaHoteles = hotelService
				.obtenerTodosPorUsuario(SecurityContextHolder.getContext().getAuthentication().getName());
	}

	public boolean comprobarEmpleadoInsertar() {
		boolean retorno = false;
		String cedula = empleado.getEmpCedula().trim();
		if (cedula.length() == 10) {
			if (empleadoService.obtenerPorCedula(cedula) != null) {
				empleado.setEmpCedula("");
				presentaMensaje(FacesMessage.SEVERITY_ERROR, "Ya existe un Empleado registrado con esa cédula");
			} else {
				empleado.setEmpCedula(cedula);
				retorno = true;
			}
		} else {
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar una cedula valido de 10 digitos");
			empleado.setEmpCedula("");
		}
		return retorno;
	}

	public boolean comprobarEmpleadoActualizar() {
		boolean retorno = false;
		String cedula = empleado.getEmpCedula().trim();
		if (cedula.length() == 10) {
			if (empleadoService.obtenerPorCedula_Codigo(cedula, empleado.getHotel().getHotCodigo()) == null) {
				presentaMensaje(FacesMessage.SEVERITY_ERROR, "Ya existe un Empleado registrado con ese cedula");
			} else {
				empleado.setEmpCedula(cedula);
				retorno = true;
			}
		} else {
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar una cedula valida");
			empleado.setEmpCedula("");
		}
		return retorno;
	}

	public void insertar(ActionEvent actionEvent) {

		if (comprobarEmpleadoInsertar()) {
			if (empleado.getEmpNombre().isEmpty())
				presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar el nombre del Empleado");
			else if (empleado.getEmpApellido().isEmpty())
				presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar el apellido del Empleado");
			else
				empleadoService.insertar(empleado, codigoHotel);
			listaEmpleados = empleadoService.obtenerEmpleadosPorHotel(codigoHotel.toString());
		}
	}

	public void actualizar(ActionEvent actionEvent) {
		if (comprobarEmpleadoActualizar()) {
			if (empleado.getEmpNombre().isEmpty())
				presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar un Nombre");
			else if (empleado.getEmpApellido().isEmpty())
				presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar el Apellido");
			else
				empleadoService.actualizar(empleado);
			listaEmpleados = empleadoService.obtenerEmpleadosPorHotel(codigoHotel.toString());
		}
	}

	public void eliminar(ActionEvent actionEvent) {
		empleadoService.eliminar(empleado);
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public List<Hotel> getListaHoteles() {
		return listaHoteles;
	}

	public void setListaHoteles(List<Hotel> listaHoteles) {
		this.listaHoteles = listaHoteles;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Integer getCodigoHotel() {
		return codigoHotel;
	}

	public void setCodigoHotel(Integer codigoHotel) {
		this.codigoHotel = codigoHotel;
	}

	public Titulo[] getListaTitulos() {
		return Titulo.values();
	}

	public TipoEmpleado[] getListaTipoEmpleados() {
		return TipoEmpleado.values();
	}

}
