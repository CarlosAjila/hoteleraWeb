package ec.com.hoteleraWeb.safari.seguridad.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.seguridad.entity.Rol;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;

@Repository
public class RolDaoImpl extends GenericDaoImpl<Rol, Integer> implements RolDao, Serializable {

	private static final long serialVersionUID = 1L;

}
