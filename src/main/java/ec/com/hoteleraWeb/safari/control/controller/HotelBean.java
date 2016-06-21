package ec.com.hoteleraWeb.safari.control.controller;

import static ec.com.hoteleraWeb.safari.utils.UtilsAplicacion.presentaMensaje;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
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

	private MapModel draggableModel;

	private Marker marker;

	public HotelBean() {
	}

	@PostConstruct
	public void init() {
		limpiarObjetos();
		listaHoteles = new ArrayList<Hotel>();
		obtenerHoteles();

		draggableModel = new DefaultMapModel();

		// Shared coordinates
		LatLng coord1 = new LatLng(36.879466, 30.667648);
		LatLng coord2 = new LatLng(36.883707, 30.689216);
		LatLng coord3 = new LatLng(36.879703, 30.706707);
		LatLng coord4 = new LatLng(36.885233, 30.702323);

		// Draggable
		draggableModel.addOverlay(new Marker(coord1, "Konyaalti"));
		draggableModel.addOverlay(new Marker(coord2, "Ataturk Parki"));
		draggableModel.addOverlay(new Marker(coord3, "Karaalioglu Parki"));
		draggableModel.addOverlay(new Marker(coord4, "Kaleici"));

		for (Marker premarker : draggableModel.getMarkers()) {
			premarker.setDraggable(true);
		}
	}

	public MapModel getDraggableModel() {
		return draggableModel;
	}

	public void onMarkerDrag(MarkerDragEvent event) {
		marker = event.getMarker();

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Marker Dragged", "Lat:" + marker.getLatlng().getLat() + ", Lng:" + marker.getLatlng().getLng()));
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
