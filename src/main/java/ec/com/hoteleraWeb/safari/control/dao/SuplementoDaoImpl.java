package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.Suplemento;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;

@Repository
public class SuplementoDaoImpl extends GenericDaoImpl<Suplemento, Integer> implements SuplementoDao, Serializable {

	private static final long serialVersionUID = 1L;
}