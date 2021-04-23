package com.project.consorcio.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.consorcio.dao.TipoMedicamentoDAO;
import com.project.consorcio.entity.TipoMedicamento;

@Service
public class TipoMedicamentoServiceImp implements TipoMedicamentoService {

	@Autowired
	private TipoMedicamentoDAO tipoMedicamentoDAO;
	
	@Override
	public List<TipoMedicamento> listAll() {
		// TODO Auto-generated method stub
		return tipoMedicamentoDAO.listAll();
	}

}
