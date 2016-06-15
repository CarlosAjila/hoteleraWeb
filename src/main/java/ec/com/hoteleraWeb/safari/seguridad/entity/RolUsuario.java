package ec.com.hoteleraWeb.safari.seguridad.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "rolusuario")
public class RolUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "rol_usuario_emp_rol_id_seq", sequenceName = "rol_usuario_emp_rol_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_usuario_emp_rol_id_seq")
	@Column(name = "emp_rol_id")
	private Integer empRolId;

	@Column(name = "rol_usul_ativo")
	private Boolean rolUsulAtivo;

	// bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name = "rol_id")
	private Rol rol;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "usu_id")
	private Usuario usuario;

	public RolUsuario() {
	}

	public Integer getEmpRolId() {
		return this.empRolId;
	}

	public void setEmpRolId(Integer empRolId) {
		this.empRolId = empRolId;
	}

	public Boolean getRolUsulAtivo() {
		return this.rolUsulAtivo;
	}

	public void setRolUsulAtivo(Boolean rolUsulAtivo) {
		this.rolUsulAtivo = rolUsulAtivo;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
