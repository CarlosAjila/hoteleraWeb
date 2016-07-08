package ec.com.hoteleraWeb.safari.control.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.control.dao.HabitacionDetalleDao;
import ec.com.hoteleraWeb.safari.control.entity.HabitacionDetalle;

@Service
public class HabitacionDetalleServiceImpl implements HabitacionDetalleService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	HabitacionDetalleDao habitacionDetalleDao;

	public void insertar(List<HabitacionDetalle> listaHabitacionesDetalle) {
		for (HabitacionDetalle habitacionDetalle : listaHabitacionesDetalle) {
			habitacionDetalleDao.insertar(habitacionDetalle);
		}
	}

	public void actualizar(List<HabitacionDetalle> listaHabitacionesDetalle) {
		for (HabitacionDetalle habitacionDetalle : listaHabitacionesDetalle) {
			habitacionDetalleDao.actualizar(habitacionDetalle);
		}
	}

}
