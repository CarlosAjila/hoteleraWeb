package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.Calendario;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;
import ec.com.hoteleraWeb.safari.utils.dao.GenericSQLDao;

@Repository
public class CalendarioDaoImpl extends GenericDaoImpl<Calendario, Integer> implements CalendarioDao, Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	private GenericSQLDao genericSQLDao;

	public List<Calendario> obtenerTodos() {
		String sql = "Select * FROM public.calendario";
		return genericSQLDao.obtenerPorSql(sql, Calendario.class);

	}
}