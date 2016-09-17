package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.UsuarioDetalle;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;

@Repository
public class UsuarioDetalleDaoImpl extends GenericDaoImpl<UsuarioDetalle, Integer>
		implements UsuarioDetalleDao, Serializable {

	private static final long serialVersionUID = 1L;

}