package ec.com.hoteleraWeb.safari.control.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ec.com.hoteleraWeb.safari.control.entityAux.FacturaTO;
import ec.com.hoteleraWeb.safari.utils.dao.GenericDaoImpl;
import ec.com.hoteleraWeb.safari.utils.dao.GenericSQLDao;

@Repository
public class FacturaTODaoImpl extends GenericDaoImpl<FacturaTO, Integer> implements FacturaTODao {

	@Autowired
	private GenericSQLDao genericSQLDao;

	public FacturaTO obtenerTotalesFactura(Integer codigoHotel, Integer codigoReservacion) {
		String sql = "SELECT * from fun_totales_factura(" + codigoHotel + "," + codigoReservacion + ");";
		FacturaTO facturaTO = new FacturaTO();
		facturaTO = genericSQLDao.obtenerPorSql(sql, FacturaTO.class).get(0);
		if (facturaTO != null)
			return facturaTO;
		return null;
	}

}