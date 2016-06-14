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
@Table(name = "calendario")
public class Calendario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "calendario_cal_codigo_seq", sequenceName = "calendario_cal_codigo_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calendario_cal_codigo_seq")
	@Column(name = "cal_codigo")
	private Integer calCodigo;

	@Column(name = "act_codigo")
	private Integer actCodigo;

	@Column(name = "cal_dia")
	private String calDia;

	@Column(name = "cal_hora_fin")
	private Long calHoraFin;

	@Column(name = "cal_hora_inicio")
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