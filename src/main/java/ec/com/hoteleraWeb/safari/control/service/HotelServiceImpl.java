package ec.com.hoteleraWeb.safari.control.service;

import static ec.com.hoteleraWeb.safari.utils.UtilsAplicacion.presentaMensaje;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.hoteleraWeb.safari.control.dao.HotelDao;
import ec.com.hoteleraWeb.safari.control.entity.Hotel;

@Service
public class HotelServiceImpl implements HotelService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private HotelDao hotelDao;

	public List<Hotel> obtenerTodos() {
		return hotelDao.obtenerTodos();
	}

	public Hotel obtenerPorRuc(String ruc) {
		return hotelDao.obtenerPorRuc(ruc);
	}

	public Hotel insertarActualizar(Hotel hotel) {
		boolean retorno = false;
		if (hotel.getHotCodigo() == null)
			retorno = insertar(hotel);
		else
			retorno = actualizar(hotel);

		if (retorno)
			presentaMensaje(FacesMessage.SEVERITY_INFO, "CHOFER INSERTADO CORRECTAMENTE", "cerrar", true);

		return hotel;

	}

	public boolean insertar(Hotel hotel) {
		boolean retorno = false;
		if (hotelDao.comprobarIndices(Chofer.class, "cedula", chofer.getCedula(), String.valueOf(chofer.getId())))
			presentaMensaje(FacesMessage.SEVERITY_INFO, "LA CÉDULA YA EXISTE", "cerrar", false);
		else {
			chofer.setActivo(true);
			chofer.setPassword(generarClave(chofer.getCedula()));
			choferDao.insertar(chofer);
			retorno = true;
		}
		return retorno;
	}

	public boolean actualizar(Chofer chofer) {
		boolean retorno = false;
		Set<ConstraintViolation<Chofer>> violationsChofer = validator.validate(chofer);
		if (violationsChofer.size() > 0)
			for (ConstraintViolation<Chofer> cv : violationsChofer)
				presentaMensaje(FacesMessage.SEVERITY_INFO, cv.getMessage());
		else if (choferDao.comprobarIndices(Chofer.class, "cedula", chofer.getCedula(), String.valueOf(chofer.getId())))
			presentaMensaje(FacesMessage.SEVERITY_INFO, "LA CÉDULA YA EXISTE", "cerrar", false);
		else {
			chofer.setPassword(generarClave(chofer.getCedula()));
			choferDao.actualizar(chofer);
			presentaMensaje(FacesMessage.SEVERITY_INFO, "CHOFER ACTUALIZADO", "cerrar", true);
			retorno = true;
		}
		return retorno;
	}

}
