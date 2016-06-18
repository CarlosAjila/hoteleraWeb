package ec.com.hoteleraWeb.safari.control.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.control.dao.ClienteDao;
import ec.com.hoteleraWeb.safari.control.entity.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ClienteDao clienteDao;

	public List<Cliente> obtenerTodos() {
		return clienteDao.obtenerTodos();
	}

}
