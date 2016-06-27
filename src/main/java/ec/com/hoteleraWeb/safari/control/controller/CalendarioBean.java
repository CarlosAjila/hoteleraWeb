package ec.com.hoteleraWeb.safari.control.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import ec.com.hoteleraWeb.safari.control.entity.Actividad;
import ec.com.hoteleraWeb.safari.control.entity.Calendario;
import ec.com.hoteleraWeb.safari.control.entity.Empleado;
import ec.com.hoteleraWeb.safari.control.entity.Hotel;
import ec.com.hoteleraWeb.safari.control.service.ActividadService;
import ec.com.hoteleraWeb.safari.control.service.CalendarioService;
import ec.com.hoteleraWeb.safari.control.service.HotelService;
import ec.com.hoteleraWeb.safari.utils.enums.Dias;
import ec.com.hoteleraWeb.safari.utils.enums.TipoEmpleado;
import ec.com.hoteleraWeb.safari.utils.enums.Titulo;

@Controller
@Scope("session")
public class CalendarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CalendarioService calendarioService;

	@Autowired
	private HotelService hotelService;

	@Autowired
	private ActividadService actividadService;

	private List<Calendario> listaCalendarios;
	private List<Hotel> listaHoteles;
	private List<Actividad> listaActividades;
	private Actividad actividad;

	private Calendario calendario;
	private Empleado empleado;
	private Integer codigoHotel;
	private Integer codigoActividad;

	public CalendarioBean() {
	}

	@PostConstruct
	public void init() {
		limpiarObjetos();
		listaHoteles = new ArrayList<Hotel>();
		listaActividades = new ArrayList<Actividad>();
		actividad = new Actividad();
		obtenerHoteles();
		obtenerCalendarios();
	}

	public void cargarInsertar() {
		limpiarObjetos();

	}

	public void limpiarObjetos() {
		empleado = new Empleado();
		calendario = new Calendario();
		calendario.setActividad(new Actividad());
		calendario.getActividad().setEmpleado(new Empleado());

		actividad = new Actividad();
		actividad.setEmpleado(new Empleado());
		listaCalendarios = new ArrayList<Calendario>();

	}

	public void obtenerHoteles() {
		listaHoteles = hotelService
				.obtenerTodosPorUsuario(SecurityContextHolder.getContext().getAuthentication().getName());
	}

	public void obtenerActividadesPorHotel() {
		System.out.println("=========================");
		listaActividades = new ArrayList<Actividad>();
		listaActividades = actividadService.obtenerActividadesPorHotel(codigoHotel);// hotel
	}

	public void obtenerCalendarios() {
		listaCalendarios = calendarioService.obtenerTodos();
	}

	public List<Calendario> getListaCalendarios() {
		return listaCalendarios;
	}

	public void insertar(ActionEvent actionEvent) {
		System.out.println("==========  "+codigoActividad );
		cargarActividadCalendario();
		calendarioService.insertar(calendario);
		obtenerCalendarios();
	}
	
	public void cargarActividadCalendario() {
		calendario.setActividad(actividadService.cargarActividad(codigoActividad));
	}

	public void setListaCalendarios(List<Calendario> listaCalendarios) {
		this.listaCalendarios = listaCalendarios;
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

	public List<Hotel> getListaHoteles() {
		return listaHoteles;
	}

	public void setListaHoteles(List<Hotel> listaHoteles) {
		this.listaHoteles = listaHoteles;
	}

	public List<Actividad> getListaActividades() {
		return listaActividades;
	}

	public void setListaActividades(List<Actividad> listaActividades) {
		this.listaActividades = listaActividades;
	}

	public Integer getCodigoActividad() {
		return codigoActividad;
	}

	public void setCodigoActividad(Integer codigoActividad) {
		this.codigoActividad = codigoActividad;
	}

	public Calendario getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Dias[] getListaDias() {
		return Dias.values();
	}

}
