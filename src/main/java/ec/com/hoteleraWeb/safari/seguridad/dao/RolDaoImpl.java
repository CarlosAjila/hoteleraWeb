package ec.com.hoteleraWeb.safari.seguridad.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.seguridad.entity.Rol;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;
import ec.com.hoteleraWeb.safari.utils.dao.GenericSQLDao;

@Repository
public class RolDaoImpl extends GenericDaoImpl<Rol, Integer> implements RolDao, Serializable {

	@Autowired
	private GenericSQLDao genericSQLDao;
	private static final long serialVersionUID = 1L;

	public List<Rol> obtenerListaRol() {
		
		String sql = "Select * FROM rol;";
		System.out.println("ffffffffffffffffffffffffff");
		List<Rol> roles = new ArrayList<Rol>();
		roles = genericSQLDao.obtenerPorSql(sql, Rol.class);

		for (Rol rol : roles) {
			System.out.println(rol.getRolNombre());
		}

		if (roles != null)
			if (roles.size() != 0)
				return roles;

		return null;
	}

}
