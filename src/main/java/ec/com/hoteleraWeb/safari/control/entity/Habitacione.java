package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the habitaciones database table.
 * 
 */
@Entity
@Table(name="habitaciones")
@NamedQuery(name="Habitacione.findAll", query="SELECT h FROM Habitacione h")
public class Habitacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="hab_codigo")
	private Integer habCodigo;

	@Column(name="hab_descripcion")
	private String habDescripcion;

	@Column(name="hab_disponible")
	private Boolean habDisponible;

	@Column(name="hab_precio_referencial")
	private BigDecimal habPrecioReferencial;

	@Column(name="hab_tipo")
	private String habTipo;

	@Column(name="hot_codigo")
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