package ec.com.hoteleraWeb.safari.control.controller;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LegendPlacement;
import org.primefaces.model.chart.LineChartModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("session")
public class ReportesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private LineChartModel modeloLineaLibraFecha;

	@PostConstruct
	public void init() {
		crearGraficoLinealTallaFecha();
	}

	public void crearGraficoLinealTallaFecha() {

		modeloLineaLibraFecha = initCategoryModel();
		modeloLineaLibraFecha.setTitle("Gafica Lineal");
		modeloLineaLibraFecha.setAnimate(true);
		modeloLineaLibraFecha.setLegendPosition("s");
		modeloLineaLibraFecha.setLegendPlacement(LegendPlacement.OUTSIDEGRID);
		Axis yAxis = modeloLineaLibraFecha.getAxis(AxisType.Y);
		// modeloLineaLibraFecha.setShowPointLabels(true);
		modeloLineaLibraFecha.getAxes().put(AxisType.X, new CategoryAxis("Fecha"));
		yAxis = modeloLineaLibraFecha.getAxis(AxisType.Y);
		yAxis.setLabel("Libras");
		yAxis.setMin(0);
		yAxis.setMax(ObtenerNumeroMayorEjeY() * 1.1);
		modeloLineaLibraFecha.setZoom(true);

		DateAxis axis = new DateAxis("Fechas");
		axis.setTickAngle(-50);
		// axis.setMax("2014-02-01");
		axis.setTickFormat("%b %#d, %y");
		modeloLineaLibraFecha.getAxes().put(AxisType.X, axis);
	}

	private LineChartModel initCategoryModel() {
		LineChartModel model = new LineChartModel();

		ChartSeries balanceado = new ChartSeries();
		ChartSeries biomasa = new ChartSeries();
		balanceado.setLabel("Balanceado");
		biomasa.setLabel("Biomasa");

		for (ListadoGrameaje g : listaGrameajes) {
			balanceado.set(g.getGraFecha().toString(), g.getGraBalanciadoAcumulado());
			biomasa.set(g.getGraFecha().toString(), g.getGraBiomasa());
		}

		model.addSeries(balanceado);
		model.addSeries(biomasa);

		return model;
	}

	public int ObtenerNumeroMayorEjeY() {
		BigDecimal numeroMayor = ZERO;
		for (ListadoGrameaje g : listaGrameajes) {
			if (g.getGraBalanciadoAcumulado().compareTo(numeroMayor) == 1) {
				numeroMayor = g.getGraBalanciadoAcumulado();
			}
		}
		for (ListadoGrameaje g : listaGrameajes) {
			if (g.getGraBiomasa().compareTo(numeroMayor) == 1) {
				numeroMayor = g.getGraBiomasa();
			}
		}
		return numeroMayor.intValue();
	}

}
