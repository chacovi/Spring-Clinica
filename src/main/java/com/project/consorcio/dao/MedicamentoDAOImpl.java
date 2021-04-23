package com.project.consorcio.dao;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.project.consorcio.entity.Medicamento;

@Repository
public class MedicamentoDAOImpl implements MedicamentoDAO{

	//atributo de conexión
	@Autowired
	private SessionFactory factory;
	
	@Transactional
	@Override
	public void save(Medicamento bean) {
		//crear un objeto de la clase Session para gestionar una sesión de la conexíon "factory"
		Session session=factory.getCurrentSession();
		try {
			session.save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional
	@Override
	public void update(Medicamento bean) {
		Session session=factory.getCurrentSession();
		try {
			session.update(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Transactional
	@Override
	public void delete(int cod) {
		Session session=factory.getCurrentSession();
		try {
			//buscar el Medicamento según "cod"
			Medicamento bean=session.get(Medicamento.class, cod);
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Transactional(readOnly = true)
	@Override
	public Medicamento find(int cod) {
		Session session=factory.getCurrentSession();
		Medicamento bean=null;
		try {
			//buscar el Medicamento según "cod"
			bean=session.get(Medicamento.class, cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Medicamento> list() {
		Session session=factory.getCurrentSession();
		Query query=null;
		try {
			String hql="select m from Medicamento m";
			query=session.createQuery(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

}
