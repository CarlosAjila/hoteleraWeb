package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="emp_codigo")
	private Integer empCodigo;

	@Column(name="emp_apellido")
	private String empApellido;

	@Column(name="emp_cedula")
	private String empCedula;

	@Column(name="emp_direccion")
	private String empDireccion;

	@Column(name="emp_nombre")
	private String empNombre;

	@Column(name="emp_tipo")
	private String empTipo;

	@Column(name="emp_titulo")
	private String empTitulo;

	@Column(name="hot_codigo")
	private Integer hotCodigo;

	public Empleado() {
	}

	public Integer getEmpCodigo() {
		return this.empCodigo;
	}

	public void setEmpCodigo(Integer empCodigo) {
		this.empCodigo = empCodigo;
	}

	public String getEmpApellido() {
		return this.empApellido;
	}

	public void setEmpApellido(String empApellido) {
		this.empApellido = empApellido;
	}

	public String getEmpCedula() {
		return this.empCedula;
	}

	public void setEmpCedula(String empCedula) {
		this.empCedula = empCedula;
	}

	public String getEmpDireccion() {
		return this.empDireccion;
	}

	public void setEmpDireccion(String empDireccion) {
		this.empDireccion = empDireccion;
	}

	public String getEmpNombre() {
		return this.empNombre;
	}

	public void setEmpNombre(String empNombre) {
		this.empNombre = empNombre;
	}

	public String getEmpTipo() {
		return this.empTipo;
	}

	public void setEmpTipo(String empTipo) {
		this.empTipo = empTipo;
	}

	public String getEmpTitulo() {
		return this.empTitulo;
	}

	public void setEmpTitulo(String empTitulo) {
		this.empTitulo = empTitulo;
	}

	public Integer getHotCodigo() {
		return this.hotCodigo;
	}

	public void setHotCodigo(Integer hotCodigo) {
		this.hotCodigo = hotCodigo;
	}

}