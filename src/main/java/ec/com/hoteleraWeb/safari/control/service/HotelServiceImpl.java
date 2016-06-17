package ec.com.hoteleraWeb.safari.control.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.control.dao.HotelDao;
import ec.com.hoteleraWeb.safari.control.entity.Hotel;

@Service
public class HotelServiceImpl implements HotelService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private HotelDao hotelDao;

	public List<Hotel> obtenerTodos() {
		return hotelDao.obtenerTodos();
	}

}
