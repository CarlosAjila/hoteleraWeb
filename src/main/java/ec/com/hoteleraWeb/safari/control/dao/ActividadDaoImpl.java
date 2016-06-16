package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.Actividad;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;

@Repository
public class ActividadDaoImpl extends GenericDaoImpl<Actividad, Integer> implements ActividadDao, Serializable {

	private static final long serialVersionUID = 1L;
}