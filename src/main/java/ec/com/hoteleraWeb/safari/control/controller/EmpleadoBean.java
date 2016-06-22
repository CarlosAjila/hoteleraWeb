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

	private Integer hotCodigo;

	public EmpleadoBean() {
	}

	@PostConstruct
	public void init() {
		limpiarObjetos();
		obtenerEmpleados();
		obtenerHoteles();
	}

	public void cargarInsertar() {
		limpiarObjetos();
		obtenerHoteles();
	}

	public void limpiarObjetos() {
		empleado = new Empleado();
		empleado.setHotel(new Hotel());
		listaEmpleados = new ArrayList<Empleado>();
		listaHoteles = new ArrayList<Hotel>();
	}

	public void obtenerEmpleados() {
		listaEmpleados = empleadoService.obtenerTodos();
	}

	public void obtenerHoteles() {
		listaHoteles = hotelService.obtenerTodos();
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
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar una cedula valido de 13 digitos");
			empleado.setEmpCedula("");
		}
		return retorno;
	}

	public boolean comprobarEmpleadoActualizar() {
		boolean retorno = false;
		String cedula = empleado.getEmpCedula().trim();
		if (cedula.length() == 10) {
			if (empleadoService.obtenerPorCedula_Codigo(cedula, hotCodigo) == null) {
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
				empleadoService.insertar(empleado, hotCodigo);
			listaEmpleados = empleadoService.obtenerTodos();
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
			listaEmpleados = empleadoService.obtenerTodos();
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

	public Integer getHotCodigo() {
		return hotCodigo;
	}

	public void setHotCodigo(Integer hotCodigo) {
		this.hotCodigo = hotCodigo;
	}

	public Titulo[] getListaTitulos() {
		return Titulo.values();
	}

	public TipoEmpleado[] getListaTipoEmpleados() {
		return TipoEmpleado.values();
	}

}
