package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;

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
	private Habitacion habitacione;

	// bi-directional many-to-one association to Suplemento
	@ManyToOne
	@JoinColumn(name = "sup_codigo")
	private Suplemento suplemento;

	public HabitacionSuplemento() {
	}

	public Integer getHabSupId() {
		return this.habSupId;
	}

	public void setHabSupId(Integer habSupId) {
		this.habSupId = habSupId;
	}

	public Habitacion getHabitacione() {
		return this.habitacione;
	}

	public void setHabitacione(Habitacion habitacione) {
		this.habitacione = habitacione;
	}

	public Suplemento getSuplemento() {
		return this.suplemento;
	}

	public void setSuplemento(Suplemento suplemento) {
		this.suplemento = suplemento;
	}

}