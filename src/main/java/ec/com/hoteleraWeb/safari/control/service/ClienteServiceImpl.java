package ec.com.hoteleraWeb.safari.control.service;

import static ec.com.hoteleraWeb.safari.utils.UtilsAplicacion.presentaMensaje;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

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
			presentaMensaje(FacesMessage.SEVERITY_INFO, "Se activo el Cliente: " + cliente.getCliCedula() + " - "
					+ cliente.getCliNombre() + " " + cliente.getCliApellido());
		else
			presentaMensaje(FacesMessage.SEVERITY_INFO, "Se dio de Baja al Cliente: " + cliente.getCliCedula() + " - "
					+ cliente.getCliNombre() + " " + cliente.getCliApellido());
	}

	public Cliente obtenerPorCedula(String cedula) {
		return clienteDao.obtenerPorCedula(cedula);
	}

	public List<String> obtenerListaClientesAutoComplete(String criterioClienteBusqueda) {
		List<String> list = new ArrayList<String>();
		List<Cliente> lista = obtener(criterioClienteBusqueda);
		if (!lista.isEmpty())
			for (Cliente e : lista)
				list.add(e.getCliCedula() + " - " + e.getCliApellido() + " " + e.getCliNombre());
		return list;
	}

	public Cliente cargarCliente(String cliente) {
		return obtenerClientePorCedula(cliente.split(" - ")[0]);
	}

	public List<Cliente> obtener(String criterioCliente) {
		List<Cliente> lista = new ArrayList<Cliente>();
		if ((criterioCliente == null || criterioCliente.compareToIgnoreCase("") == 0))
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "INGRESE UN CRITERIO DE BÚSQUEDA VALIDO");
		else if (criterioCliente != null && criterioCliente.length() >= 3)
			lista = clienteDao.obtenerPorHql(
					"select c from Cliente c where (c.cliCedula like ?1 or c.cliNombre like ?1 or c.cliApellido like ?1) and c.cliActivo=true",
					new Object[] { "%" + criterioCliente.toUpperCase() + "%" });

		if (lista.isEmpty())
			presentaMensaje(FacesMessage.SEVERITY_WARN, "NO SE ENCONTRO NINGUNA COINCIDENCIA");

		return lista;
	}

	public Cliente obtenerClientePorCedula(String cedula) {
		List<Cliente> lista = clienteDao.obtenerPorHql(
				"select c from Cliente c where c.cliCedula=?1 and c.cliActivo=true", new Object[] { cedula });
		if (!lista.isEmpty())
			return lista.get(0);
		return null;
	}

}
