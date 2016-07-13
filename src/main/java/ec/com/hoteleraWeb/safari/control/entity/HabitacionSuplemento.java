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
@Table(name = "habitacion_suplemento")
public class HabitacionSuplemento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "habitacion_suplemento_hab_sup_id_seq", sequenceName = "habitacion_suplemento_hab_sup_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "habitacion_suplemento_hab_sup_id_seq")
	@Column(name = "hab_sup_id")
	private Integer habSupId;

	@ManyToOne
	@JoinColumn(name = "hab_codigo")
	private Habitacion habitacion;

	@Column(name = "sup_hab_valor")
	private BigDecimal valor;

	// bi-directional many-to-one association to Suplemento
	@ManyToOne
	@JoinColumn(name = "sup_codigo")
	private Suplemento suplemento;

	public HabitacionSuplemento() {
	}

	public HabitacionSuplemento(Habitacion habitacion, Suplemento suplemento, BigDecimal valor) {
		this.habitacion = habitacion;
		this.suplemento = suplemento;
		this.valor = valor;
	}

	public Integer getHabSupId() {
		return this.habSupId;
	}

	public void setHabSupId(Integer habSupId) {
		this.habSupId = habSupId;
	}

	public Habitacion getHabitacion() {
		return this.habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Suplemento getSuplemento() {
		return this.suplemento;
	}

	public void setSuplemento(Suplemento suplemento) {
		this.suplemento = suplemento;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}