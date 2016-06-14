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
@Table(name = "empleado")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "empleado_emp_codigo_seq", sequenceName = "empleado_emp_codigo_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleado_emp_codigo_seq")
	@Column(name = "emp_codigo")
	private Integer empCodigo;

	@Column(name = "emp_apellido")
	private String empApellido;

	@Column(name = "emp_cedula")
	private String empCedula;

	@Column(name = "emp_direccion")
	private String empDireccion;

	@Column(name = "emp_nombre")
	private String empNombre;

	@Column(name = "emp_tipo")
	private String empTipo;

	@Column(name = "emp_titulo")
	private String empTitulo;

	@Column(name = "hot_codigo")
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