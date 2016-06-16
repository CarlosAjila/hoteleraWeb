package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.HabitacionDetalle;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;

@Repository
public class HabitacionDetalleDaoImpl extends GenericDaoImpl<HabitacionDetalle, Integer>
		implements HabitacionDetalleDao, Serializable {

	private static final long serialVersionUID = 1L;
}