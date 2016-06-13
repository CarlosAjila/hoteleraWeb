package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the habitacion_suplemento database table.
 * 
 */
@Entity
@Table(name="habitacion_suplemento")
@NamedQuery(name="HabitacionSuplemento.findAll", query="SELECT h FROM HabitacionSuplemento h")
public class HabitacionSuplemento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="hab_sup_id")
	private Integer habSupId;

	@Column(name="hab_codigo")
	private Integer habCodigo;

	@Column(name="sup_codigo")
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