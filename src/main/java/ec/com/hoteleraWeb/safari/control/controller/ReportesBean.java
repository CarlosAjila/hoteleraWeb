package ec.com.hoteleraWeb.safari.control.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LegendPlacement;
import org.primefaces.model.chart.LineChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ec.com.hoteleraWeb.safari.control.entityAux.HotelReservacionTO;
import ec.com.hoteleraWeb.safari.control.service.ReportesService;

@Controller
@Scope("session")
public class ReportesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	ReportesService reportesService;

	private LineChartModel modeloLineaHotelReservacion;
	private BarChartModel modeloBarraHotelReservacionCostos;
	private List<HotelReservacionTO> listaHotelReservacionTO;

	private final BigDecimal ZERO = new BigDecimal("0.00");

	@PostConstruct
	public void init() {
		listaHotelReservacionTO = new ArrayList<HotelReservacionTO>();
		listaHotelReservacionTO = reportesService.obtenerCantidadReservasPorHotel();
		crearGraficoLinealHotelReservacionCantidad();
		crearGraficoLinealHotelReservacionCostos();
	}

	public void crearGraficoLinealHotelReservacionCantidad() {

		modeloLineaHotelReservacion = initCategoryModel();
		modeloLineaHotelReservacion.setTitle("Gafica Lineal");
		modeloLineaHotelReservacion.setAnimate(true);
		modeloLineaHotelReservacion.setLegendPosition("s");
		modeloLineaHotelReservacion.setLegendPlacement(LegendPlacement.OUTSIDEGRID);
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
		hoteReservacion.setLabel("Hotel Reservacion");

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
		modeloBarraHotelReservacionCostos.setTitle("Gafica Lineal");
		modeloBarraHotelReservacionCostos.setAnimate(true);
		modeloBarraHotelReservacionCostos.setLegendPosition("s");
		modeloBarraHotelReservacionCostos.setLegendPlacement(LegendPlacement.OUTSIDEGRID);
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
		hoteReservacion.setLabel("Hotel Reservacion");

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

}
