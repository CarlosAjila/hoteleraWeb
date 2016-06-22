package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Habitacion;
import ec.com.hoteleraWeb.safari.control.entity.Hotel;

public interface HabitacionService {

	@Transactional
	public List<Habitacion> obtenerTodos();

	@Transactional
	public Habitacion obtenerPorRuc(String ruc);

	@Transactional
	public Habitacion obtenerPorRuc_Codigo(String ruc, Integer codigo);

	@Transactional
	public void insertar(Habitacion habitacion);

	@Transactional
	public void actualizar(Habitacion habitacion);

	@Transactional
	public void eliminar(Habitacion habitacion);
}