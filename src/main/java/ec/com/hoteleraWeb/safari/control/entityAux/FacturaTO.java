package ec.com.hoteleraWeb.safari.control.entityAux;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FacturaTO implements Serializable {
	private static final long serialVersionUID = 1L;

	// @Column(name = "id")
	// private Integer id;
	@Id
	@Column(name = "total_suplemento")
	private BigDecimal totalSuplemento;

	@Column(name = "total_suplemento_temporada")
	private BigDecimal totalSuplementoTemporada;

	@Column(name = "total_habitacion")
	private BigDecimal totalHabitacion;

	@Column(name = "total_actividad")
	private BigDecimal totalActividad;

	@Column(name = "subtotal_a_pagar")
	private BigDecimal subtotalPagar;

	@Column(name = "total_abono")
	private BigDecimal totalAbono;

	@Column(name = "total_a_pagar")
	private BigDecimal totalPagar;

	@Column(name = "iva_vigente")
	private BigDecimal ivaVigente;

	@Column(name = "monto_iva")
	private BigDecimal montoIva;

	public FacturaTO() {

	}

	public BigDecimal getTotalSuplemento() {
		return totalSuplemento;
	}

	public void setTotalSuplemento(BigDecimal totalSuplemento) {
		this.totalSuplemento = totalSuplemento;
	}

	public BigDecimal getTotalSuplementoTemporada() {
		return totalSuplementoTemporada;
	}

	public void setTotalSuplementoTemporada(BigDecimal totalSuplementoTemporada) {
		this.totalSuplementoTemporada = totalSuplementoTemporada;
	}

	public BigDecimal getTotalHabitacion() {
		return totalHabitacion;
	}

	public void setTotalHabitacion(BigDecimal totalHabitacion) {
		this.totalHabitacion = totalHabitacion;
	}

	public BigDecimal getTotalActividad() {
		return totalActividad;
	}

	public void setTotalActividad(BigDecimal totalActividad) {
		this.totalActividad = totalActividad;
	}

	public BigDecimal getSubtotalPagar() {
		return subtotalPagar;
	}

	public void setSubtotalPagar(BigDecimal subtotalPagar) {
		this.subtotalPagar = subtotalPagar;
	}

	public BigDecimal getTotalAbono() {
		return totalAbono;
	}

	public void setTotalAbono(BigDecimal totalAbono) {
		this.totalAbono = totalAbono;
	}

	public BigDecimal getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(BigDecimal totalPagar) {
		this.totalPagar = totalPagar;
	}

	public BigDecimal getIvaVigente() {
		return ivaVigente;
	}

	public void setIvaVigente(BigDecimal ivaVigente) {
		this.ivaVigente = ivaVigente;
	}

	public BigDecimal getMontoIva() {
		return montoIva;
	}

	public void setMontoIva(BigDecimal montoIva) {
		this.montoIva = montoIva;
	}

	// public Integer getId() {
	// return id;
	// }
	//
	// public void setId(Integer id) {
	// this.id = id;
	// }

}