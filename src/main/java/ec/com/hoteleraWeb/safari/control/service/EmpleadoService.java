package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Empleado;

public interface EmpleadoService {

	@Transactional
	public List<Empleado> obtenerTodos();

	@Transactional
	public List<Empleado> obtenerEmpleadosHotel(int hotCodigo);

	@Transactional
	public Empleado obtenerPorCedula(String cedula);

	@Transactional
	public void insertar(Empleado empleado, Integer hotCodigo);

	@Transactional
	public void actualizar(Empleado empleado);

	@Transactional
	public void eliminar(Empleado empleado);

	@Transactional
	public Empleado obtenerPorCedula_Codigo(String cedula, Integer hotCodigo);

	@Transactional
	public List<String> obtenerListaEmpleadosAutoComplete(String criterioEmpleadoBusqueda);

	@Transactional
	public Empleado cargarEmpleado(String empleado);

	@Transactional
	public List<Empleado> obtener(String criterioEmpleado);

	@Transactional
	public Empleado obtenerPorEmpleadoId(Integer empleadoId);
}