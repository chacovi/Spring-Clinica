package com.project.consorcio.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.consorcio.dao.MedicamentoDAO;
import com.project.consorcio.entity.Medicamento;

@Service
public class MedicamentoServiceImpl implements MedicamentoService{
	
	@Autowired
	private MedicamentoDAO medicamentoDAO;
	
	
	@Override
	public void save(Medicamento bean) {
		medicamentoDAO.save(bean);
		
	}

	@Override
	public void update(Medicamento bean) {
		medicamentoDAO.update(bean);
		
	}

	@Override
	public void delete(int cod) {
		medicamentoDAO.delete(cod);
		
	}

	@Override
	public Medicamento find(int cod) {
		// TODO Auto-generated method stub
		return medicamentoDAO.find(cod);
	}

	@Override
	public List<Medicamento> list() {
		// TODO Auto-generated method stub
		return medicamentoDAO.list();
	}

}
