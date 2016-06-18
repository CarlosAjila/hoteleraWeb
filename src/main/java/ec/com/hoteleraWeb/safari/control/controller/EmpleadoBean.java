package ec.com.hoteleraWeb.safari.control.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ec.com.hoteleraWeb.safari.control.entity.Empleado;
import ec.com.hoteleraWeb.safari.control.entity.Hotel;
import ec.com.hoteleraWeb.safari.control.service.EmpleadoService;

@Controller
@Scope("session")
public class EmpleadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private EmpleadoService empleadoService;

	private List<Empleado> listaEmpleados;
	private Empleado empleado;

	public EmpleadoBean() {
	}

	@PostConstruct
	public void init() {
		limpiarObjetos();
		obtenerEmpleados();
	}

	public void limpiarObjetos() {
		empleado = new Empleado();
		listaEmpleados = new ArrayList<Empleado>();
	}

	public void obtenerEmpleados() {
		listaEmpleados = empleadoService.obtenerTodos();
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaHoteles(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}
