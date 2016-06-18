package ec.com.hoteleraWeb.safari.control.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.Hotel;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;
import ec.com.hoteleraWeb.safari.utils.dao.GenericSQLDao;

@Repository
public class HotelDaoImpl extends GenericDaoImpl<Hotel, Integer> implements HotelDao {

	@Autowired
	private GenericSQLDao genericSQLDao;

	public List<Hotel> obtenerTodos() {
		String sql = "Select * FROM hotel";
		List<Hotel> hoteles = new ArrayList<Hotel>();
		hoteles = genericSQLDao.obtenerPorSql(sql, Hotel.class);
		if (hoteles != null)
			if (hoteles.size() != 0)
				return hoteles;
		return null;
	}

	public Hotel obtenerPorRuc(String ruc) {
		String sql = "select * from hotel where hot_ruc='" + ruc + "'";
		List<Hotel> hotel = new ArrayList<Hotel>();
		hotel = genericSQLDao.obtenerPorSql(sql, Hotel.class);
		if (hotel != null)
			if (hotel.size() != 0)
				return hotel.get(0);
		return null;
	}
}