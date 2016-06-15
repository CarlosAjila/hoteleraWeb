package ec.com.hoteleraWeb.safari.seguridad.entity;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "bitacora")
public class Bitacora implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(allocationSize = 1, name = "bitacora_bit_cod_seq", sequenceName = "bitacora_bit_cod_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bitacora_bit_cod_seq")
	@Column(name = "bit_cod")
	private Integer bitCod;

	@Column(name = "bit_empleado")
	private String bitEmpleado;

	@Column(name = "bit_fecha")
	private Time bitFecha;

	@Column(name = "bit_metodo")
	private String bitMetodo;

	public Bitacora() {
	}

	public Integer getBitCod() {
		return this.bitCod;
	}

	public void setBitCod(Integer bitCod) {
		this.bitCod = bitCod;
	}

	public String getBitEmpleado() {
		return this.bitEmpleado;
	}

	public void setBitEmpleado(String bitEmpleado) {
		this.bitEmpleado = bitEmpleado;
	}

	public Time getBitFecha() {
		return this.bitFecha;
	}

	public void setBitFecha(Time bitFecha) {
		this.bitFecha = bitFecha;
	}

	public String getBitMetodo() {
		return this.bitMetodo;
	}

	public void setBitMetodo(String bitMetodo) {
		this.bitMetodo = bitMetodo;
	}

}