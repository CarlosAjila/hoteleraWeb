package ec.com.hoteleraWeb.safari.control.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.control.dao.ActividadDao;
import ec.com.hoteleraWeb.safari.control.entity.Actividad;

@Service
public class ActividadServiceImpl implements ActividadService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ActividadDao actividadDao;

	public List<Actividad> obtenerTodos() {
		return actividadDao.obtenerTodos();
	}

}
