package ec.com.hoteleraWeb.safari.control.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ec.com.hoteleraWeb.safari.control.entity.Actividad;
import ec.com.hoteleraWeb.safari.control.service.ActividadService;

@Controller
@Scope("session")
public class ActividadBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ActividadService actividadService;

	private List<Actividad> listaActividades;

	private Actividad actividad;
	



	public ActividadBean() {
	}

	@PostConstruct
	public void init() {
		System.out.println("dsfghkdfshgkhdfkghkjd");
		limpiarObjetos();
		obtenerActividades();
	}

	public void cargarInsertar() {
		limpiarObjetos();

	}
	


	public void limpiarObjetos() {
		actividad = new Actividad();
		listaActividades = new ArrayList<Actividad>();
	}

	public void obtenerActividades() {
		listaActividades = actividadService.obtenerTodos();
	}


	public void insertar(ActionEvent actionEvent) {
		actividadService.insertar(actividad, 1);
		listaActividades = actividadService.obtenerTodos();
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


	
	

}
