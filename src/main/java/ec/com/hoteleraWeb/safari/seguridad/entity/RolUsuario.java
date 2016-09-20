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

import ec.com.hoteleraWeb.safari.control.entity.Usuario;

@Entity
@Table(name = "rol_usuario")
public class RolUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "rol_usuario_rol_usu_id_seq", sequenceName = "rol_usuario_rol_usu_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_usuario_rol_usu_id_seq")
	@Column(name = "rol_usu_id")
	private Integer rolUsuId;

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

	public Integer getRolUsuId() {
		return this.rolUsuId;
	}

	public void setRolUsuId(Integer rolUsuId) {
		this.rolUsuId = rolUsuId;
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
