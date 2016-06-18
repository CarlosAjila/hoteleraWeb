package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.Cliente;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;
import ec.com.hoteleraWeb.safari.utils.dao.GenericSQLDao;

@Repository
public class ClienteDaoImpl extends GenericDaoImpl<Cliente, Integer> implements ClienteDao, Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	private GenericSQLDao genericSQLDao;

	public List<Cliente> obtenerTodos() {
		String sql = "Select * FROM public.cliente";
		return genericSQLDao.obtenerPorSql(sql, Cliente.class);
	}
}