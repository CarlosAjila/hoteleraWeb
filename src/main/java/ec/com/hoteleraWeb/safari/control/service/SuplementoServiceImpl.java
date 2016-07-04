package ec.com.hoteleraWeb.safari.control.service;

import static ec.com.hoteleraWeb.safari.utils.UtilsAplicacion.presentaMensaje;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.control.dao.SuplementoDao;
import ec.com.hoteleraWeb.safari.control.entity.Suplemento;

@Service
public class SuplementoServiceImpl implements SuplementoService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SuplementoDao suplementoDao;

	public List<Suplemento> obtenerPorHotel(String codigoHotel) {
		return suplementoDao.obtenerSuplementosPorHotel(codigoHotel);
	}

	public void insertar(Suplemento suplemento) {
		suplemento.setSupActivo(true);
		suplementoDao.insertar(suplemento);
		presentaMensaje(FacesMessage.SEVERITY_INFO, "Empleado insertado correctamente", "cerrar", true);
	}

	public void actualizar(Suplemento suplemento) {
		suplemento.setSupActivo(true);
		suplementoDao.insertar(suplemento);
		presentaMensaje(FacesMessage.SEVERITY_INFO, "Empleado modificado correctamente", "cerrar", true);
	}

	public void eliminar(Suplemento suplemento) {
		suplemento.setSupActivo(suplemento.getSupActivo() ? false : true);
		suplementoDao.actualizar(suplemento);

		if (suplemento.getSupActivo())
			presentaMensaje(FacesMessage.SEVERITY_INFO, "Se activo el Empleado: " + suplemento.getSupDetalle());
		else
			presentaMensaje(FacesMessage.SEVERITY_INFO, "Se desactivo al Hotel: " + suplemento.getSupDetalle());
	}

}
