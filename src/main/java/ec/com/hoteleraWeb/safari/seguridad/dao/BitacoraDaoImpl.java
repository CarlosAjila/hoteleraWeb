package ec.com.hoteleraWeb.safari.seguridad.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.seguridad.entity.Bitacora;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;

@Repository
public class BitacoraDaoImpl extends GenericDaoImpl<Bitacora, Integer> implements BitacoraDao, Serializable {

	private static final long serialVersionUID = 1L;

}
