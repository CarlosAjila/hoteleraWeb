package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Hotel;

public interface HotelService {

	@Transactional
	public List<Hotel> obtenerTodos();
}