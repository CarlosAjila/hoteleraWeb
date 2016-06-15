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
@Table(name = "rolmenu")
public class RolMenu implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(allocationSize = 1, name = "rol_menu_rol_men_id_seq", sequenceName = "rol_menu_rol_men_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_menu_rol_men_id_seq")
	@Column(name = "rol_men_id")
	private Integer rolMenId;

	// bi-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name = "men_id")
	private Menu menu;

	// bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name = "rol_id")
	private Rol rol;

	public RolMenu() {
	}

	public Integer getRolMenId() {
		return this.rolMenId;
	}

	public void setRolMenId(Integer rolMenId) {
		this.rolMenId = rolMenId;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
}
