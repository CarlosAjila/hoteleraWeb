package ec.com.hoteleraWeb.safari.control.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Cliente;
import ec.com.hoteleraWeb.safari.control.entity.Empleado;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDao;

public interface ClienteDao extends GenericDao<Cliente, Integer> {

	@Transactional
	public List<Cliente> obtenerTodos();
	
	@Transactional
	public Cliente obtenerPorCedula(String cedula);
}
