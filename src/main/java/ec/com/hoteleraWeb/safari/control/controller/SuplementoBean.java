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
import ec.com.hoteleraWeb.safari.control.entity.Suplemento;
import ec.com.hoteleraWeb.safari.control.service.HabitacionService;
import ec.com.hoteleraWeb.safari.control.service.HotelService;
import ec.com.hoteleraWeb.safari.control.service.SuplementoService;
import ec.com.hoteleraWeb.safari.utils.enums.TipoHabitacion;

@Controller
@Scope("session")
public class SuplementoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private HabitacionService habitacionService;

	@Autowired
	private SuplementoService suplementoService;

	@Autowired
	private HotelService hotelService;

	private List<Habitacion> listaHabitacion;
	private List<Habitacion> listaHabitacionesSeleccionadas;
	private Habitacion habitacion;
	private Suplemento suplemento;
	private List<Suplemento> listaSuplemento;
	private Integer codigoHotel;
	private List<Hotel> listaHoteles;
	private boolean temporada;

	private final BigDecimal ZERO = new BigDecimal("0.00");

	public SuplementoBean() {
	}

	@PostConstruct
	public void init() {
		limpiarObjetos();
		listaSuplemento = new ArrayList<Suplemento>();
		listaHabitacion = new ArrayList<Habitacion>();
		listaHoteles = new ArrayList<Hotel>();
		listaHoteles = hotelService
				.obtenerTodosPorUsuario(SecurityContextHolder.getContext().getAuthentication().getName());
	}

	public void cargarInsertar() {
		limpiarObjetos();
	}

	public void limpiarObjetos() {
		suplemento = new Suplemento();
		habitacion = new Habitacion();
		habitacion.setHotel(new Hotel());
		habitacion.setHabPrecioReferencial(ZERO);
	}

	public void obtenerSuplementosPorHotel() {
		listaSuplemento = suplementoService.obtenerPorHotel(codigoHotel.toString());
	}

	public void renderTabla() {
		if (suplemento.getSupTemporada())
			temporada = true;
		else
			temporada = false;
		System.out.println(temporada);
	}

	public void obtenerHabitacionesPorHotel() {
		listaHabitacion = habitacionService.obtenerTodosPorHotel(codigoHotel.toString());
	}

	public void insertar(ActionEvent actionEvent) {

		System.out.println(listaHabitacionesSeleccionadas.size());

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
		else if (!habitacionService.validarHabitacion(habitacion.getHabNumero().toString(), codigoHotel.toString()))
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "El numero de la habitacion ya existe");
		else {
			Hotel hotel = hotelService.obtenerPorCodigo(codigoHotel.toString());
			habitacion.setHotel(hotel);
			habitacionService.actualizar(habitacion);
			presentaMensaje(
					FacesMessage.SEVERITY_INFO, "Se actualizo la habitacion con codigo: " + habitacion.getHabCodigo()
							+ " de tipo: " + habitacion.getHabTipo() + " en el Hotel: " + hotel.getHotNombre(),
					"cerrar", true);
			obtenerSuplementosPorHotel();
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

	public Suplemento getSuplemento() {
		return suplemento;
	}

	public void setSuplemento(Suplemento suplemento) {
		this.suplemento = suplemento;
	}

	public List<Suplemento> getListaSuplemento() {
		return listaSuplemento;
	}

	public void setListaSuplemento(List<Suplemento> listaSuplemento) {
		this.listaSuplemento = listaSuplemento;
	}

	public List<Habitacion> getListaHabitacionesSeleccionadas() {
		return listaHabitacionesSeleccionadas;
	}

	public void setListaHabitacionesSeleccionadas(List<Habitacion> listaHabitacionesSeleccionadas) {
		this.listaHabitacionesSeleccionadas = listaHabitacionesSeleccionadas;
	}

	public boolean isTemporada() {
		return temporada;
	}

	public void setTemporada(boolean temporada) {
		this.temporada = temporada;
	}

}
