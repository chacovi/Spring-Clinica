package com.project.consorcio.service;
import java.util.List;
import com.project.consorcio.entity.Medicamento;

public interface MedicamentoService {
	public void save(Medicamento bean);
	public void update(Medicamento bean);
	public void delete(int cod);
	public Medicamento find(int cod);
	public List<Medicamento> list();
}

