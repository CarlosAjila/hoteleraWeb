package ec.com.hoteleraWeb.safari.seguridad.dao;

import java.io.Serializable;
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
		return genericSQLDao.obtenerPorSql(sql, Rol.class);
	}

}
