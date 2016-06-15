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
@Table(name = "cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "cliente_cli_codigo_seq", sequenceName = "cliente_cli_codigo_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_cli_codigo_seq")
	@Column(name = "cli_codigo")
	private Integer cliCodigo;

	@Column(name = "cli_apellido")
	private String cliApellido;

	@Column(name = "cli_cedula")
	private String cliCedula;

	@Column(name = "cli_direccion")
	private String cliDireccion;

	@Column(name = "cli_movil")
	private String cliMovil;

	@Column(name = "cli_nombre")
	private String cliNombre;

	@Column(name = "cli_telefono")
	private String cliTelefono;

	// bi-directional many-to-one association to Reservacion
	@OneToMany(mappedBy = "cliente")
	private List<Reservacion> reservacions;

	public Cliente() {
	}

	public Integer getCliCodigo() {
		return this.cliCodigo;
	}

	public void setCliCodigo(Integer cliCodigo) {
		this.cliCodigo = cliCodigo;
	}

	public String getCliApellido() {
		return this.cliApellido;
	}

	public void setCliApellido(String cliApellido) {
		this.cliApellido = cliApellido;
	}

	public String getCliCedula() {
		return this.cliCedula;
	}

	public void setCliCedula(String cliCedula) {
		this.cliCedula = cliCedula;
	}

	public String getCliDireccion() {
		return this.cliDireccion;
	}

	public void setCliDireccion(String cliDireccion) {
		this.cliDireccion = cliDireccion;
	}

	public String getCliMovil() {
		return this.cliMovil;
	}

	public void setCliMovil(String cliMovil) {
		this.cliMovil = cliMovil;
	}

	public String getCliNombre() {
		return this.cliNombre;
	}

	public void setCliNombre(String cliNombre) {
		this.cliNombre = cliNombre;
	}

	public String getCliTelefono() {
		return this.cliTelefono;
	}

	public void setCliTelefono(String cliTelefono) {
		this.cliTelefono = cliTelefono;
	}

	public List<Reservacion> getReservacions() {
		return this.reservacions;
	}

	public void setReservacions(List<Reservacion> reservacions) {
		this.reservacions = reservacions;
	}

	public Reservacion addReservacion(Reservacion reservacion) {
		getReservacions().add(reservacion);
		reservacion.setCliente(this);

		return reservacion;
	}

	public Reservacion removeReservacion(Reservacion reservacion) {
		getReservacions().remove(reservacion);
		reservacion.setCliente(null);

		return reservacion;
	}

}