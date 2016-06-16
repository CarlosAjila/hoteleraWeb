package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.Calendario;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;

@Repository
public class CalendarioDaoImpl extends GenericDaoImpl<Calendario, Integer> implements CalendarioDao, Serializable {

	private static final long serialVersionUID = 1L;
}