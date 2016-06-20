package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Empleado;
import ec.com.hoteleraWeb.safari.control.entity.Hotel;

public interface EmpleadoService {

	@Transactional
	public List<Empleado> obtenerTodos();

	@Transactional
	public Empleado obtenerPorCedula(String cedula);
	
	@Transactional
	public void insertar(Empleado empleado);
	
	@Transactional
	public void actualizar(Empleado empleado);
	

	@Transactional
	public void eliminar(Empleado empleado);
	
	@Transactional
	public Empleado obtenerPorCedula_Codigo(String cedula, Integer codigo);
}