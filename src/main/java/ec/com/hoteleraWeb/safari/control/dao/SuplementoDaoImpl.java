package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.Suplemento;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;
import ec.com.hoteleraWeb.safari.utils.dao.GenericSQLDao;

@Repository
public class SuplementoDaoImpl extends GenericDaoImpl<Suplemento, Integer> implements SuplementoDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private GenericSQLDao genericSQLDao;

	public List<Suplemento> obtenerSuplementosPorHotel(String codigoHotel) {
		String sql = "select s.* from suplemento s "
				+ "inner join habitacion_suplemento hs on hs.sup_codigo=s.sup_codigo "
				+ "inner join habitacion h on h.hab_codigo=hs.hab_codigo " + "where h.hot_codigo='" + codigoHotel + "'";
		List<Suplemento> suplementos = new ArrayList<Suplemento>();
		suplementos = genericSQLDao.obtenerPorSql(sql, Suplemento.class);
		if (suplementos != null)
			if (suplementos.size() != 0)
				return suplementos;
		return null;
	}

}