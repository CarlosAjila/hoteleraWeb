package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@Column(name = "hab_det_valor")
	private BigDecimal habDetValor;

	// bi-directional many-to-one association to Habitacione
	@ManyToOne
	@JoinColumn(name = "hab_codigo")
	private Habitacion habitacion;

	// bi-directional many-to-one association to Reservacion
	@ManyToOne
	@JoinColumn(name = "res_codigo")
	private Reservacion reservacion;

	public HabitacionDetalle() {
	}

	public Integer getHabDetId() {
		return this.habDetId;
	}

	public void setHabDetId(Integer habDetId) {
		this.habDetId = habDetId;
	}

	public BigDecimal getHabDetValor() {
		return this.habDetValor;
	}

	public void setHabDetValor(BigDecimal habDetValor) {
		this.habDetValor = habDetValor;
	}

	public Habitacion getHabitacione() {
		return this.habitacion;
	}

	public void setHabitacione(Habitacion habitacione) {
		this.habitacion = habitacione;
	}

	public Reservacion getReservacion() {
		return this.reservacion;
	}

	public void setReservacion(Reservacion reservacion) {
		this.reservacion = reservacion;
	}

}