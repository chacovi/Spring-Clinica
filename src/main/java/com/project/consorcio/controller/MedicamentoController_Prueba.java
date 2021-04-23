package com.project.consorcio.controller;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.consorcio.entity.Medicamento;
import com.project.consorcio.entity.TipoMedicamento;
import com.project.consorcio.service.MedicamentoService;
import com.project.consorcio.service.TipoMedicamentoService;

@Controller
@RequestMapping(value = "/medicamento")
public class MedicamentoController_Prueba {
	
	@Autowired
	private MedicamentoService medicamentoService;
	
	@Autowired
	private TipoMedicamentoService tipoMedicamentoService;
	
	@RequestMapping(value = "/registrar")
	public String registrar() {
		try {
			Medicamento bean=new Medicamento();
			bean.setNomMed("Ejemplo Prueba");
			bean.setDesMed("Prueba");
			bean.setPreMed(10.5);
			bean.setStoMed(30);
			bean.setFecFabMed(new Date());
			//crear objeto de la clase TipoMedicamento
			TipoMedicamento tipo=new TipoMedicamento();
			tipo.setCodTipo(6);
			bean.setTbTipoMedicamento(tipo);
			medicamentoService.save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "medicamento";
	}
	@RequestMapping(value = "/actualizar")
	public String actualizar() {
		try {
			Medicamento bean=new Medicamento();
			bean.setCodMed(50);
			bean.setNomMed("Ejemplo50");
			bean.setDesMed("Prueba");
			bean.setPreMed(10.5);
			bean.setStoMed(30);
			bean.setFecFabMed(new Date());
			//crear objeto de la clase TipoMedicamento
			TipoMedicamento tipo=new TipoMedicamento();
			tipo.setCodTipo(5);
			bean.setTbTipoMedicamento(tipo);
			medicamentoService.update(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "medicamento";
	}
	@RequestMapping(value = "/eliminar")
	public String eliminar() {
		try {
			medicamentoService.delete(50);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "medicamento";
	}
	@RequestMapping(value = "/buscar")
	public String buscar() {
		try {
			Medicamento med=medicamentoService.find(3);
			System.out.println(med.getCodMed()+"---"+med.getDesMed()+"---"+med.getNomMed()+"---"+med.getPreMed()+"---"+
								med.getStoMed()+"---"+med.getFecFabMed()+"---"+med.getTbTipoMedicamento().getNomTipo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "medicamento";
	}
	@RequestMapping(value = "/listar")
	public String listar() {
		try {
			List<Medicamento> lista=medicamentoService.list();
			for(Medicamento med:lista)
				System.out.println(med.getCodMed()+"---"+med.getDesMed()+"---"+med.getNomMed()+"---"+med.getPreMed()+"---"+
								med.getStoMed()+"---"+med.getFecFabMed()+"---"+med.getTbTipoMedicamento().getNomTipo());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "medicamento";
	}
	@RequestMapping(value = "/listarTipos")
	public String listarTipos() {
		try {
			List<TipoMedicamento> lista=tipoMedicamentoService.listAll();
			for(TipoMedicamento tipo:lista)
				System.out.println(tipo.getCodTipo()+"---"+tipo.getNomTipo());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "medicamento";
	}
}
