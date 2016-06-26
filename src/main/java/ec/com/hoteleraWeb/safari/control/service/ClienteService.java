package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Cliente;
import ec.com.hoteleraWeb.safari.control.entity.Empleado;

public interface ClienteService {

	@Transactional
	public List<Cliente> obtenerTodos();

	@Transactional
	public void insertar(Cliente cliente);

	@Transactional
	public void actualizar(Cliente cliente);
	
	@Transactional
	public void eliminar(Cliente cliente);

	@Transactional
	public Cliente obtenerPorCedula(String cedula);
}