package ec.com.hoteleraWeb.safari.control.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entity.Factura;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;
import ec.com.hoteleraWeb.safari.utils.dao.GenericSQLDao;

@Repository
public class FacturaDaoImpl extends GenericDaoImpl<Factura, Integer> implements FacturaDao, Serializable {

	@Autowired
	private GenericSQLDao genericSQLDao;
	private static final long serialVersionUID = 1L;

	public List<Factura> obtenerTodos() {
		String sql = "Select * FROM public.factura";
		return genericSQLDao.obtenerPorSql(sql, Factura.class);
	}

	public List<Factura> obtenerPorHotel(Integer codigoHotel) {
		String sql = "select distinct f.* from factura f " + "inner join reservacion r on r.res_codigo=f.res_codigo "
				+ "inner join habitacion_detalle hd on hd.res_codigo=r.res_codigo "
				+ "inner join habitacion h on h.hab_codigo=hd.hab_codigo " + "where h.hot_codigo='" + codigoHotel + "'";
		return genericSQLDao.obtenerPorSql(sql, Factura.class);
	}

	public List<Factura> obtenerPorReservacion(Integer codigoReservacion) {
		String sql = "select distinct a.* from actividad a "
				+ "inner join cliente_actividad ca on ca.act_codigo=a.act_codigo "
				+ "inner join reservacion r on r.res_codigo=ca.res_codigo " + "where r.res_codigo='" + codigoReservacion
				+ "' order by a.act_codigo;";
		List<Factura> facturas = new ArrayList<Factura>();
		facturas = genericSQLDao.obtenerPorSql(sql, Factura.class);
		if (facturas != null)
			if (facturas.size() != 0)
				return facturas;
		return null;
	}

}