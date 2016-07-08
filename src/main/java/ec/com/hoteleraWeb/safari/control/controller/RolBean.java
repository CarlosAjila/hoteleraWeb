package ec.com.hoteleraWeb.safari.control.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ec.com.hoteleraWeb.safari.seguridad.entity.Rol;
import ec.com.hoteleraWeb.safari.seguridad.service.RolService;

@Controller
@Scope("session")
public class RolBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RolService rolService;

	private List<Rol> listaRoles;

	public RolBean() {
	}

	@PostConstruct
	public void init() {
		limpiarObjetos();
		listaRoles = new ArrayList<Rol>();
		obtenerListaRol();
		// obtenerEmpleados();

	}

	public void cargarInsertar() {
		limpiarObjetos();

	}

	public void limpiarObjetos() {
		// usuario = new Usuario();
		// empleado.setHotel(new Hotel());
	}

	public void obtenerListaRol() {
		listaRoles = rolService.obtenerListaRol();
	}

}
