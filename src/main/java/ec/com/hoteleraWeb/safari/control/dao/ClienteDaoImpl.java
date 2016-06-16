package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.Cliente;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;

@Repository
public class ClienteDaoImpl extends GenericDaoImpl<Cliente, Integer> implements ClienteDao, Serializable {

	private static final long serialVersionUID = 1L;
}