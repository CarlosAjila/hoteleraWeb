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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import ec.com.hoteleraWeb.safari.control.entity.Empleado;
import ec.com.hoteleraWeb.safari.control.entity.Hotel;
import ec.com.hoteleraWeb.safari.control.entity.Usuario;
import ec.com.hoteleraWeb.safari.control.service.HotelService;
import ec.com.hoteleraWeb.safari.control.service.UsuarioService;
import ec.com.hoteleraWeb.safari.utils.enums.TipoEmpleado;
import ec.com.hoteleraWeb.safari.utils.enums.Titulo;

@Controller
@Scope("session")
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioService usuarioService;

	private List<Usuario> listaUsuarios;

	private List<Hotel> listaHoteles;

	@Autowired
	private HotelService hotelService;

	private Usuario usuario;

	private Integer codigoHotel;

	public UsuarioBean() {
	}

	@PostConstruct
	public void init() {
		limpiarObjetos();
		listaUsuarios = new ArrayList<Usuario>();
		listaHoteles = new ArrayList<Hotel>();
		obtenerHoteles();
		// obtenerEmpleados();

	}

	public void cargarInsertar() {
		limpiarObjetos();

	}

	public void limpiarObjetos() {
		usuario = new Usuario();
		//empleado.setHotel(new Hotel());
	}

	public void obtenerUsuariosPorHotel() {
		listaUsuarios = usuarioService.obtenerUsuarioPorHotel(codigoHotel.toString());
	}

	public void obtenerHoteles() {
		listaHoteles = hotelService
				.obtenerTodosPorUsuario(SecurityContextHolder.getContext().getAuthentication().getName());
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<Hotel> getListaHoteles() {
		return listaHoteles;
	}

	public void setListaHoteles(List<Hotel> listaHoteles) {
		this.listaHoteles = listaHoteles;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getCodigoHotel() {
		return codigoHotel;
	}

	public void setCodigoHotel(Integer codigoHotel) {
		this.codigoHotel = codigoHotel;
	}


}
