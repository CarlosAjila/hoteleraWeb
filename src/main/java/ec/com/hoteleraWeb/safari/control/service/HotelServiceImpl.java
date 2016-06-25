package ec.com.hoteleraWeb.safari.control.service;

import static ec.com.hoteleraWeb.safari.utils.UtilsAplicacion.presentaMensaje;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;

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

	public List<Hotel> obtenerTodosPorUsuario(String nick) {
		return hotelDao.obtenerTodosPorUsuario(nick);
	}

	public Hotel obtenerPorRuc(String ruc) {
		return hotelDao.obtenerPorRuc(ruc);
	}

	public Hotel obtenerPorRuc_Codigo(String ruc, Integer codigo) {
		return hotelDao.obtenerPorRuc_Codigo(ruc, codigo);
	}

	public Hotel obtenerPorCodigo(String codigo) {
		return hotelDao.obtenerPorCodigo(codigo);
	}

	public void insertar(Hotel hotel) {
		hotel.setHotActivo(true);
		hotelDao.insertar(hotel);
		presentaMensaje(FacesMessage.SEVERITY_INFO, "Hotel insertado correctamente", "cerrar", true);
	}

	public void actualizar(Hotel hotel) {
		hotel.setHotActivo(true);
		hotelDao.actualizar(hotel);
		presentaMensaje(FacesMessage.SEVERITY_INFO, "Hotel modificado correctamente", "cerrar", true);
	}

	public void eliminar(Hotel hotel) {
		hotel.setHotActivo(hotel.getHotActivo() ? false : true);
		hotelDao.actualizar(hotel);

		if (hotel.getHotActivo())
			presentaMensaje(FacesMessage.SEVERITY_INFO,
					"Se activo al Hotel: " + hotel.getHotRuc() + " - " + hotel.getHotNombre());
		else
			presentaMensaje(FacesMessage.SEVERITY_INFO,
					"Se desactivo al Hotel: " + hotel.getHotRuc() + " - " + hotel.getHotNombre());
	}

}
