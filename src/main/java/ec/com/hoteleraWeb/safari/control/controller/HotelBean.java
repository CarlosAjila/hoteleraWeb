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

import ec.com.hoteleraWeb.safari.control.entity.Hotel;
import ec.com.hoteleraWeb.safari.control.service.HotelService;

@Controller
@Scope("session")
public class HotelBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private HotelService hotelService;

	private List<Hotel> listaHoteles;
	private Hotel hotel;

	public HotelBean() {
	}

	@PostConstruct
	public void init() {
		limpiarObjetos();
		listaHoteles = new ArrayList<Hotel>();
		obtenerHoteles();
	}

	public void cargarInsertar() {
		limpiarObjetos();
	}

	public void limpiarObjetos() {
		hotel = new Hotel();
	}

	public void obtenerHoteles() {
		listaHoteles = hotelService.obtenerTodos();
	}

	public void comprobarHotel() {
		String ruc = hotel.getHotRuc().trim();
		hotel = hotelService.obtenerPorRuc(ruc);
		if (hotel != null) {
			limpiarObjetos();
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Ya existe un hotel registrado con ese ruc");
		} else {
			limpiarObjetos();
			hotel.setHotRuc(ruc);
		}
	}

	public void insertar(ActionEvent actionEvent) {
		hotelService.insertarActualizar(hotel);
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
