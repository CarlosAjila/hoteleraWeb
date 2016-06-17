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
		String sql = "Select * FROM public.hotel";
		List<Hotel> hoteles = new ArrayList<Hotel>();
		hoteles = genericSQLDao.obtenerPorSql(sql, Hotel.class);
		System.out.println("size" + hoteles.size());
		for (Hotel hotel : hoteles) {
			System.out.println("hotel.getHotNombre() " + hotel.getHotNombre());
		}
		return hoteles;
	}
}