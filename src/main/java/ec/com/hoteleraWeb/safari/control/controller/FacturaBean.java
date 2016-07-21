package ec.com.hoteleraWeb.safari.control.controller;

import static ec.com.hoteleraWeb.safari.utils.UtilsAplicacion.presentaMensaje;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import ec.com.hoteleraWeb.safari.control.entity.Factura;
import ec.com.hoteleraWeb.safari.control.entity.Hotel;
import ec.com.hoteleraWeb.safari.control.entity.Reservacion;
import ec.com.hoteleraWeb.safari.control.service.FacturaService;
import ec.com.hoteleraWeb.safari.control.service.HotelService;
import ec.com.hoteleraWeb.safari.control.service.ReservacionService;
import ec.com.hoteleraWeb.safari.utils.service.ReporteService;

@Controller
@Scope("session")
public class FacturaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private HotelService hotelService;

	@Autowired
	private FacturaService facturaService;

	@Autowired
	private ReporteService reporteService;

	@Autowired
	private ReservacionService reservacionService;

	private List<Hotel> listaHoteles;
	private List<Factura> listaFacturas;
	private Factura factura;
	private Reservacion reservacion;
	private Integer codigoHotel;
	private final BigDecimal ZERO = new BigDecimal("0.00");

	public FacturaBean() {
	}

	@PostConstruct
	public void init() {
		limpiarObjetos();
		obtenerHoteles();
	}

	public void cargarInsertar() {
		// actividad = new Actividad();
		// empleado.setHotel(new Hotel());
		// actividad.setEmpleado(new Empleado());
		// empleadoActividad = "";
		factura = new Factura();
		obtenerHoteles();

	}

	public void limpiarObjetos() {
		setReservacion(new Reservacion());
		setListaFacturas(new ArrayList<Factura>());
		listaHoteles = new ArrayList<Hotel>();

	}

	public void imprimir(Factura factura) {
		reservacionService.obtenerPorId(factura.getReservacion().getResCodigo());
		List<Factura> listaReporte = new ArrayList<Factura>();
		listaReporte.add(factura);
		reporteService.generarReportePDF(listaReporte, new HashMap<String, Object>(), "Factura",
				"factura" + factura.getFacNumero());
	}

	public void obtenerHoteles() {
		listaHoteles = hotelService
				.obtenerTodosPorUsuario(SecurityContextHolder.getContext().getAuthentication().getName());
	}

	public void obtenerPorHotel() {
		setListaFacturas(facturaService.obtenerPorHotel(codigoHotel));
	}

	public void insertar(ActionEvent actionEvent) {
		facturaService.insertar(factura);
		obtenerPorHotel();
	}

	public void actualizar(ActionEvent actionEvent) {
		if (factura.getFacNumero().isEmpty())
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar un numero de factura");
		else
			facturaService.actualizar(factura);
		obtenerPorHotel();

	}

	public void eliminar(ActionEvent actionEvent) {
		facturaService.eliminar(factura);
	}

	public List<Hotel> getListaHoteles() {
		return listaHoteles;
	}

	public void setListaHoteles(List<Hotel> listaHoteles) {
		this.listaHoteles = listaHoteles;
	}

	public Integer getCodigoHotel() {
		return codigoHotel;
	}

	public void setCodigoHotel(Integer codigoHotel) {
		this.codigoHotel = codigoHotel;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Reservacion getReservacion() {
		return reservacion;
	}

	public void setReservacion(Reservacion reservacion) {
		this.reservacion = reservacion;
	}

	public List<Factura> getListaFacturas() {
		return listaFacturas;
	}

	public void setListaFacturas(List<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}

}
