package ec.com.hoteleraWeb.safari.utils.dao;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GenericSQLDaoImpl implements GenericSQLDao {

	@Autowired
	public SessionFactory sessionFactory;

	@SuppressWarnings({ "hiding", "unchecked" })
	public <T> List<T> obtenerPorSql(String consulta, Class<T> type) {
		Query query = (Query) session().createSQLQuery(consulta).addEntity(type.getName());
		return query.list();
	}

	@SuppressWarnings({ "hiding", "unchecked" })
	public <T> List<T> obtenerPorSql(String consulta) {
		Query query = (Query) session().createSQLQuery(consulta);
		return query.list();
	}

	@SuppressWarnings({ "hiding", "unchecked" })
	public <T> T obtenerObjetoPorSql(String consulta, Class<T> type) {
		Query query = (Query) session().createSQLQuery(consulta).addEntity(type.getName());
		List<T> list = query.list();
		System.out.println("list: " + list);
		return list == null || list.isEmpty() ? null : list.get(0);
	}

	@SuppressWarnings("unchecked")
	public Object obtenerObjetoPorSql(String consulta) {
		Query query = (Query) session().createSQLQuery(consulta);
		List<T> list = query.list();
		return list == null || list.isEmpty() ? null : list.get(0);
	}

	public int actualizar(String consulta) {
		Query query = (Query) session().createSQLQuery(consulta);
		return query.executeUpdate();
	}

	public int eliminar(String consulta) {
		Query query = (Query) session().createSQLQuery(consulta);
		return query.executeUpdate();
	}

	public Session session() {
		return sessionFactory.getCurrentSession();
	}
}