package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.HabitacionSuplemento;

public interface HabitacionSuplementoService {

	@Transactional
	public void insertar(List<HabitacionSuplemento> listaHabitacionesSuplementos);

	@Transactional
	public void actualizar(List<HabitacionSuplemento> listaHabitacionesSuplementos);

}