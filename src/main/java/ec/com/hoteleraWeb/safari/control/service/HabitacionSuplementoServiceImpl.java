package ec.com.hoteleraWeb.safari.control.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.control.dao.HabitacionSuplementoDao;
import ec.com.hoteleraWeb.safari.control.entity.HabitacionSuplemento;

@Service
public class HabitacionSuplementoServiceImpl implements HabitacionSuplementoService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	HabitacionSuplementoDao habitacionSuplementoDao;

	public void insertar(List<HabitacionSuplemento> listaHabitacionesSuplementos) {
		for (HabitacionSuplemento habitacionSuplemento : listaHabitacionesSuplementos) {
			habitacionSuplementoDao.insertar(habitacionSuplemento);
		}
	}

	public void actualizar(List<HabitacionSuplemento> listaHabitacionesSuplementos) {
		for (HabitacionSuplemento habitacionSuplemento : listaHabitacionesSuplementos) {
			habitacionSuplementoDao.actualizar(habitacionSuplemento);
		}
	}

}
