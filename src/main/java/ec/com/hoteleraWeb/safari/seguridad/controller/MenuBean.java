package ec.com.hoteleraWeb.safari.seguridad.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSeparator;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import ec.com.hoteleraWeb.safari.control.service.UsuarioService;
import ec.com.hoteleraWeb.safari.seguridad.entity.Menu;
import ec.com.hoteleraWeb.safari.seguridad.entity.Usuario;
import ec.com.hoteleraWeb.safari.seguridad.service.MenuService;
import ec.com.hoteleraWeb.safari.utils.UtilsAplicacion;

@Controller
@Scope("session")
public class MenuBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private MenuService menuService;

	@Autowired
	private UsuarioService usuarioService;

	private MenuModel menuModel;
	private String nombreUsuario;

	public MenuBean() {
	}

	public void cargarMenu() {
		if (menuModel == null) {
			menuModel = new DefaultMenuModel();

			DefaultSubMenu subMenu1 = null;
			DefaultSubMenu subMenu2 = null;
			DefaultSubMenu subMenu3 = null;
			DefaultMenuItem menuItem = null;

			int padre1 = 0;
			int padre2 = 0;
			int padre3 = 0;

			List<Menu> listMenu = menuService
					.obtenerPorUsuario(SecurityContextHolder.getContext().getAuthentication().getName());
			for (Menu menu : listMenu) {
				if (menu.getMenVista().compareTo("-") == 0) {
					if (menu.getMenNivel() == 1) {
						padre1 = menu.getMenId();
						subMenu1 = new DefaultSubMenu(menu.getMenNombre(), "fa " + menu.getMenIcono());
						menuModel.addElement(subMenu1);
						menuModel.addElement(new DefaultSeparator());
					} else if (menu.getMenNivel() == 2) {
						padre2 = menu.getMenId();
						subMenu2 = new DefaultSubMenu(menu.getMenNombre(), "fa " + menu.getMenIcono());
						subMenu1.addElement(subMenu2);
					} else if (menu.getMenNivel() == 3) {
						padre3 = menu.getMenId();
						subMenu3 = new DefaultSubMenu(menu.getMenNombre(), "fa " + menu.getMenIcono());
						subMenu2.addElement(subMenu3);
					}
				} else {
					menuItem = new DefaultMenuItem(menu.getMenNombre(), "fa " + menu.getMenIcono(), menu.getMenVista());
					menuItem.setAjax(true);
					menuItem.setUpdate("centro");
					if (padre1 == menu.getMenPadre())
						subMenu1.addElement(menuItem);
					else if (padre2 == menu.getMenPadre())
						subMenu2.addElement(menuItem);
					else if (padre3 == menu.getMenPadre())
						subMenu3.addElement(menuItem);
				}
			}
		}
	}

	public MenuModel getMenuModel() {
		return menuModel;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	@PostConstruct
	public void init() {
		UtilsAplicacion.actualizarPaginaWeb("www.carlosajila.com.ec");
		Usuario u = usuarioService
				.obtenerActivoPorCedula(SecurityContextHolder.getContext().getAuthentication().getName());
		setNombreUsuario(u.getUsuNombre());
		cargarMenu();
	}

	public void cargarSistema() {

	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}