package ec.com.hoteleraWeb.safari.control.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.control.dao.EmpleadoDao;
import ec.com.hoteleraWeb.safari.control.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private EmpleadoDao empleadoDao;

	public List<Empleado> obtenerTodos() {
		return empleadoDao.obtenerTodos();
	}

}
