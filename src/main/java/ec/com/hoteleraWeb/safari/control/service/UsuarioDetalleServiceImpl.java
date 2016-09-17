package ec.com.hoteleraWeb.safari.control.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.control.dao.UsuarioDetalleDao;
import ec.com.hoteleraWeb.safari.control.entity.UsuarioDetalle;
import ec.com.hoteleraWeb.safari.utils.dao.GenericSQLDao;

@Service
public class UsuarioDetalleServiceImpl implements UsuarioDetalleService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private GenericSQLDao genericSQLDao;

	@Autowired
	private UsuarioDetalleDao usuarioDetalleDao;

	@Override
	public boolean insertar(UsuarioDetalle usuarioDetalle) {
		usuarioDetalleDao.insertar(usuarioDetalle);
		return true;
	}

	@Override
	public boolean comprobarExistencia(UsuarioDetalle usuarioDetalle) {
		// Boolean existe = (Boolean) genericSQLDao.obtenerObjetoPorSql("",
		// Boolean.class);
		Boolean existe = false;
		return existe;
	}

}
