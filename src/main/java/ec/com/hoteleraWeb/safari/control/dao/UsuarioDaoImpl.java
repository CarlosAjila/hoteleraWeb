package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.Usuario;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;
import ec.com.hoteleraWeb.safari.utils.dao.GenericSQLDao;

@Repository
public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Integer> implements UsuarioDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private GenericSQLDao genericSQLDao;

	public Usuario obtenerUsuarioPorNick(String nick) {
		String sql = "Select * FROM usuario where usu_nick='" + nick + "';";
		Usuario usuario = new Usuario();
		usuario = genericSQLDao.obtenerPorSql(sql, Usuario.class).get(0);
		if (usuario != null)
			return usuario;
		return null;
	}

	public List<Usuario> obtenerUsuarioPorHotel(String codigoHotel) {
		String sql = "Select usuario.* FROM usuario "
				+ "INNER JOIN usuario_detalle ON usuario.usu_id = usuario_detalle.usu_id "
				+ "WHERE usuario_detalle.hot_codigo =" + codigoHotel + ";";
		return genericSQLDao.obtenerPorSql(sql, Usuario.class);
	}
}