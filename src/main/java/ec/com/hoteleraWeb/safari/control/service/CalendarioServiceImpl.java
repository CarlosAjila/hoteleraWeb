package ec.com.hoteleraWeb.safari.control.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.control.dao.CalendarioDao;
import ec.com.hoteleraWeb.safari.control.entity.Calendario;

@Service
public class CalendarioServiceImpl implements CalendarioService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CalendarioDao calendarioDao;

	public List<Calendario> obtenerTodos() {
		return calendarioDao.obtenerTodos();
	}
}
