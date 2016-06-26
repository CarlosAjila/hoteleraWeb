package ec.com.hoteleraWeb.safari.control.service;

import static ec.com.hoteleraWeb.safari.utils.UtilsAplicacion.presentaMensaje;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.control.dao.ClienteDao;
import ec.com.hoteleraWeb.safari.control.entity.Cliente;
import ec.com.hoteleraWeb.safari.control.entity.Empleado;

@Service
public class ClienteServiceImpl implements ClienteService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ClienteDao clienteDao;

	public List<Cliente> obtenerTodos() {
		return clienteDao.obtenerTodos();
	}

	public void insertar(Cliente cliente) {
		cliente.setCliActivo(true);
		clienteDao.insertar(cliente);
		presentaMensaje(FacesMessage.SEVERITY_INFO, "Cliente insertado correctamente", "cerrar", true);
	}
	
	public void actualizar(Cliente cliente) {
		cliente.setCliActivo(true);
		clienteDao.actualizar(cliente);
		presentaMensaje(FacesMessage.SEVERITY_INFO, "Cliente modificado correctamente", "cerrar", true);
	}
	
	public void eliminar(Cliente cliente) {
		cliente.setCliActivo(cliente.getCliActivo() ? false : true);
		clienteDao.actualizar(cliente);

		if (cliente.getCliActivo())
			presentaMensaje(FacesMessage.SEVERITY_INFO,
					"Se activo el Cliente: " + cliente.getCliCedula() + " - " + cliente.getCliNombre()+" "+cliente.getCliApellido());
		else
			presentaMensaje(FacesMessage.SEVERITY_INFO,
					"Se dio de Baja al Cliente: " + cliente.getCliCedula() + " - " + cliente.getCliNombre()+" "+cliente.getCliApellido());
	}
	public Cliente obtenerPorCedula(String cedula) {
		return clienteDao.obtenerPorCedula(cedula);
	}

}
