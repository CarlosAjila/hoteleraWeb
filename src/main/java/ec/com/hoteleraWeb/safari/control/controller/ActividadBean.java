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

	private List<Actividad> listaActividades;

	private List<Hotel> listaHoteles;

	private List<Empleado> listaEmpleados;

	private Actividad actividad;

	private int codEmpleado;
	
	private Integer hotCodigo;

	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private EmpleadoService empleadoService;

	public ActividadBean() {
	}

	@PostConstruct
	public void init() {
		limpiarObjetos();
		obtenerActividades();
	}

	public void cargarInsertar() {
		actividad = new Actividad();
		obtenerHoteles();
		
	}

	public void limpiarObjetos() {
		actividad = new Actividad();
		listaActividades = new ArrayList<Actividad>();
		listaHoteles = new ArrayList<Hotel>();
	}

	public void obtenerActividades() {
		listaActividades = actividadService.obtenerTodos();
		// actividad.getEmpleado().getEmpNombre()
	}

	public void obtenerHoteles() {
		listaHoteles = hotelService.obtenerTodos();
	}
	
	public void obtenerEmpleadosHotel() {
		listaEmpleados = empleadoService.obtenerTodos();
		listaEmpleados = empleadoService.obtenerEmpleadosHotel(hotCodigo);
	}

	public void insertar(ActionEvent actionEvent) {
		actividadService.insertar(actividad, codEmpleado);
		listaActividades = actividadService.obtenerTodos();
	}

	public void actualizar(ActionEvent actionEvent) {
		if (actividad.getActNombre().isEmpty())
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar un Nombre");
		else
			actividadService.actualizar(actividad);
		listaActividades = actividadService.obtenerTodos();

	}

	public void eliminar(ActionEvent actionEvent) {
		actividadService.eliminar(actividad);
	}

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

	public Integer getHotCodigo() {
		return hotCodigo;
	}

	public void setHotCodigo(Integer hotCodigo) {
		this.hotCodigo = hotCodigo;
	}
	
	
	

}
