package ec.com.hoteleraWeb.safari.control.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Hotel;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDao;

public interface HotelDao extends GenericDao<Hotel, Integer> {

	@Transactional
	public List<Hotel> obtenerTodos();

	@Transactional
	public Hotel obtenerPorRuc(String ruc);

}
