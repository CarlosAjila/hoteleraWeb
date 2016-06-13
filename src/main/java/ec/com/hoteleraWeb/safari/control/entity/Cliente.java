package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cli_codigo")
	private Integer cliCodigo;

	@Column(name="cli_apellido")
	private String cliApellido;

	@Column(name="cli_cedula")
	private String cliCedula;

	@Column(name="cli_direccion")
	private String cliDireccion;

	@Column(name="cli_movil")
	private String cliMovil;

	@Column(name="cli_nombre")
	private String cliNombre;

	@Column(name="cli_telefono")
	private String cliTelefono;

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

}