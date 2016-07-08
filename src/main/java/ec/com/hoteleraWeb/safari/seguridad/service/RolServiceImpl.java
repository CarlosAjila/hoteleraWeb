package ec.com.hoteleraWeb.safari.seguridad.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.seguridad.dao.RolDao;
import ec.com.hoteleraWeb.safari.seguridad.entity.Rol;

@Service
public class RolServiceImpl implements RolService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RolDao rolDao;

	public List<Rol> obtener() {
		return rolDao.obtener(Rol.class, "nombre", null);
	}

	public Rol obtenerPorNombre(String nombre) {
		return rolDao.obtenerPorAtributo(Rol.class, "nombre", nombre, null);
	}

	public Rol obtenerPorRolId(int rolId) {
		return rolDao.obtenerPorId(Rol.class, rolId);
	}
	
	
	public List<Rol> obtenerListaRol(){
		return rolDao.obtenerListaRol();
	}

}