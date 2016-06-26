package ec.com.hoteleraWeb.safari.control.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import ec.com.hoteleraWeb.safari.control.entity.Calendario;
import ec.com.hoteleraWeb.safari.control.entity.Empleado;
import ec.com.hoteleraWeb.safari.control.entity.Hotel;
import ec.com.hoteleraWeb.safari.control.service.CalendarioService;
import ec.com.hoteleraWeb.safari.control.service.HotelService;
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

	private List<Calendario> listaCalendarios;
	private List<Hotel> listaHoteles;
	private Empleado empleado;
	private Integer codigoHotel;
	

	public CalendarioBean() {
	}

	@PostConstruct
	public void init() {
		limpiarObjetos();
		listaHoteles = new ArrayList<Hotel>();
		obtenerHoteles();
		obtenerCalendarios();
	}

	public void cargarInsertar() {
		limpiarObjetos();

	}

	public void limpiarObjetos() {
		empleado = new Empleado();
		listaCalendarios = new ArrayList<Calendario>();

	}
	
	public void obtenerHoteles() {
		listaHoteles = hotelService
				.obtenerTodosPorUsuario(SecurityContextHolder.getContext().getAuthentication().getName());
	}

	public void obtenerCalendarios() {
		System.out.println("dfhskdhfkjs");
		listaCalendarios = calendarioService.obtenerTodos();
	}

	public List<Calendario> getListaCalendarios() {
		return listaCalendarios;
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

	public Titulo[] getListaTitulos() {
		return Titulo.values();
	}

	public TipoEmpleado[] getListaTipoEmpleados() {
		return TipoEmpleado.values();
	}

}
