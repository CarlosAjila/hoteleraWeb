package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.Actividad;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;
import ec.com.hoteleraWeb.safari.utils.dao.GenericSQLDao;

@Repository
public class ActividadDaoImpl extends GenericDaoImpl<Actividad, Integer> implements ActividadDao, Serializable {

	@Autowired
	private GenericSQLDao genericSQLDao;
	private static final long serialVersionUID = 1L;

	public List<Actividad> obtenerTodos() {
		String sql = "Select * FROM public.actividad";
		return genericSQLDao.obtenerPorSql(sql, Actividad.class);
	}

	public List<Actividad> obtenerActividadesPorHotel(Integer codigoHotel) {
		String sql = "Select * FROM public.fun_lista_actividades ("+ codigoHotel +")";
		return genericSQLDao.obtenerPorSql(sql, Actividad.class);
	}
}