package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the calendario database table.
 * 
 */
@Entity
@NamedQuery(name="Calendario.findAll", query="SELECT c FROM Calendario c")
public class Calendario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cal_codigo")
	private Integer calCodigo;

	@Column(name="act_codigo")
	private Integer actCodigo;

	@Column(name="cal_dia")
	private String calDia;

	@Column(name="cal_hora_fin")
	private Long calHoraFin;

	@Column(name="cal_hora_inicio")
	private String calHoraInicio;

	public Calendario() {
	}

	public Integer getCalCodigo() {
		return this.calCodigo;
	}

	public void setCalCodigo(Integer calCodigo) {
		this.calCodigo = calCodigo;
	}

	public Integer getActCodigo() {
		return this.actCodigo;
	}

	public void setActCodigo(Integer actCodigo) {
		this.actCodigo = actCodigo;
	}

	public String getCalDia() {
		return this.calDia;
	}

	public void setCalDia(String calDia) {
		this.calDia = calDia;
	}

	public Long getCalHoraFin() {
		return this.calHoraFin;
	}

	public void setCalHoraFin(Long calHoraFin) {
		this.calHoraFin = calHoraFin;
	}

	public String getCalHoraInicio() {
		return this.calHoraInicio;
	}

	public void setCalHoraInicio(String calHoraInicio) {
		this.calHoraInicio = calHoraInicio;
	}

}