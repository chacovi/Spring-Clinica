package com.project.consorcio.dao;
import java.util.List;
import com.project.consorcio.entity.Medicamento;

public interface MedicamentoDAO {
	public void save(Medicamento bean);
	public void update(Medicamento bean);
	public void delete(int cod);
	public Medicamento find(int cod);
	public List<Medicamento> list();
}

