package ec.com.hoteleraWeb.safari.control.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import ec.com.hoteleraWeb.safari.control.entity.Hotel;
import ec.com.hoteleraWeb.safari.control.entityAux.HotelReservacionTO;
import ec.com.hoteleraWeb.safari.control.entityAux.ReporteClienteReservacionTO;
import ec.com.hoteleraWeb.safari.control.service.HotelService;
import ec.com.hoteleraWeb.safari.control.service.ReportesService;
import ec.com.hoteleraWeb.safari.utils.service.ReporteService;

@Controller
@Scope("session")
public class ReportesreservacionesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Hotel> listaHoteles;
	private List<ReporteClienteReservacionTO> listaClienteReservacion;

	@Autowired
	private HotelService hotelService;
	@Autowired
	ReportesService reportesService;
	@Autowired
	private ReporteService reporteService;

	private Integer codigoHotel;

	private LineChartModel modeloLineaHotelReservacion;
	private BarChartModel modeloBarraHotelReservacionCostos;
	private List<HotelReservacionTO> listaHotelReservacionTO;

	private final BigDecimal ZERO = new BigDecimal("0.00");

	@PostConstruct
	public void init() {
		System.out.println("lllllllllllllllllllllllllllll");
		listaHoteles = new ArrayList<Hotel>();

		obtenerHoteles();

		// listaHotelReservacionTO = new ArrayList<HotelReservacionTO>();
		// listaHotelReservacionTO =
		// reportesService.obtenerCantidadReservasPorHotel();
		// crearGraficoLinealHotelReservacionCantidad();
		// crearGraficoLinealHotelReservacionCostos();
	}

	public void obtenerClienteReservacionesCanceladas() {
		listaClienteReservacion = new ArrayList<ReporteClienteReservacionTO>();
		listaClienteReservacion = reportesService.obtenerClienteReservacionCanceladas(codigoHotel);
		for (ReporteClienteReservacionTO reporteClienteReservacionTO : listaClienteReservacion) {
			System.out.println("id :  " + reporteClienteReservacionTO.getId());
			System.out.println("nombre :  " + reporteClienteReservacionTO.getCliNombre());
			System.out.println("cedula :  " + reporteClienteReservacionTO.getCliCedula());

		}
	}

	public void obtenerClienteReservacionesefectuadas() {
		listaClienteReservacion = new ArrayList<ReporteClienteReservacionTO>();
		listaClienteReservacion = reportesService.obtenerClienteReservacionEfectuadas(codigoHotel);
		for (ReporteClienteReservacionTO reporteClienteReservacionTO : listaClienteReservacion) {
			System.out.println("id :  " + reporteClienteReservacionTO.getId());
			System.out.println("nombre :  " + reporteClienteReservacionTO.getCliNombre());
			System.out.println("cedula :  " + reporteClienteReservacionTO.getCliCedula());

		}
	}

	public void obtenerHoteles() {
		listaHoteles = hotelService
				.obtenerTodosPorUsuario(SecurityContextHolder.getContext().getAuthentication().getName());

	}

	public void imprimirReservacionesCanceladas() {
		System.out.println("imprimirReservacionesCanceladas");
		reporteService.generarReportePDF(listaClienteReservacion, new HashMap<String, Object>(),
				"ClienteReservacionCanceladas", "clienteReservacionCanceladas " + listaHoteles.get(0).getHotRuc());
	}

	public void imprimirReservacionesEfectuadas() {
		System.out.println("imprimirReservacionesEfectuadas");
		reporteService.generarReportePDF(listaClienteReservacion, new HashMap<String, Object>(),
				"ClienteReservacionEfectuadas", "clienteReservacionEfectuadas " + listaHoteles.get(0).getHotRuc());
	}

	public void crearGraficoLinealHotelReservacionCantidad() {
		modeloLineaHotelReservacion = initCategoryModel();
		modeloLineaHotelReservacion.setTitle("Total Reservaciones Por Hotel");
		modeloLineaHotelReservacion.setAnimate(true);
		Axis yAxis = modeloLineaHotelReservacion.getAxis(AxisType.Y);
		// modeloLineaLibraFecha.setShowPointLabels(true);
		modeloLineaHotelReservacion.getAxes().put(AxisType.X, new CategoryAxis("Hoteles"));
		yAxis = modeloLineaHotelReservacion.getAxis(AxisType.Y);
		yAxis.setLabel("Reservaciones");
		yAxis.setMin(0);
		yAxis.setMax(ObtenerNumeroMayorEjeY());
		modeloLineaHotelReservacion.setZoom(true);
	}

	private LineChartModel initCategoryModel() {
		LineChartModel model = new LineChartModel();

		ChartSeries hoteReservacion = new ChartSeries();

		for (HotelReservacionTO hr : listaHotelReservacionTO) {
			hoteReservacion.set(hr.getNombreHotel(), hr.getCantidadReservacion());
		}

		model.addSeries(hoteReservacion);
		return model;
	}

	public int ObtenerNumeroMayorEjeY() {
		Integer numeroMayor = 0;
		for (HotelReservacionTO hr : listaHotelReservacionTO) {
			if (hr.getCantidadReservacion() != 0) {
				numeroMayor = hr.getCantidadReservacion() * 10;
			}
		}
		return numeroMayor;
	}

	public void crearGraficoLinealHotelReservacionCostos() {

		modeloBarraHotelReservacionCostos = initCategoryModelBarras();
		modeloBarraHotelReservacionCostos.setTitle("Total Ventas Por Hotel");
		modeloBarraHotelReservacionCostos.setAnimate(true);
		Axis yAxis = modeloBarraHotelReservacionCostos.getAxis(AxisType.Y);
		// modeloLineaLibraFecha.setShowPointLabels(true);
		modeloBarraHotelReservacionCostos.getAxes().put(AxisType.X, new CategoryAxis("Hoteles"));
		yAxis = modeloBarraHotelReservacionCostos.getAxis(AxisType.Y);
		yAxis.setLabel("Reservaciones");
		yAxis.setMin(0);
		yAxis.setMax(ObtenerNumeroMayorEjeY());
		modeloBarraHotelReservacionCostos.setZoom(true);
	}

	private BarChartModel initCategoryModelBarras() {
		BarChartModel model = new BarChartModel();

		ChartSeries hoteReservacion = new ChartSeries();

		for (HotelReservacionTO hr : listaHotelReservacionTO) {
			hoteReservacion.set(hr.getNombreHotel(), hr.getCantidadReservacion());
		}

		model.addSeries(hoteReservacion);
		return model;
	}

	public int ObtenerNumeroMayorEjeYBarras() {
		Integer numeroMayor = 0;
		for (HotelReservacionTO hr : listaHotelReservacionTO) {
			if (hr.getCantidadReservacion() != 0) {
				numeroMayor = hr.getCantidadReservacion() * 10;
			}
		}
		return numeroMayor;
	}

	public List<HotelReservacionTO> getListaHotelReservacionTO() {
		return listaHotelReservacionTO;
	}

	public void setListaHotelReservacionTO(List<HotelReservacionTO> listaHotelReservacionTO) {
		this.listaHotelReservacionTO = listaHotelReservacionTO;
	}

	public LineChartModel getModeloLineaHotelReservacion() {
		return modeloLineaHotelReservacion;
	}

	public void setModeloLineaHotelReservacion(LineChartModel modeloLineaHotelReservacion) {
		this.modeloLineaHotelReservacion = modeloLineaHotelReservacion;
	}

	public BarChartModel getModeloBarraHotelReservacionCostos() {
		return modeloBarraHotelReservacionCostos;
	}

	public void setModeloBarraHotelReservacionCostos(BarChartModel modeloBarraHotelReservacionCostos) {
		this.modeloBarraHotelReservacionCostos = modeloBarraHotelReservacionCostos;
	}

	public List<Hotel> getListaHoteles() {
		return listaHoteles;
	}

	public void setListaHoteles(List<Hotel> listaHoteles) {
		this.listaHoteles = listaHoteles;
	}

	public HotelService getHotelService() {
		return hotelService;
	}

	public void setHotelService(HotelService hotelService) {
		this.hotelService = hotelService;
	}

	public Integer getCodigoHotel() {
		return codigoHotel;
	}

	public void setCodigoHotel(Integer codigoHotel) {
		this.codigoHotel = codigoHotel;
	}

	public List<ReporteClienteReservacionTO> getListaClienteReservacion() {
		return listaClienteReservacion;
	}

	public void setListaClienteReservacion(List<ReporteClienteReservacionTO> listaClienteReservacion) {
		this.listaClienteReservacion = listaClienteReservacion;
	}

}
