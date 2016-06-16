package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.PorcentajeIva;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;

@Repository
public class PorcentajeIvaDaoImpl extends GenericDaoImpl<PorcentajeIva, Integer>
		implements PorcentajeIvaDao, Serializable {

	private static final long serialVersionUID = 1L;
}