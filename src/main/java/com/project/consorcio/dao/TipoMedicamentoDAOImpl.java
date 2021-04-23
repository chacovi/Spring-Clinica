package com.project.consorcio.dao;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.project.consorcio.entity.TipoMedicamento;

@Repository
public class TipoMedicamentoDAOImpl implements TipoMedicamentoDAO{
	@Autowired
	private SessionFactory factory;
	
	@Transactional(readOnly = true)
	@Override
	public List<TipoMedicamento> listAll() {
		Session session=factory.getCurrentSession();
		Query query=null;
		try {
			String hql="select tp from TipoMedicamento tp";
			query=session.createQuery(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

}
