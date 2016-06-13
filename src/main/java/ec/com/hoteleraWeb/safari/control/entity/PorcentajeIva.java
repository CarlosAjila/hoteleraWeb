package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the porcentaje_iva database table.
 * 
 */
@Entity
@Table(name="porcentaje_iva")
@NamedQuery(name="PorcentajeIva.findAll", query="SELECT p FROM PorcentajeIva p")
public class PorcentajeIva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pi_codigo")
	private Integer piCodigo;

	@Temporal(TemporalType.DATE)
	@Column(name="pi_fecha_desde")
	private Date piFechaDesde;

	@Temporal(TemporalType.DATE)
	@Column(name="pi_fecha_hasta")
	private Date piFechaHasta;

	@Column(name="pi_porcentaje")
	private BigDecimal piPorcentaje;

	public PorcentajeIva() {
	}

	public Integer getPiCodigo() {
		return this.piCodigo;
	}

	public void setPiCodigo(Integer piCodigo) {
		this.piCodigo = piCodigo;
	}

	public Date getPiFechaDesde() {
		return this.piFechaDesde;
	}

	public void setPiFechaDesde(Date piFechaDesde) {
		this.piFechaDesde = piFechaDesde;
	}

	public Date getPiFechaHasta() {
		return this.piFechaHasta;
	}

	public void setPiFechaHasta(Date piFechaHasta) {
		this.piFechaHasta = piFechaHasta;
	}

	public BigDecimal getPiPorcentaje() {
		return this.piPorcentaje;
	}

	public void setPiPorcentaje(BigDecimal piPorcentaje) {
		this.piPorcentaje = piPorcentaje;
	}

}