package ec.com.hoteleraWeb.safari.seguridad.entity;

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
@Table(name = "rol")
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(allocationSize = 1, name = "rol_rol_id_seq", sequenceName = "rol_rol_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_rol_id_seq")
	@Column(name = "rol_id")
	private Integer rolId;

	@Column(name = "rol_nombre")
	private String rolNombre;

	@Column(name = "rol_rescripcion")
	private String rolRescripcion;

	// bi-directional many-to-one association to RolMenu
	@OneToMany(mappedBy = "rol")
	private List<RolMenu> rolMenus;

	// bi-directional many-to-one association to RolUsuario
	@OneToMany(mappedBy = "rol")
	private List<RolUsuario> rolUsuarios;

	public Rol() {
	}

	public Rol(Integer rolId, String rolNombre, String rolRescripcion, List<RolMenu> rolMenus,
			List<RolUsuario> rolUsuarios) {
		this.rolId = rolId;
		this.rolNombre = rolNombre;
		this.rolRescripcion = rolRescripcion;
		this.rolMenus = rolMenus;
		this.rolUsuarios = rolUsuarios;
	}

	public Integer getRolId() {
		return this.rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public String getRolNombre() {
		return this.rolNombre;
	}

	public void setRolNombre(String rolNombre) {
		this.rolNombre = rolNombre;
	}

	public String getRolRescripcion() {
		return this.rolRescripcion;
	}

	public void setRolRescripcion(String rolRescripcion) {
		this.rolRescripcion = rolRescripcion;
	}

	public List<RolMenu> getRolMenus() {
		return this.rolMenus;
	}

	public void setRolMenus(List<RolMenu> rolMenus) {
		this.rolMenus = rolMenus;
	}

	public RolMenu addRolMenus(RolMenu rolMenus) {
		getRolMenus().add(rolMenus);
		rolMenus.setRol(this);

		return rolMenus;
	}

	public RolMenu removeRolMenus(RolMenu rolMenus) {
		getRolMenus().remove(rolMenus);
		rolMenus.setRol(null);

		return rolMenus;
	}

	public List<RolUsuario> getRolUsuarios() {
		return this.rolUsuarios;
	}

	public void setRolUsuarios(List<RolUsuario> rolUsuarios) {
		this.rolUsuarios = rolUsuarios;
	}

	public RolUsuario addRolUsuario(RolUsuario rolUsuario) {
		getRolUsuarios().add(rolUsuario);
		rolUsuario.setRol(this);

		return rolUsuario;
	}

	public RolUsuario removeRolUsuario(RolUsuario rolUsuario) {
		getRolUsuarios().remove(rolUsuario);
		rolUsuario.setRol(null);

		return rolUsuario;
	}

}