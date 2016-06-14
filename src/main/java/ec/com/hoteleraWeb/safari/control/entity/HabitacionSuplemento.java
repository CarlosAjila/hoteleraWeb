package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Column(name = "hab_codigo")
	private Integer habCodigo;

	@Column(name = "sup_codigo")
	private Integer supCodigo;

	public HabitacionSuplemento() {
	}

	public Integer getHabSupId() {
		return this.habSupId;
	}

	public void setHabSupId(Integer habSupId) {
		this.habSupId = habSupId;
	}

	public Integer getHabCodigo() {
		return this.habCodigo;
	}

	public void setHabCodigo(Integer habCodigo) {
		this.habCodigo = habCodigo;
	}

	public Integer getSupCodigo() {
		return this.supCodigo;
	}

	public void setSupCodigo(Integer supCodigo) {
		this.supCodigo = supCodigo;
	}

}