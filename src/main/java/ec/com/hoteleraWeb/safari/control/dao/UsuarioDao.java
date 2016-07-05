package ec.com.hoteleraWeb.safari.control.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Usuario;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDao;

public interface UsuarioDao extends GenericDao<Usuario, Integer> {

	@Transactional
	public Usuario obtenerUsuarioPorNick(String nick);

	@Transactional
	public List<Usuario> obtenerUsuarioPorHotel(String codigoHotel);
}
