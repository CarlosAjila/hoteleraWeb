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
@Table(name = "cliente_actividad")
public class ClienteActividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "cliente_actividad_cli_act_id_seq", sequenceName = "cliente_actividad_cli_act_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_actividad_cli_act_id_seq")
	@Column(name = "cli_act_id")
	private Integer cliActId;

	@Column(name = "num_persona")
	private Integer numPersona;

	// bi-directional many-to-one association to Actividad
	@ManyToOne
	@JoinColumn(name = "act_codigo")
	private Actividad actividad;

	// bi-directional many-to-one association to Reservacion
	@ManyToOne
	@JoinColumn(name = "res_codigo")
	private Reservacion reservacion;

	public ClienteActividad() {
	}

	public Integer getCliActId() {
		return this.cliActId;
	}

	public void setCliActId(Integer cliActId) {
		this.cliActId = cliActId;
	}

	public Integer getNumPersona() {
		return this.numPersona;
	}

	public void setNumPersona(Integer numPersona) {
		this.numPersona = numPersona;
	}

	public Actividad getActividad() {
		return this.actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Reservacion getReservacion() {
		return this.reservacion;
	}

	public void setReservacion(Reservacion reservacion) {
		this.reservacion = reservacion;
	}

}