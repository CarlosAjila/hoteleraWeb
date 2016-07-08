package ec.com.hoteleraWeb.safari.seguridad.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Empleado;
import ec.com.hoteleraWeb.safari.seguridad.entity.Rol;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDao;

public interface RolDao extends GenericDao<Rol, Integer> {
	@Transactional
	public List<Rol> obtenerListaRol();

}
