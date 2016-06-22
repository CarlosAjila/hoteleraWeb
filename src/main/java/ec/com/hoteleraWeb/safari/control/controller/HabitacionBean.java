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

import ec.com.hoteleraWeb.safari.control.entity.Habitacion;
import ec.com.hoteleraWeb.safari.control.entity.Hotel;
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

	public boolean comprobarHotelInsertar() {
		boolean retorno = false;
		String ruc = hotel.getHotRuc().trim();
		if (ruc.length() == 13) {
			if (hotelService.obtenerPorRuc(ruc) != null) {
				hotel.setHotRuc("");
				presentaMensaje(FacesMessage.SEVERITY_ERROR, "Ya existe un hotel registrado con ese ruc");
			} else {
				hotel.setHotRuc(ruc);
				retorno = true;
			}
		} else {
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar un ruc valido de 13 digitos");
			hotel.setHotRuc("");
		}
		return retorno;
	}

	public boolean comprobarHotelActualizar() {
		boolean retorno = false;
		String ruc = hotel.getHotRuc().trim();
		if (ruc.length() == 13) {
			if (hotelService.obtenerPorRuc_Codigo(ruc, hotel.getHotCodigo()) == null) {
				hotel.setHotRuc("");
				presentaMensaje(FacesMessage.SEVERITY_ERROR, "Ya existe un hotel registrado con ese ruc");
			} else {
				hotel.setHotRuc(ruc);
				retorno = true;
			}
		} else {
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar un ruc valido de 13 digitos");
			hotel.setHotRuc("");
		}
		return retorno;
	}

	public void insertar(ActionEvent actionEvent) {
		if (comprobarHotelInsertar()) {
			if (hotel.getHotNombre().isEmpty())
				presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar un nombre");
			else if (hotel.getHotEstrella() <= 0)
				presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar el numero de estrellas del hotel");
			else
				hotelService.insertar(hotel);
			listaHoteles = hotelService.obtenerTodos();
		}
	}

	public void actualizar(ActionEvent actionEvent) {
		if (comprobarHotelActualizar()) {
			if (hotel.getHotNombre().isEmpty())
				presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar un nombre");
			else if (hotel.getHotEstrella() <= 0)
				presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar el numero de estrellas del hotel");
			else
				hotelService.actualizar(hotel);
			listaHoteles = hotelService.obtenerTodos();
		}
	}

	public void eliminar(ActionEvent actionEvent) {
		hotelService.eliminar(hotel);
	}

	public List<Hotel> getListaHoteles() {
		return listaHoteles;
	}

	public void setListaHoteles(List<Hotel> listaHoteles) {
		this.listaHoteles = listaHoteles;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
