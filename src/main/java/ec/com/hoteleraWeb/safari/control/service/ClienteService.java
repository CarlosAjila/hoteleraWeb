package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Cliente;

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

	@Transactional
	public List<String> obtenerListaClientesAutoComplete(String criterioClienteBusqueda);

	@Transactional
	public Cliente cargarCliente(String cliente);

	@Transactional
	public List<Cliente> obtener(String criterioCliente);

	@Transactional
	public Cliente obtenerClientePorCedula(String cedula);
}