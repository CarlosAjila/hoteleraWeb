package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.Empleado;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;
import ec.com.hoteleraWeb.safari.utils.dao.GenericSQLDao;

@Repository
public class EmpleadoDaoImpl extends GenericDaoImpl<Empleado, Integer> implements EmpleadoDao, Serializable {

	@Autowired
	private GenericSQLDao genericSQLDao;
	private static final long serialVersionUID = 1L;
	//
	// public void insertar(Empleado empleado, Integer hotCodigo) {
	// insertar(empleado);
	// }

	public List<Empleado> obtenerTodos() {
		String sql = "Select * FROM public.empleado order by emp_apellido";
		return genericSQLDao.obtenerPorSql(sql, Empleado.class);

	}

	public List<Empleado> obtenerEmpleadosPorHotel(String codigoHotel) {
		String sql = "Select * FROM empleado where hot_codigo='" + codigoHotel + "' ORDER BY emp_cedula;";
		return genericSQLDao.obtenerPorSql(sql, Empleado.class);
	}

	public List<Empleado> obtenerEmpleadosHotel(int hotCodigo) {
		String sql = "Select * FROM public.empleado order by emp_apellido WHERE hot_codigo = " + hotCodigo;
		return genericSQLDao.obtenerPorSql(sql, Empleado.class);

	}

	public Empleado obtenerPorCedula(String cedula) {
		String sql = "select * from empleado where emp_cedula='" + cedula + "'";
		return genericSQLDao.obtenerObjetoPorSql(sql, Empleado.class);

	}

	public Empleado obtenerPorCedula_Codigo(String cedula, Integer hotCodigo) {
		String sql = "select * from empleado where emp_cedula='" + cedula + "' and hot_codigo= " + hotCodigo;
		return genericSQLDao.obtenerObjetoPorSql(sql, Empleado.class);
	}
}