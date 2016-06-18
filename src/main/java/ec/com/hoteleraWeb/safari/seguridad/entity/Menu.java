package ec.com.hoteleraWeb.safari.seguridad.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(allocationSize = 1, name = "menu_men_id_seq", sequenceName = "menu_men_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_men_id_seq")
	@Column(name = "men_id")
	private Integer menId;

	@Column(name = "men_icono")
	private String menIcono;

	@Column(name = "men_nivel")
	private Integer menNivel;

	@Column(name = "men_nombre")
	private String menNombre;

	@Column(name = "men_padre")
	private Integer menPadre;

	@Column(name = "men_visible")
	private Boolean menVisible;

	@Column(name = "men_vista")
	private String menVista;

	// bi-directional many-to-one association to RolMenu
	@OneToMany(mappedBy = "menu")
	private List<RolMenu> rolMenus;

	public Menu() {
	}

	public Integer getMenId() {
		return this.menId;
	}

	public void setMenId(Integer menId) {
		this.menId = menId;
	}

	public String getMenIcono() {
		return this.menIcono;
	}

	public void setMenIcono(String menIcono) {
		this.menIcono = menIcono;
	}

	public Integer getMenNivel() {
		return this.menNivel;
	}

	public void setMenNivel(Integer menNivel) {
		this.menNivel = menNivel;
	}

	public String getMenNombre() {
		return this.menNombre;
	}

	public void setMenNombre(String menNombre) {
		this.menNombre = menNombre;
	}

	public Integer getMenPadre() {
		return this.menPadre;
	}

	public void setMenPadre(Integer menPadre) {
		this.menPadre = menPadre;
	}

	public Boolean getMenVisible() {
		return this.menVisible;
	}

	public void setMenVisible(Boolean menVisible) {
		this.menVisible = menVisible;
	}

	public String getMenVista() {
		return this.menVista;
	}

	public void setMenVista(String menVista) {
		this.menVista = menVista;
	}

	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "menu")
	public List<RolMenu> getRolMenus() {
		return this.rolMenus;
	}

	public void setRolMenus(List<RolMenu> rolMenus) {
		this.rolMenus = rolMenus;
	}

	public RolMenu addRolMenus(RolMenu rolMenus) {
		getRolMenus().add(rolMenus);
		rolMenus.setMenu(this);

		return rolMenus;
	}

	public RolMenu removeRolMenus(RolMenu rolMenus) {
		getRolMenus().remove(rolMenus);
		rolMenus.setMenu(null);

		return rolMenus;
	}

}