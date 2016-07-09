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

import ec.com.hoteleraWeb.safari.control.entity.Actividad;
import ec.com.hoteleraWeb.safari.control.entity.Cliente;
import ec.com.hoteleraWeb.safari.control.entity.ClienteActividad;
import ec.com.hoteleraWeb.safari.control.entity.Habitacion;
import ec.com.hoteleraWeb.safari.control.entity.HabitacionDetalle;
import ec.com.hoteleraWeb.safari.control.entity.Hotel;
import ec.com.hoteleraWeb.safari.control.entity.Reservacion;
import ec.com.hoteleraWeb.safari.control.entity.Suplemento;
import ec.com.hoteleraWeb.safari.control.entity.Usuario;
import ec.com.hoteleraWeb.safari.control.service.ActividadService;
import ec.com.hoteleraWeb.safari.control.service.ClienteActividadService;
import ec.com.hoteleraWeb.safari.control.service.ClienteService;
import ec.com.hoteleraWeb.safari.control.service.HabitacionDetalleService;
import ec.com.hoteleraWeb.safari.control.service.HabitacionService;
import ec.com.hoteleraWeb.safari.control.service.HotelService;
import ec.com.hoteleraWeb.safari.control.service.ReservacionService;
import ec.com.hoteleraWeb.safari.control.service.UsuarioService;

