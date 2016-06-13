package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fac_codigo")
	private Integer facCodigo;

	@Column(name="fac_anulada")
	private Boolean facAnulada;

	@Temporal(TemporalType.DATE)
	@Column(name="fac_fecha")
	private Date facFecha;

	@Column(name="fac_iva_vigente")
	private BigDecimal facIvaVigente;

	@Column(name="fac_montoiva")
	private BigDecimal facMontoiva;

	@Column(name="fac_numero")
	private String facNumero;

	@Column(name="fac_sub_total_base_imponible")
	private BigDecimal facSubTotalBaseImponible;

	@Column(name="fac_sub_total_base0")
	private BigDecimal facSubTotalBase0;

	@Column(name="fac_total")
	private BigDecimal facTotal;

	@Column(name="fac_total_actividad")
	private Long facTotalActividad;

	@Column(name="fac_total_habitaciones")
	private BigDecimal facTotalHabitaciones;

	@Column(name="fac_total_suplemento")
	private BigDecimal facTotalSuplemento;

	@Column(name="fac_total_suplemento_temporada")
	private Long facTotalSuplementoTemporada;

	@Column(name="res_codigo")
	private Integer resCodigo;

	public Factura() {
	}

	public Integer getFacCodigo() {
		return this.facCodigo;
	}

	public void setFacCodigo(Integer facCodigo) {
		this.facCodigo = facCodigo;
	}

	public Boolean getFacAnulada() {
		return this.facAnulada;
	}

	public void setFacAnulada(Boolean facAnulada) {
		this.facAnulada = facAnulada;
	}

	public Date getFacFecha() {
		return this.facFecha;
	}

	public void setFacFecha(Date facFecha) {
		this.facFecha = facFecha;
	}

	public BigDecimal getFacIvaVigente() {
		return this.facIvaVigente;
	}

	public void setFacIvaVigente(BigDecimal facIvaVigente) {
		this.facIvaVigente = facIvaVigente;
	}

	public BigDecimal getFacMontoiva() {
		return this.facMontoiva;
	}

	public void setFacMontoiva(BigDecimal facMontoiva) {
		this.facMontoiva = facMontoiva;
	}

	public String getFacNumero() {
		return this.facNumero;
	}

	public void setFacNumero(String facNumero) {
		this.facNumero = facNumero;
	}

	public BigDecimal getFacSubTotalBaseImponible() {
		return this.facSubTotalBaseImponible;
	}

	public void setFacSubTotalBaseImponible(BigDecimal facSubTotalBaseImponible) {
		this.facSubTotalBaseImponible = facSubTotalBaseImponible;
	}

	public BigDecimal getFacSubTotalBase0() {
		return this.facSubTotalBase0;
	}

	public void setFacSubTotalBase0(BigDecimal facSubTotalBase0) {
		this.facSubTotalBase0 = facSubTotalBase0;
	}

	public BigDecimal getFacTotal() {
		return this.facTotal;
	}

	public void setFacTotal(BigDecimal facTotal) {
		this.facTotal = facTotal;
	}

	public Long getFacTotalActividad() {
		return this.facTotalActividad;
	}

	public void setFacTotalActividad(Long facTotalActividad) {
		this.facTotalActividad = facTotalActividad;
	}

	public BigDecimal getFacTotalHabitaciones() {
		return this.facTotalHabitaciones;
	}

	public void setFacTotalHabitaciones(BigDecimal facTotalHabitaciones) {
		this.facTotalHabitaciones = facTotalHabitaciones;
	}

	public BigDecimal getFacTotalSuplemento() {
		return this.facTotalSuplemento;
	}

	public void setFacTotalSuplemento(BigDecimal facTotalSuplemento) {
		this.facTotalSuplemento = facTotalSuplemento;
	}

	public Long getFacTotalSuplementoTemporada() {
		return this.facTotalSuplementoTemporada;
	}

	public void setFacTotalSuplementoTemporada(Long facTotalSuplementoTemporada) {
		this.facTotalSuplementoTemporada = facTotalSuplementoTemporada;
	}

	public Integer getResCodigo() {
		return this.resCodigo;
	}

	public void setResCodigo(Integer resCodigo) {
		this.resCodigo = resCodigo;
	}

}