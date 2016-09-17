package ec.com.hoteleraWeb.safari.control.controller;

import static ec.com.hoteleraWeb.safari.utils.UtilsAplicacion.presentaMensaje;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import ec.com.hoteleraWeb.safari.control.entity.Hotel;
import ec.com.hoteleraWeb.safari.control.entity.Usuario;
import ec.com.hoteleraWeb.safari.control.service.HotelService;
import ec.com.hoteleraWeb.safari.control.service.UsuarioService;
import ec.com.hoteleraWeb.safari.seguridad.entity.Rol;
import ec.com.hoteleraWeb.safari.seguridad.service.RolService;

@Controller
@Scope("session")
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private HotelService hotelService;

	@Autowired
	private RolService rolService;

	private List<Usuario> listaUsuarios;

	private List<Hotel> listaHoteles;

	private List<Rol> listaRoles;

	private Usuario usuario;

	private Integer codigoHotel;

	private Integer codigoRol;

	public UsuarioBean() {
	}

	@PostConstruct
	public void init() {
		limpiarObjetos();
		listaUsuarios = new ArrayList<Usuario>();
		listaHoteles = new ArrayList<Hotel>();

		obtenerHoteles();
		// obtenerRoles();
		// obtenerEmpleados();

	}

	public void cargarInsertar() {
		limpiarObjetos();
		obtenerRoles();

	}

	public void limpiarObjetos() {
		usuario = new Usuario();
		listaRoles = new ArrayList<Rol>();
		// empleado.setHotel(new Hotel());
	}

	public void obtenerUsuariosPorHotel() {
		listaUsuarios = usuarioService.obtenerUsuarioPorHotel(codigoHotel.toString());
	}

	public void obtenerHoteles() {
		listaHoteles = hotelService
				.obtenerTodosPorUsuario(SecurityContextHolder.getContext().getAuthentication().getName());
	}

	public void obtenerRoles() {
		System.out.println("dfgklhkld dhfglhdl ");
		listaRoles = rolService.obtenerListaRol();
		for (Rol rol : listaRoles) {
			System.out.println("jhklfjl " + rol.getRolNombre());
		}
	}

	public void insertar() {
		System.out.println("dfgklhkld dhfglhdl ");
		if (codigoHotel == null || codigoHotel == 0) {
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe escoger un hotel");
		} else if (usuario.getUsuNick() == null || usuario.getUsuNick().isEmpty()) {
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar un nick");
		} else if (usuario.getUsuPassword() == null || usuario.getUsuPassword().isEmpty()) {
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar una contraseña");
		} else if (codigoRol == null || codigoRol == 0) {
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe escoger un rol");
		}else{
			
		}
	}

	public boolean comprobarUsuarioInsertar() {
		// boolean retorno = false;
		// String cedula = empleado.getEmpCedula().trim();
		// if (cedula.length() == 10) {
		// if (empleadoService.obtenerPorCedula(cedula) != null) {
		// empleado.setEmpCedula("");
		// presentaMensaje(FacesMessage.SEVERITY_ERROR, "Ya existe un Empleado
		// registrado con esa cédula");
		// } else {
		// empleado.setEmpCedula(cedula);
		// retorno = true;
		// }
		// } else {
		// presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar una
		// cedula valido de 10 digitos");
		// empleado.setEmpCedula("");
		// }
		// return retorno;
		return true;
	}

	public List<Rol> getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(List<Rol> listaRoles) {
		this.listaRoles = listaRoles;
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

	public Integer getCodigoRol() {
		return codigoRol;
	}

	public void setCodigoRol(Integer codigoRol) {
		this.codigoRol = codigoRol;
	}

}