@Controller
@Scope("session")
public class ReservacionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ReservacionService reservacionService;

	@Autowired
	private HotelService hotelService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private HabitacionService habitacionService;

	@Autowired
	private ActividadService actividadService;

	@Autowired
	private HabitacionDetalleService habitacionDetalleService;

	@Autowired
	private ClienteActividadService clienteActividadService;

	private List<Reservacion> listaReservacion;
	private Reservacion reservacion;
	private Integer codigoHotel;
	private List<Hotel> listaHoteles;
	private String clienteReservacion;
	private List<Habitacion> listaHabitaciones;
	private List<Habitacion> listaHabitacionesSeleccionadas;
	private List<Actividad> listaActividades;
	private List<Actividad> listaActividadesSeleccionadas;
	private List<HabitacionDetalle> listaHabitacionDetalle;
	private List<ClienteActividad> listaClienteActividad;

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
		clienteReservacion = "";
		reservacion.setResAbono(ZERO);
		listaHabitacionesSeleccionadas = new ArrayList<Habitacion>();
		listaHabitacionDetalle = new ArrayList<HabitacionDetalle>();
		listaClienteActividad = new ArrayList<ClienteActividad>();
	}

	public void obtenerReservacionesPorHotel() {
		listaReservacion = reservacionService.obtenerTodosPorHotel(codigoHotel.toString());
	}

	public void cargarClienteReservacion() {
		reservacion.setCliente(clienteService.cargarCliente(clienteReservacion));
	}

	public List<String> obtenerClienteReservacionPorBusqueda(String criterioClienteBusqueda) {
		List<String> lista = clienteService.obtenerListaClientesAutoComplete(criterioClienteBusqueda);
		if (lista.size() == 1) {
			clienteReservacion = (lista.get(0));
			cargarClienteReservacion();
		}
		return lista;
	}

	public void obtenerHabitacionesYActividadesPorHotel() {
		listaHabitaciones = habitacionService.obtenerTodosPorHotel(codigoHotel.toString(), true);
		listaActividades = actividadService.obtenerActividadesPorHotel(codigoHotel);
	}

	public void cargarEditar(Suplemento suplemento) {
		// obtenerHabitacionesYActividadesPorHotel();
		// setListaHabitacionesSeleccionadas(habitacionService.obtenerPorSuplemento(suplemento.getSupCodigo()));
		// setListaActividadesSeleccionadas(actividadService.obtenerPorSuplemento(suplemento.getSupCodigo()));
	}

	public void insertar(ActionEvent actionEvent) {
		if (codigoHotel == 0)
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe escojer un hotel");
		else if (clienteReservacion.isEmpty())
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar un cliente");
		else if (reservacion.getResFechaReserva() == null)
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar la fecha de reservacion");
		else if (reservacion.getResFechaIngreso() == null)
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar la fecha de ingreso");
		else if (reservacion.getResFechaSalido() == null)
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar la fecha de salida");
		else if (listaHabitacionesSeleccionadas.isEmpty())
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe escojer al menos una Habitacion");
		else {
			Hotel hotel = hotelService.obtenerPorCodigo(codigoHotel.toString());
			Usuario usuario = usuarioService
					.obtenerUsuarioPorNick(SecurityContextHolder.getContext().getAuthentication().getName());
			reservacion.setUsuario(usuario);
			reservacion.setResInstancia(false);
			reservacion.setResCancelada(false);
			reservacionService.insertar(reservacion);

			if (!listaHabitacionesSeleccionadas.isEmpty()) {
				for (Habitacion habitacionSeleccionada : listaHabitacionesSeleccionadas) {
					listaHabitacionDetalle.add(new HabitacionDetalle(habitacionSeleccionada.getHabPrecioReferencial(),
							habitacionSeleccionada, reservacion));
				}
				habitacionDetalleService.insertar(listaHabitacionDetalle);
			} else {
				presentaMensaje(FacesMessage.SEVERITY_INFO, "Debe escojer al menos una Habitacion");
			}
			if (!listaActividadesSeleccionadas.isEmpty()) {
				for (Actividad actividadSeleccionada : listaActividadesSeleccionadas) {
					System.out.println("objeto " + actividadSeleccionada);
					if (actividadSeleccionada.getActNumeroPersonas() == null)
						presentaMensaje(FacesMessage.SEVERITY_INFO, "Debe ingresar el numero de personas");
					else
						listaClienteActividad.add(new ClienteActividad(actividadSeleccionada.getActNumeroPersonas(),
								actividadSeleccionada.getActValor(), actividadSeleccionada, reservacion));
				}
				clienteActividadService.insertar(listaClienteActividad);
			}
			presentaMensaje(FacesMessage.SEVERITY_INFO,
					"Se creo la Reservacion con codigo: " + reservacion.getResCodigo() + " en el Hotel: "
							+ hotel.getHotNombre() + " para el cliente " + reservacion.getCliente().getCliApellido()
							+ " " + reservacion.getCliente().getCliNombre(),
					"cerrar", true);
			obtenerReservacionesPorHotel();
			codigoHotel = hotel.getHotCodigo();
		}

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

	public String getClienteReservacion() {
		return clienteReservacion;
	}

	public void setClienteReservacion(String clienteReservacion) {
		this.clienteReservacion = clienteReservacion;
	}

	public List<Habitacion> getListaHabitaciones() {
		return listaHabitaciones;
	}

	public void setListaHabitaciones(List<Habitacion> listaHabitaciones) {
		this.listaHabitaciones = listaHabitaciones;
	}

	public List<Habitacion> getListaHabitacionesSeleccionadas() {
		return listaHabitacionesSeleccionadas;
	}

	public void setListaHabitacionesSeleccionadas(List<Habitacion> listaHabitacionesSeleccionadas) {
		this.listaHabitacionesSeleccionadas = listaHabitacionesSeleccionadas;
	}

	public List<Actividad> getListaActividades() {
		return listaActividades;
	}

	public void setListaActividades(List<Actividad> listaActividades) {
		this.listaActividades = listaActividades;
	}

	public List<Actividad> getListaActividadesSeleccionadas() {
		return listaActividadesSeleccionadas;
	}

	public void setListaActividadesSeleccionadas(List<Actividad> listaActividadesSeleccionadas) {
		this.listaActividadesSeleccionadas = listaActividadesSeleccionadas;
	}

	public List<ClienteActividad> getListaClienteActividad() {
		return listaClienteActividad;
	}

	public void setListaClienteActividad(List<ClienteActividad> listaClienteActividad) {
		this.listaClienteActividad = listaClienteActividad;
	}

}
