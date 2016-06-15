package ec.com.hoteleraWeb.safari.seguridad.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.seguridad.entity.Menu;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;

@Repository
public class MenuDaoImpl extends GenericDaoImpl<Menu, Integer> implements MenuDao, Serializable {

	private static final long serialVersionUID = 1L;

}
