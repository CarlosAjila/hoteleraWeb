package ec.com.hoteleraWeb.safari.control.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ec.com.hoteleraWeb.safari.control.entity.Cliente;
import ec.com.hoteleraWeb.safari.control.service.ClienteService;

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

	public void limpiarObjetos() {
		cliente = new Cliente();
		listaClientes = new ArrayList<Cliente>();
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
