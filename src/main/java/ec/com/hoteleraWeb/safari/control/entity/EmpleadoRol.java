package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the empleado_rol database table.
 * 
 */
@Entity
@Table(name="empleado_rol")
@NamedQuery(name="EmpleadoRol.findAll", query="SELECT e FROM EmpleadoRol e")
public class EmpleadoRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="emp_rol_id")
	private Integer empRolId;

	@Column(name="emp_rol_ativo")
	private Boolean empRolAtivo;

	@Column(name="rol_id")
	private Integer rolId;

	@Column(name="usu_id")
	private Integer usuId;

	public EmpleadoRol() {
	}

	public Integer getEmpRolId() {
		return this.empRolId;
	}

	public void setEmpRolId(Integer empRolId) {
		this.empRolId = empRolId;
	}

	public Boolean getEmpRolAtivo() {
		return this.empRolAtivo;
	}

	public void setEmpRolAtivo(Boolean empRolAtivo) {
		this.empRolAtivo = empRolAtivo;
	}

	public Integer getRolId() {
		return this.rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public Integer getUsuId() {
		return this.usuId;
	}

	public void setUsuId(Integer usuId) {
		this.usuId = usuId;
	}

}