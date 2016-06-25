package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Hotel;

public interface HotelService {

	@Transactional
	public List<Hotel> obtenerTodos();

	@Transactional
	public List<Hotel> obtenerTodosPorUsuario(String codigoUsuario);

	@Transactional
	public Hotel obtenerPorRuc(String ruc);

	@Transactional
	public Hotel obtenerPorRuc_Codigo(String ruc, Integer codigo);

	@Transactional
	public Hotel obtenerPorCodigo(String codigo);

	@Transactional
	public void insertar(Hotel hotel);

	@Transactional
	public void actualizar(Hotel hotel);

	@Transactional
	public void eliminar(Hotel hotel);
}