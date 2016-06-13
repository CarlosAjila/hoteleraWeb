package ec.com.hoteleraWeb.safari.seguridad.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="usu_id")
	private Integer usuId;

	@Column(name="hot_codigo")
	private Integer hotCodigo;

	@Column(name="usu_activo")
	private Boolean usuActivo;

	@Column(name="usu_nick")
	private String usuNick;

	@Column(name="usu_nombre")
	private String usuNombre;

	@Column(name="usu_password")
	private String usuPassword;

	public Usuario() {
	}

	public Integer getUsuId() {
		return this.usuId;
	}

	public void setUsuId(Integer usuId) {
		this.usuId = usuId;
	}

	public Integer getHotCodigo() {
		return this.hotCodigo;
	}

	public void setHotCodigo(Integer hotCodigo) {
		this.hotCodigo = hotCodigo;
	}

	public Boolean getUsuActivo() {
		return this.usuActivo;
	}

	public void setUsuActivo(Boolean usuActivo) {
		this.usuActivo = usuActivo;
	}

	public String getUsuNick() {
		return this.usuNick;
	}

	public void setUsuNick(String usuNick) {
		this.usuNick = usuNick;
	}

	public String getUsuNombre() {
		return this.usuNombre;
	}

	public void setUsuNombre(String usuNombre) {
		this.usuNombre = usuNombre;
	}

	public String getUsuPassword() {
		return this.usuPassword;
	}

	public void setUsuPassword(String usuPassword) {
		this.usuPassword = usuPassword;
	}

}