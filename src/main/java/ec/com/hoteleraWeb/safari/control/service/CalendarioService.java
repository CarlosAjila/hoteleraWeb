package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Actividad;
import ec.com.hoteleraWeb.safari.control.entity.Calendario;

public interface CalendarioService {

	@Transactional
	public List<Calendario> obtenerTodos();
	
	@Transactional
	public void insertar(Calendario calendario);

}