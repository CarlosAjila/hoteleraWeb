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
import ec.com.hoteleraWeb.safari.control.service.ActividadService;

@Controller
@Scope("session")
public class ActividadBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ActividadService actividadService;

	private List<Actividad> listaActividades;

	private Actividad actividad;

	private int codEmpleado;

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
		//actividad.getEmpleado().getEmpNombre()
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

}
