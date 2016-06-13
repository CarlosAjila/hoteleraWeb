package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the suplemento database table.
 * 
 */
@Entity
@NamedQuery(name="Suplemento.findAll", query="SELECT s FROM Suplemento s")
public class Suplemento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sup_codigo")
	private Integer supCodigo;

	@Column(name="sup_activo")
	private Boolean supActivo;

	@Column(name="sup_detalle")
	private String supDetalle;

	@Column(name="sup_temporada")
	private Boolean supTemporada;

	@Column(name="sup_valor")
	private BigDecimal supValor;

	public Suplemento() {
	}

	public Integer getSupCodigo() {
		return this.supCodigo;
	}

	public void setSupCodigo(Integer supCodigo) {
		this.supCodigo = supCodigo;
	}

	public Boolean getSupActivo() {
		return this.supActivo;
	}

	public void setSupActivo(Boolean supActivo) {
		this.supActivo = supActivo;
	}

	public String getSupDetalle() {
		return this.supDetalle;
	}

	public void setSupDetalle(String supDetalle) {
		this.supDetalle = supDetalle;
	}

	public Boolean getSupTemporada() {
		return this.supTemporada;
	}

	public void setSupTemporada(Boolean supTemporada) {
		this.supTemporada = supTemporada;
	}

	public BigDecimal getSupValor() {
		return this.supValor;
	}

	public void setSupValor(BigDecimal supValor) {
		this.supValor = supValor;
	}

}