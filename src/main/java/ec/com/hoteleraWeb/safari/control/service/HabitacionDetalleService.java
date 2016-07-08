package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.HabitacionDetalle;

public interface HabitacionDetalleService {

	@Transactional
	public void insertar(List<HabitacionDetalle> listaHabitacionesDetalle);

	@Transactional
	public void actualizar(List<HabitacionDetalle> listaHabitacionesDetalle);

}