package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.Habitacion;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;

@Repository
public class HabitacionDaoImpl extends GenericDaoImpl<Habitacion, Integer> implements HabitacionDao, Serializable {

	private static final long serialVersionUID = 1L;
}