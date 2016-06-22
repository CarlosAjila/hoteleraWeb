package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.Habitacion;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;
import ec.com.hoteleraWeb.safari.utils.dao.GenericSQLDao;

@Repository
public class HabitacionDaoImpl extends GenericDaoImpl<Habitacion, Integer> implements HabitacionDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private GenericSQLDao genericSQLDao;

	public List<Habitacion> obtenerTodos() {
		String sql = "Select * FROM hotel";
		List<Habitacion> habitaciones = new ArrayList<Habitacion>();
		habitaciones = genericSQLDao.obtenerPorSql(sql, Habitacion.class);
		if (habitaciones != null)
			if (habitaciones.size() != 0)
				return habitaciones;
		return null;
	}

	public Habitacion obtenerPorRuc(String ruc) {
		String sql = "select * from hotel where hot_ruc='" + ruc + "'";
		List<Habitacion> habitacion = new ArrayList<Habitacion>();
		habitacion = genericSQLDao.obtenerPorSql(sql, Habitacion.class);
		if (habitacion != null)
			if (habitacion.size() != 0)
				return habitacion.get(0);
		return null;
	}

	public Habitacion obtenerPorRuc_Codigo(String ruc, Integer codigo) {
		String sql = "select * from hotel where hot_ruc='" + ruc + "' and hot_codigo='" + codigo + "'";
		List<Habitacion> habitacion = new ArrayList<Habitacion>();
		habitacion = genericSQLDao.obtenerPorSql(sql, Habitacion.class);
		if (habitacion != null)
			if (habitacion.size() != 0)
				return habitacion.get(0);
		return null;
	}
}