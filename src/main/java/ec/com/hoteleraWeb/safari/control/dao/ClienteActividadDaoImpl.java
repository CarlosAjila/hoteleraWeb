package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.ClienteActividad;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;

@Repository
public class ClienteActividadDaoImpl extends GenericDaoImpl<ClienteActividad, Integer>
		implements ClienteActividadDao, Serializable {

	private static final long serialVersionUID = 1L;
}