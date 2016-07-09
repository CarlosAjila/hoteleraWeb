package ec.com.hoteleraWeb.safari.control.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.control.dao.ClienteActividadDao;
import ec.com.hoteleraWeb.safari.control.entity.ClienteActividad;

@Service
public class ClienteActividadServiceImpl implements ClienteActividadService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	ClienteActividadDao clienteActividadDao;

	public void insertar(List<ClienteActividad> listaClienteActividades) {
		for (ClienteActividad clienteActividad : listaClienteActividades) {
			clienteActividadDao.insertar(clienteActividad);
		}
	}

	public void actualizar(List<ClienteActividad> listaClienteActividades) {
		for (ClienteActividad clienteActividad : listaClienteActividades) {
			clienteActividadDao.actualizar(clienteActividad);
		}
	}

}
