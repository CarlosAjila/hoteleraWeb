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

import ec.com.hoteleraWeb.safari.control.entity.Habitacion;
import ec.com.hoteleraWeb.safari.control.entity.Hotel;
import ec.com.hoteleraWeb.safari.control.service.HabitacionService;
import ec.com.hoteleraWeb.safari.control.service.HotelService;

@Controller
@Scope("session")
public class HabitacionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private HabitacionService habitacionService;

	@Autowired
	private HotelService hotelService;

	private List<Habitacion> listaHabitacion;
	private Habitacion habitacion;
	private Integer codigoHotel;
	private List<Hotel> listaHoteles;

	public HabitacionBean() {
	}

	@PostConstruct
	public void init() {
		limpiarObjetos();
		listaHabitacion = new ArrayList<Habitacion>();
		listaHoteles = new ArrayList<Hotel>();
		listaHoteles = hotelService
				.obtenerTodosPorUsuario(SecurityContextHolder.getContext().getAuthentication().getName());
	}

	public void cargarInsertar() {
		limpiarObjetos();
	}

	public void limpiarObjetos() {
		habitacion = new Habitacion();
		habitacion.setHotel(new Hotel());
	}

	public void obtenerHabitacionesPorHotel() {
		listaHabitacion = habitacionService.obtenerTodosPorHotel(codigoHotel.toString());
	}

	public void insertar(ActionEvent actionEvent) {

	}

	public void actualizar(ActionEvent actionEvent) {

	}

	public void eliminar(ActionEvent actionEvent) {
		habitacionService.eliminar(habitacion);
	}

	public List<Habitacion> getListaHabitacion() {
		return listaHabitacion;
	}

	public void setListaHabitacion(List<Habitacion> listaHabitacion) {
		this.listaHabitacion = listaHabitacion;
	}

	public Habitacion gethabitacion() {
		return habitacion;
	}

	public void sethabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
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

}
