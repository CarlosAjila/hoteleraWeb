package ec.com.hoteleraWeb.safari.control.controller;

import static ec.com.hoteleraWeb.safari.utils.UtilsAplicacion.presentaMensaje;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ec.com.hoteleraWeb.safari.control.entity.Cliente;
import ec.com.hoteleraWeb.safari.control.service.ClienteService;
import ec.com.hoteleraWeb.safari.utils.Utils;

@Controller
@Scope("session")
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ClienteService clienteService;

	private List<Cliente> listaClientes;
	private Cliente cliente;

	public ClienteBean() {
	}

	@PostConstruct
	public void init() {
		limpiarObjetos();
		obtenerClientes();
	}

	public void cargarInsertar() {
		limpiarObjetos();

	}

	public void limpiarObjetos() {
		cliente = new Cliente();
		listaClientes = new ArrayList<Cliente>();
	}

	public void insertar(ActionEvent actionEvent) {

		if (comprobarClienteInsertar()) {
			if (cliente.getCliNombre().isEmpty())
				presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar el nombre del Cliente");
			else if (cliente.getCliApellido().isEmpty())
				presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar el apellido del Cliente");
			else
				clienteService.insertar(cliente);
			obtenerClientes();
		}
	}

	public void actualizar(ActionEvent actionEvent) {
		if (comprobarClienteActualizar()) {
			if (cliente.getCliNombre().isEmpty())
				presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar un Nombre");
			else if (cliente.getCliApellido().isEmpty())
				presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar el Apellido");
			else
				clienteService.actualizar(cliente);
			obtenerClientes();
		}
	}

	public boolean comprobarClienteActualizar() {
		boolean retorno = false;
		String cedula = cliente.getCliCedula().trim();
		if (Utils.comprobarCedula(cedula)) {
			if (clienteService.obtenerPorCedula(cedula) == null) {
				presentaMensaje(FacesMessage.SEVERITY_ERROR, "Ya existe un Empleado registrado con ese cedula");
			} else {
				cliente.setCliCedula(cedula);
				retorno = true;
			}
		} else {
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar una cedula valida");
			cliente.setCliCedula("");
		}
		return retorno;
	}

	public boolean comprobarClienteInsertar() {
		boolean retorno = false;
		String cedula = cliente.getCliCedula().trim();
		if (Utils.comprobarCedula(cedula)) {
			if (clienteService.obtenerPorCedula(cedula) != null) {
				cliente.setCliCedula("");
				presentaMensaje(FacesMessage.SEVERITY_ERROR, "Ya existe un Empleado registrado con esa cédula");
			} else {
				cliente.setCliCedula(cedula);
				retorno = true;
			}
		} else {
			presentaMensaje(FacesMessage.SEVERITY_ERROR, "Debe ingresar una cedula valido");
			cliente.setCliCedula("");
		}
		return retorno;
	}

	public void obtenerClientes() {
		listaClientes = clienteService.obtenerTodos();
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
