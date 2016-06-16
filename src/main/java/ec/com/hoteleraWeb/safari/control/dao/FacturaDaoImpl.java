package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.Factura;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;

@Repository
public class FacturaDaoImpl extends GenericDaoImpl<Factura, Integer> implements FacturaDao, Serializable {

	private static final long serialVersionUID = 1L;
}