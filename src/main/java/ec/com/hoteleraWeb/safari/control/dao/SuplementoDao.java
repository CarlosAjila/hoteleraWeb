package ec.com.hoteleraWeb.safari.control.dao;

import java.util.List;

import ec.com.hoteleraWeb.safari.control.entity.Suplemento;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDao;

public interface SuplementoDao extends GenericDao<Suplemento, Integer> {

	public List<Suplemento> obtenerSuplementosPorHotel(String codigoHotel);

}
