package ec.com.hoteleraWeb.safari.control.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import ec.com.hoteleraWeb.safari.control.entity.Cliente;
import ec.com.hoteleraWeb.safari.control.entity.Empleado;
import ec.com.hoteleraWeb.safari.control.entity.Hotel;
import ec.com.hoteleraWeb.safari.control.entity.Reservacion;
import ec.com.hoteleraWeb.safari.control.service.EmpleadoService;
import ec.com.hoteleraWeb.safari.control.service.HotelService;
import ec.com.hoteleraWeb.safari.control.service.ReservacionService;

@Controller
@Scope("session")
public class ReservacionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ReservacionService reservacionService;

	@Autowired
	private HotelService hotelService;

	@Autowired
	private EmpleadoService empleadoService;

	private List<Reservacion> listaReservacion;
	private Reservacion reservacion;
	private Integer codigoHotel;
	private List<Hotel> listaHoteles;
	private String empleadoReservacion;

	private final BigDecimal ZERO = new BigDecimal("0.00");

	public ReservacionBean() {
	}

	@PostConstruct
	public void init() {
		limpiarObjetos();
		listaReservacion = new ArrayList<Reservacion>();
		listaHoteles = new ArrayList<Hotel>();
		listaHoteles = hotelService
				.obtenerTodosPorUsuario(SecurityContextHolder.getContext().getAuthentication().getName());
	}

	public void cargarInsertar() {
		limpiarObjetos();
	}

	public void limpiarObjetos() {
		reservacion = new Reservacion();
		reservacion.setCliente(new Cliente());
		reservacion.setEmpleado(new Empleado());
	}

	public void obtenerReservacionesPorHotel() {
		listaReservacion = reservacionService.obtenerTodosPorHotel(codigoHotel.toString());
	}

	public List<String> obtenerEmpleadoReservacionPorBusqueda(String criterioEmpleadoBusqueda) {
		List<String> lista = empleadoService.obtenerListaEmpleadosAutoComplete(criterioEmpleadoBusqueda);
		if (lista.size() == 1) {
			empleadoReservacion = (lista.get(0));
			cargarEmpleadoReservacion();
		}
		return lista;
	}

	public void cargarEmpleadoReservacion() {
		reservacion.setEmpleado(empleadoService.cargarEmpleado(empleadoReservacion));
	}

	public void insertar(ActionEvent actionEvent) {
		// if (codigoHotel == 0)
		// presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe escojer un
		// hotel");
		// else if (Reservacion.getHabDescripcion().isEmpty())
		// presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar una
		// descripcion");
		// else if (Reservacion.getHabPrecioReferencial().compareTo(ZERO) == 0)
		// presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar un
		// precio");
		// else if (Reservacion.getHabTipo().compareTo("0") == 0)
		// presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe escojer un tipo de
		// Reservacion");
		// else {
		// Hotel hotel = hotelService.obtenerPorCodigo(codigoHotel.toString());
		// Reservacion.setHotel(hotel);
		// ReservacionService.insertar(Reservacion);
		// presentaMensaje(
		// FacesMessage.SEVERITY_INFO, "Se creo la Reservacion con codigo: " +
		// Reservacion.getHabCodigo()
		// + " de tipo: " + Reservacion.getHabTipo() + " en el Hotel: " +
		// hotel.getHotNombre(),
		// "cerrar", true);
		// obtenerReservacionesPorHotel();
		// codigoHotel = hotel.getHotCodigo();
		// }

	}

	public void actualizar(ActionEvent actionEvent) {
		// if (codigoHotel == 0)
		// presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe escojer un
		// hotel");
		// else if (Reservacion.getHabDescripcion().isEmpty())
		// presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar una
		// descripcion");
		// else if (Reservacion.getHabPrecioReferencial().compareTo(ZERO) == 0)
		// presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar un
		// precio");
		// else if (Reservacion.getHabTipo().compareTo("0") == 0)
		// presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe escojer un tipo de
		// Reservacion");
		// else {
		// Hotel hotel = hotelService.obtenerPorCodigo(codigoHotel.toString());
		// Reservacion.setHotel(hotel);
		// ReservacionService.actualizar(Reservacion);
		// presentaMensaje(
		// FacesMessage.SEVERITY_INFO, "Se actualizo la Reservacion con codigo:
		// " + Reservacion.getHabCodigo()
		// + " de tipo: " + Reservacion.getHabTipo() + " en el Hotel: " +
		// hotel.getHotNombre(),
		// "cerrar", true);
		// obtenerReservacionesPorHotel();
		// codigoHotel = hotel.getHotCodigo();
		// }

	}

	public void eliminar(ActionEvent actionEvent) {
		// reservacionService.eliminar(reservacion);
	}

	public List<Reservacion> getListaReservacion() {
		return listaReservacion;
	}

	public void setListaReservacion(List<Reservacion> listaReservacion) {
		this.listaReservacion = listaReservacion;
	}

	public Reservacion getReservacion() {
		return reservacion;
	}

	public void setReservacion(Reservacion reservacion) {
		this.reservacion = reservacion;
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

	public String getEmpleadoReservacion() {
		return empleadoReservacion;
	}

	public void setEmpleadoReservacion(String empleadoReservacion) {
		this.empleadoReservacion = empleadoReservacion;
	}

}
