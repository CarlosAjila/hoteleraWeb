package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the habitacion_detalle database table.
 * 
 */
@Entity
@Table(name="habitacion_detalle")
@NamedQuery(name="HabitacionDetalle.findAll", query="SELECT h FROM HabitacionDetalle h")
public class HabitacionDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="hab_det_id")
	private Integer habDetId;

	@Column(name="hab_codigo")
	private Integer habCodigo;

	@Column(name="hab_det_valor")
	private BigDecimal habDetValor;

	@Column(name="res_codigo")
	private Integer resCodigo;

	public HabitacionDetalle() {
	}

	public Integer getHabDetId() {
		return this.habDetId;
	}

	public void setHabDetId(Integer habDetId) {
		this.habDetId = habDetId;
	}

	public Integer getHabCodigo() {
		return this.habCodigo;
	}

	public void setHabCodigo(Integer habCodigo) {
		this.habCodigo = habCodigo;
	}

	public BigDecimal getHabDetValor() {
		return this.habDetValor;
	}

	public void setHabDetValor(BigDecimal habDetValor) {
		this.habDetValor = habDetValor;
	}

	public Integer getResCodigo() {
		return this.resCodigo;
	}

	public void setResCodigo(Integer resCodigo) {
		this.resCodigo = resCodigo;
	}

}