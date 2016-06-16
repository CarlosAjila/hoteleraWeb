package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.Empleado;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;

@Repository
public class EmpleadoDaoImpl extends GenericDaoImpl<Empleado, Integer> implements EmpleadoDao, Serializable {

	private static final long serialVersionUID = 1L;
}