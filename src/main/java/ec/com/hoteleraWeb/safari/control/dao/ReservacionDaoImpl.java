package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.Reservacion;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;

@Repository
public class ReservacionDaoImpl extends GenericDaoImpl<Reservacion, Integer>
		implements ReservacionIvaDao, Serializable {

	private static final long serialVersionUID = 1L;
}