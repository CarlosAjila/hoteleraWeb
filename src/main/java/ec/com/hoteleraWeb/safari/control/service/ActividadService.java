package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Actividad;
import ec.com.hoteleraWeb.safari.control.entity.Empleado;

public interface ActividadService {

	@Transactional
	public List<Actividad> obtenerTodos();
	
	@Transactional
	public void insertar(Actividad actividad, Integer empcodigo);
}