package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.seguridad.entity.Usuario;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;

@Repository
public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Integer> implements UsuarioDao, Serializable {

	private static final long serialVersionUID = 1L;
}