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

import ec.com.hoteleraWeb.safari.control.entity.Habitacion;
import ec.com.hoteleraWeb.safari.control.entity.HabitacionSuplemento;
import ec.com.hoteleraWeb.safari.control.entity.Hotel;
import ec.com.hoteleraWeb.safari.control.entity.Suplemento;
import ec.com.hoteleraWeb.safari.control.service.HabitacionService;
import ec.com.hoteleraWeb.safari.control.service.HabitacionSuplementoService;
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
	private HabitacionSuplementoService habitacionSuplementoService;

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
	private List<HabitacionSuplemento> listaHabitacionSuplementos;
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
		listaHabitacionSuplementos = new ArrayList<HabitacionSuplemento>();
		listaHabitacionesSeleccionadas = new ArrayList<Habitacion>();
	}

	public void obtenerSuplementosPorHotel() {
		listaSuplemento = suplementoService.obtenerPorHotel(codigoHotel.toString());
	}

	public void seleccionarTodas() {
		if (suplemento.getSupTemporada() && !listaHabitacion.isEmpty()) {
			for (Habitacion habitacion : listaHabitacion) {
				listaHabitacionesSeleccionadas.add(habitacion);
			}
			temporada = true;
		} else if (!suplemento.getSupTemporada() && !listaHabitacion.isEmpty()) {
			listaHabitacionesSeleccionadas = new ArrayList<Habitacion>();
			temporada = false;
		}
	}

	public void obtenerHabitacionesPorHotel() {
		listaHabitacion = habitacionService.obtenerTodosPorHotel(codigoHotel.toString(), false);
	}

	public void cargarEditar(Suplemento suplemento) {
		obtenerHabitacionesPorHotel();
		listaHabitacionesSeleccionadas = habitacionService.obtenerPorSuplemento(suplemento.getSupCodigo());
	}

	public void insertar(ActionEvent actionEvent) {
		suplementoService.insertar(suplemento);
		if (!listaHabitacionesSeleccionadas.isEmpty()) {
			for (Habitacion habitacionSeleccionada : listaHabitacionesSeleccionadas) {
				listaHabitacionSuplementos
						.add(new HabitacionSuplemento(habitacionSeleccionada, suplemento, suplemento.getSupValor()));
			}
			habitacionSuplementoService.insertar(listaHabitacionSuplementos);
		}
	}

	public void actualizar(ActionEvent actionEvent) {
		suplementoService.actualizar(suplemento);
		if (!listaHabitacionesSeleccionadas.isEmpty()) {
			for (Habitacion habitacionSeleccionada : listaHabitacionesSeleccionadas) {
				listaHabitacionSuplementos
						.add(new HabitacionSuplemento(habitacionSeleccionada, suplemento, suplemento.getSupValor()));
			}
			habitacionSuplementoService.actualizar(listaHabitacionSuplementos);
		}
	}

	public void eliminar(ActionEvent actionEvent) {
		suplementoService.eliminar(suplemento);
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

	public List<HabitacionSuplemento> getListaHabitacionSuplementos() {
		return listaHabitacionSuplementos;
	}

	public void setListaHabitacionSuplementos(List<HabitacionSuplemento> listaHabitacionSuplementos) {
		this.listaHabitacionSuplementos = listaHabitacionSuplementos;
	}

}
