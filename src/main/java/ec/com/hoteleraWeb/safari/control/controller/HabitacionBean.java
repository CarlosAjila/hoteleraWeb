package ec.com.hoteleraWeb.safari.control.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ec.com.hoteleraWeb.safari.control.entity.Habitacion;
import ec.com.hoteleraWeb.safari.control.service.HabitacionService;

@Controller
@Scope("session")
public class HabitacionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private HabitacionService habitacionService;

	private List<Habitacion> listaHabitacion;
	private Habitacion habitacion;

	public HabitacionBean() {
	}

	@PostConstruct
	public void init() {
		limpiarObjetos();
		listaHabitacion = new ArrayList<Habitacion>();
		obtenerHabitaciones();
	}

	public void cargarInsertar() {
		limpiarObjetos();
	}

	public void limpiarObjetos() {
		habitacion = new Habitacion();
	}

	public void obtenerHabitaciones() {
		listaHabitacion = habitacionService.obtenerTodos();
	}

	public void insertar(ActionEvent actionEvent) {

	}

	public void actualizar(ActionEvent actionEvent) {

	}

	public void eliminar(ActionEvent actionEvent) {
		habitacionService.eliminar(habitacion);
	}

	public List<Habitacion> getListahabitacion() {
		return listaHabitacion;
	}

	public void setListahabitacion(List<Habitacion> listaHabitacion) {
		this.listaHabitacion = listaHabitacion;
	}

	public Habitacion gethabitacion() {
		return habitacion;
	}

	public void sethabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

}
