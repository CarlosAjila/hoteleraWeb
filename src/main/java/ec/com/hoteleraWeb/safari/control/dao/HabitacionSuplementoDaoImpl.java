package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.HabitacionSuplemento;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;

@Repository
public class HabitacionSuplementoDaoImpl extends GenericDaoImpl<HabitacionSuplemento, Integer>
		implements HabitacionSuplementoDao, Serializable {

	private static final long serialVersionUID = 1L;
}