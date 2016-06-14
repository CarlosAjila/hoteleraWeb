package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "habitaciones")
public class Habitacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "habitaciones_hab_codigo_seq", sequenceName = "habitaciones_hab_codigo_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "habitaciones_hab_codigo_seq")
	@Column(name = "hab_codigo")
	private Integer habCodigo;

	@Column(name = "hab_descripcion")
	private String habDescripcion;

	@Column(name = "hab_disponible")
	private Boolean habDisponible;

	@Column(name = "hab_precio_referencial")
	private BigDecimal habPrecioReferencial;

	@Column(name = "hab_tipo")
	private String habTipo;

	@Column(name = "hot_codigo")
	private Integer hotCodigo;

	public Habitacione() {
	}

	public Integer getHabCodigo() {
		return this.habCodigo;
	}

	public void setHabCodigo(Integer habCodigo) {
		this.habCodigo = habCodigo;
	}

	public String getHabDescripcion() {
		return this.habDescripcion;
	}

	public void setHabDescripcion(String habDescripcion) {
		this.habDescripcion = habDescripcion;
	}

	public Boolean getHabDisponible() {
		return this.habDisponible;
	}

	public void setHabDisponible(Boolean habDisponible) {
		this.habDisponible = habDisponible;
	}

	public BigDecimal getHabPrecioReferencial() {
		return this.habPrecioReferencial;
	}

	public void setHabPrecioReferencial(BigDecimal habPrecioReferencial) {
		this.habPrecioReferencial = habPrecioReferencial;
	}

	public String getHabTipo() {
		return this.habTipo;
	}

	public void setHabTipo(String habTipo) {
		this.habTipo = habTipo;
	}

	public Integer getHotCodigo() {
		return this.hotCodigo;
	}

	public void setHotCodigo(Integer hotCodigo) {
		this.hotCodigo = hotCodigo;
	}

}