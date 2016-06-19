package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "hotel_hot_codigo_seq", sequenceName = "hotel_hot_codigo_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_hot_codigo_seq")
	@Column(name = "hot_codigo")
	private Integer hotCodigo;

	@Column(name = "hot_direccion")
	private String hotDireccion;

	@Column(name = "hot_estrella")
	private Long hotEstrella;

	@Column(name = "hot_nombre")
	private String hotNombre;

	@Column(name = "hot_ruc")
	private String hotRuc;

	@Column(name = "hot_telefono")
	private String hotTelefono;

	@Column(name = "hot_activo")
	private Boolean hotActivo;

	// bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy = "hotel")
	private List<Empleado> empleados;

	// bi-directional many-to-one association to Habitacione
	@OneToMany(mappedBy = "hotel")
	private List<Habitacion> habitaciones;

	// bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy = "hotel")
	private List<Usuario> usuarios;

	public Hotel() {
	}

	public Integer getHotCodigo() {
		return this.hotCodigo;
	}

	public void setHotCodigo(Integer hotCodigo) {
		this.hotCodigo = hotCodigo;
	}

	public String getHotDireccion() {
		return this.hotDireccion;
	}

	public void setHotDireccion(String hotDireccion) {
		this.hotDireccion = hotDireccion;
	}

	public Long getHotEstrella() {
		return this.hotEstrella;
	}

	public void setHotEstrella(Long hotEstrella) {
		this.hotEstrella = hotEstrella;
	}

	public String getHotNombre() {
		return this.hotNombre;
	}

	public void setHotNombre(String hotNombre) {
		this.hotNombre = hotNombre;
	}

	public String getHotRuc() {
		return this.hotRuc;
	}

	public void setHotRuc(String hotRuc) {
		this.hotRuc = hotRuc;
	}

	public String getHotTelefono() {
		return this.hotTelefono;
	}

	public void setHotTelefono(String hotTelefono) {
		this.hotTelefono = hotTelefono;
	}

	public Boolean getHotActivo() {
		return hotActivo;
	}

	public void setHotActivo(Boolean hotActivo) {
		this.hotActivo = hotActivo;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setHotel(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setHotel(null);

		return empleado;
	}

	public List<Habitacion> getHabitaciones() {
		return this.habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Habitacion addHabitacione(Habitacion habitacione) {
		getHabitaciones().add(habitacione);
		habitacione.setHotel(this);

		return habitacione;
	}

	public Habitacion removeHabitacione(Habitacion habitacione) {
		getHabitaciones().remove(habitacione);
		habitacione.setHotel(null);

		return habitacione;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setHotel(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setHotel(null);

		return usuario;
	}

}