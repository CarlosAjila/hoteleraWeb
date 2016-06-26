package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "habitacion")
public class Habitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "habitacion_hab_codigo_seq", sequenceName = "habitacion_hab_codigo_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "habitacion_hab_codigo_seq")
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

	@Column(name = "hab_numero")
	private Integer habNumero;

	@Column(name = "hab_activo")
	private Boolean habActivo;

	// bi-directional many-to-one association to HabitacionDetalle
	@OneToMany(mappedBy = "habitacion")
	private List<HabitacionDetalle> habitacionDetalles;

	// bi-directional many-to-one association to HabitacionSuplemento
	@OneToMany(mappedBy = "habitacion")
	private List<HabitacionSuplemento> habitacionSuplementos;

	// bi-directional many-to-one association to Hotel
	@ManyToOne
	@JoinColumn(name = "hot_codigo")
	private Hotel hotel;

	public Habitacion() {
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

	public Integer getHabNumero() {
		return this.habNumero;
	}

	public void setHabNumero(Integer habNumero) {
		this.habNumero = habNumero;
	}

	public List<HabitacionDetalle> getHabitacionDetalles() {
		return this.habitacionDetalles;
	}

	public void setHabitacionDetalles(List<HabitacionDetalle> habitacionDetalles) {
		this.habitacionDetalles = habitacionDetalles;
	}

	public HabitacionDetalle addHabitacionDetalle(HabitacionDetalle habitacionDetalle) {
		getHabitacionDetalles().add(habitacionDetalle);
		habitacionDetalle.setHabitacione(this);

		return habitacionDetalle;
	}

	public HabitacionDetalle removeHabitacionDetalle(HabitacionDetalle habitacionDetalle) {
		getHabitacionDetalles().remove(habitacionDetalle);
		habitacionDetalle.setHabitacione(null);

		return habitacionDetalle;
	}

	public List<HabitacionSuplemento> getHabitacionSuplementos() {
		return this.habitacionSuplementos;
	}

	public void setHabitacionSuplementos(List<HabitacionSuplemento> habitacionSuplementos) {
		this.habitacionSuplementos = habitacionSuplementos;
	}

	public HabitacionSuplemento addHabitacionSuplemento(HabitacionSuplemento habitacionSuplemento) {
		getHabitacionSuplementos().add(habitacionSuplemento);
		habitacionSuplemento.setHabitacion(this);

		return habitacionSuplemento;
	}

	public HabitacionSuplemento removeHabitacionSuplemento(HabitacionSuplemento habitacionSuplemento) {
		getHabitacionSuplementos().remove(habitacionSuplemento);
		habitacionSuplemento.setHabitacion(null);

		return habitacionSuplemento;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Boolean getHabActivo() {
		return habActivo;
	}

	public void setHabActivo(Boolean habActivo) {
		this.habActivo = habActivo;
	}

}