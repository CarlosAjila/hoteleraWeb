package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "habitacion_detalle")
public class HabitacionDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "habitacion_detalle_hab_det_id_seq", sequenceName = "habitacion_detalle_hab_det_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "habitacion_detalle_hab_det_id_seq")
	@Column(name = "hab_det_id")
	private Integer habDetId;

	@Column(name = "hab_codigo")
	private Integer habCodigo;

	@Column(name = "hab_det_valor")
	private BigDecimal habDetValor;

	@Column(name = "res_codigo")
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