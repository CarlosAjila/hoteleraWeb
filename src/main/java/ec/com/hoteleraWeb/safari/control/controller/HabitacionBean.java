package ec.com.hoteleraWeb.safari.control.controller;

import static ec.com.hoteleraWeb.safari.utils.UtilsAplicacion.presentaMensaje;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import ec.com.hoteleraWeb.safari.control.entity.Habitacion;
import ec.com.hoteleraWeb.safari.control.entity.Hotel;
import ec.com.hoteleraWeb.safari.control.service.HabitacionService;
import ec.com.hoteleraWeb.safari.control.service.HotelService;
import ec.com.hoteleraWeb.safari.utils.enums.TipoHabitacion;

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

	private Integer numeroHabitacion;

	private final BigDecimal ZERO = new BigDecimal("0.00");

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
		asignarNumeroHabitacion();
	}

	public void asignarNumeroHabitacion() {
		if (codigoHotel != null)
			habitacion.setHabNumero(habitacionService.obtenerUltimoNumeroHabitacion(codigoHotel.toString()) + 1);
	}

	public void limpiarObjetos() {
		habitacion = new Habitacion();
		habitacion.setHotel(new Hotel());
		habitacion.setHabPrecioReferencial(ZERO);
	}

	public void obtenerHabitacionesPorHotel() {
		listaHabitacion = habitacionService.obtenerTodosPorHotel(codigoHotel.toString(), false);
	}

	public void insertar(ActionEvent actionEvent) {
		if (codigoHotel == 0)
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe escojer un hotel");
		else if (habitacion.getHabDescripcion().isEmpty())
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar una descripcion");
		else if (habitacion.getHabPrecioReferencial().compareTo(ZERO) == 0)
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar un precio");
		else if (habitacion.getHabTipo().compareTo("0") == 0)
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe escojer un tipo de habitacion");
		else if (!habitacionService.validarHabitacion(habitacion.getHabNumero().toString(), codigoHotel.toString()))
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "El numero de la habitacion ya existe");
		else {
			Hotel hotel = hotelService.obtenerPorCodigo(codigoHotel.toString());
			habitacion.setHotel(hotel);
			habitacion.setHabDisponible(true);
			habitacionService.insertar(habitacion);
			presentaMensaje(
					FacesMessage.SEVERITY_INFO, "Se creo la habitacion con codigo: " + habitacion.getHabCodigo()
							+ " de tipo: " + habitacion.getHabTipo() + " en el Hotel: " + hotel.getHotNombre(),
					"cerrar", true);
			obtenerHabitacionesPorHotel();
			codigoHotel = hotel.getHotCodigo();
		}

	}

	public void cargarEditar(Habitacion habitacion) {
		numeroHabitacion = habitacion.getHabNumero();
	}

	public void actualizar(ActionEvent actionEvent) {
		if (codigoHotel == 0)
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe escojer un hotel");
		else if (habitacion.getHabDescripcion().isEmpty())
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar una descripcion");
		else if (habitacion.getHabPrecioReferencial().compareTo(ZERO) == 0)
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar un precio");
		else if (habitacion.getHabTipo().compareTo("0") == 0)
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe escojer un tipo de habitacion");
		if (numeroHabitacion == habitacion.getHabNumero()) {
			Hotel hotel = hotelService.obtenerPorCodigo(codigoHotel.toString());
			habitacion.setHotel(hotel);
			habitacionService.actualizar(habitacion);
			presentaMensaje(
					FacesMessage.SEVERITY_INFO, "Se actualizo la habitacion con codigo: " + habitacion.getHabCodigo()
							+ " de tipo: " + habitacion.getHabTipo() + " en el Hotel: " + hotel.getHotNombre(),
					"cerrar", true);
			obtenerHabitacionesPorHotel();
			codigoHotel = hotel.getHotCodigo();
		} else if (!habitacionService.validarHabitacion(habitacion.getHabNumero().toString(), codigoHotel.toString())) {
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "El numero de la habitacion ya existe");
		} else {
			Hotel hotel = hotelService.obtenerPorCodigo(codigoHotel.toString());
			habitacion.setHotel(hotel);
			habitacionService.actualizar(habitacion);
			presentaMensaje(
					FacesMessage.SEVERITY_INFO, "Se actualizo la habitacion con codigo: " + habitacion.getHabCodigo()
							+ " de tipo: " + habitacion.getHabTipo() + " en el Hotel: " + hotel.getHotNombre(),
					"cerrar", true);
			obtenerHabitacionesPorHotel();
			codigoHotel = hotel.getHotCodigo();
		}
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

	public TipoHabitacion[] getListaTipoHabitacion() {
		return TipoHabitacion.values();
	}

}
