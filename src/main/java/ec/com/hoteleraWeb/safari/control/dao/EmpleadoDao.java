package ec.com.hoteleraWeb.safari.control.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Empleado;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDao;

public interface EmpleadoDao extends GenericDao<Empleado, Integer> {

	// @Transactional
	// public void insertar(Empleado empleado, Integer hotCodigo);

	@Transactional
	public List<Empleado> obtenerTodos();

	@Transactional
	public List<Empleado> obtenerEmpleadosPorHotel(String codigoHotel);

	@Transactional
	public List<Empleado> obtenerEmpleadosHotel(int hotCodigo);

	@Transactional
	public Empleado obtenerPorCedula(String cedula);

	@Transactional
	public Empleado obtenerPorCedula_Codigo(String cedula, Integer hotCodigo);

}
