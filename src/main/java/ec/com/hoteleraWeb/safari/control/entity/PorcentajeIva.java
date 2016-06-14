package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "porcentaje_iva")
public class PorcentajeIva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "porcentaje_iva_pi_codigo_seq", sequenceName = "porcentaje_iva_pi_codigo_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "porcentaje_iva_pi_codigo_seq")
	@Column(name = "pi_codigo")
	private Integer piCodigo;

	@Temporal(TemporalType.DATE)
	@Column(name = "pi_fecha_desde")
	private Date piFechaDesde;

	@Temporal(TemporalType.DATE)
	@Column(name = "pi_fecha_hasta")
	private Date piFechaHasta;

	@Column(name = "pi_porcentaje")
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